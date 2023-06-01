package com.geybriyel.business;

import com.geybriyel.business.dao.OrderDAO;
import com.geybriyel.business.entity.RepairJO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(OrderDAO orderDAO) {
		return runner -> {
			System.out.println("=======================");
			System.out.println("Welcome to BusinessName");
			System.out.println("=======================");
			showMainMenu(orderDAO);
		};
	}

	public void showMainMenu(OrderDAO orderDAO) {
		Scanner scanner = new Scanner(System.in);
		int transactionType;
		do {
			System.out.println("\nMAIN MENU");
			System.out.println("1: Add an order");
			System.out.println("2: Find an order by JO number");
			System.out.println("3: Find order/s based on client's last name");
			System.out.println("4: Show all orders");
			System.out.println("5: Update an order");
			System.out.println("6: Delete an order by JO");
			System.out.println("7: Delete all orders");
			System.out.println("8: Quit");
			System.out.print("Enter transaction: ");
			transactionType = scanner.nextInt();
		} while (transactionType < 1 || transactionType > 8);

		executeTransaction(orderDAO, transactionType);
	}

	public void executeTransaction(OrderDAO orderDAO, int transactionType) {
		switch (transactionType) {
			case 1: {
				saveOrder(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 2: {
				findOrderById(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 3: {
				findOrderByLastName(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 4: {
				findAllOrders(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 5: {
				updateOrder(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 6: {
				deleteOrder(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 7: {
				deleteAllOrders(orderDAO);
				askAnotherTransaction(orderDAO);
				break;
			}
			case 8: {
				break;
			}
		}
	}

	public void askAnotherTransaction(OrderDAO orderDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Make another transaction? y/n: ");
		String ans = scanner.nextLine();

		if (ans.equalsIgnoreCase("y")) {
			showMainMenu(orderDAO);
		}
	}

	// add functionality: to display number of entries to be deleted during confirmation
	private void deleteAllOrders(OrderDAO orderDAO) {
		System.out.println("\n...Deleting all orders...");
		System.out.print("Are you sure you want to delete ALL orders? y/n: ");
		Scanner scan = new Scanner(System.in);
		String ans = scan.nextLine();

		if (ans.equalsIgnoreCase("y")) {
			int numDeleted = orderDAO.deleteAll();
			System.out.println("\nDeleted " + numDeleted + " orders...\n");
		} else {
			showMainMenu(orderDAO);
		}
	}

	private void deleteOrder(OrderDAO orderDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n...Deleting an order...");

		System.out.print("Enter JO Number of order to be deleted: ");
		int joNumber = scanner.nextInt();

		System.out.println("Job Order to be deleted:");
		System.out.println(orderDAO.findById(joNumber));

		System.out.print("Are you sure you want to delete? y/n: ");
		Scanner scan = new Scanner(System.in);
		String ans = scan.nextLine();

		if (ans.equalsIgnoreCase("y")) {
			orderDAO.delete(joNumber);
			System.out.println("\nDeleted...\n");
		} else {
			deleteOrder(orderDAO);
		}
	}

	private void updateOrder(OrderDAO orderDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n...Updating an order...");

		System.out.print("Enter JO Number of order to be updated: ");
		int joNumber = scanner.nextInt();

		RepairJO order = orderDAO.findById(joNumber);
		System.out.println("Order Found.\n");
		System.out.println(orderDAO.findById(joNumber));

		int detailNumber = getDetailNumber();

		Scanner scan = new Scanner(System.in);
		switch (detailNumber) {

			case 1 : {
				System.out.println("\n...Updating first name...");
				System.out.print("Enter new first name: ");
				String firstName = scan.nextLine();
				order.setFirstName(firstName);
				break;
			}
			case 2 : {
				System.out.println("\n...Updating last name...");
				System.out.print("Enter new last name: ");
				String lastName = scan.nextLine();
				order.setLastName(lastName);
				break;
			}
			case 3 : {
				System.out.println("\n...Updating phone number...");
				System.out.print("Enter new phone number: ");
				String phoneNumber = scan.nextLine();
				order.setPhoneNumber(phoneNumber);
				break;
			}
			case 4 : {
				System.out.println("\n...Updating telephone number...");
				System.out.print("Enter new telephone number: ");
				String telephoneNumber = scan.nextLine();
				order.setTelephoneNumber(telephoneNumber);
				break;
			}
			case 5 : {
				System.out.println("\n...Updating address...");
				System.out.print("Enter new address: ");
				String address = scan.nextLine();
				order.setAddress(address);
				break;
			}
		}
		orderDAO.update(order);
		System.out.println("\nUpdated...\n");
		System.out.println(orderDAO.findById(joNumber));
	}

	public int getDetailNumber() {
		Scanner scanner = new Scanner(System.in);
		int detail;
		do {
			System.out.println("Detail Menu");
			System.out.println(
					"1: First Name" +
					"\n2: Last Name" +
					"\n3: Phone Number " +
					"\n4: Telephone Number" +
					"\n5: Address");
			System.out.print("Select detail to update: ");
			detail = scanner.nextInt();
		} while (detail < 1 || detail > 5);
		return detail;
	}

	private void printList(List<RepairJO> found) {
		for (RepairJO instance : found) {
			System.out.println(instance);
		}
	}
	private void findAllOrders(OrderDAO orderDAO) {
		System.out.println("\n...Retrieving all orders...");
		printList(orderDAO.findAll());
	}

	// no functionality when order is not found
	private void findOrderByLastName(OrderDAO orderDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n...Retrieving an order by Client's last name...");

		System.out.print("Enter last name: ");
		String lastName = scanner.nextLine();

		System.out.println("Order/s Found.\n");
		printList(orderDAO.findByLastName(lastName));
	}

	// no functionality to check if number exists
	private void findOrderById(OrderDAO orderDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n...Retrieving an order by JO Number...");

		System.out.print("Enter JO Number: ");
		int joNumber = scanner.nextInt();

		System.out.println("Order Found.\n");
		System.out.println(orderDAO.findById(joNumber));
	}

	private void saveOrder(OrderDAO orderDAO) {
		System.out.println("\n...Create new job order...");
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter last name: ");
		String lastName = scanner.nextLine();

		System.out.print("Enter phone number (09xxxxxxxxx): ");
		String phoneNumber = scanner.nextLine();

		System.out.print("Enter telephone number (xxxxxxx): ");
		String telephoneNumber = scanner.nextLine();

		System.out.print("Enter address: ");
		String address = scanner.nextLine();

		RepairJO JO = new RepairJO(firstName, lastName, phoneNumber, telephoneNumber, address);
		orderDAO.save(JO);

		System.out.println("\nNew job order created with the following details: ");
		System.out.println(JO);
	}
}
