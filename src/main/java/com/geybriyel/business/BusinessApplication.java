package com.geybriyel.business;

import com.geybriyel.business.dao.OrderDAO;
import com.geybriyel.business.entity.RepairJO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(OrderDAO orderDAO) {
		return runner -> {
//			saveOrder(orderDAO);
//			findOrderById(orderDAO);
//			findOrderByLastName(orderDAO);
//			findAllOrders(orderDAO);
//			updateOrder(orderDAO);
//			deleteOrder(orderDAO);
//			deleteAllOrders(orderDAO);

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
			System.out.println("5: Delete an order by JO");
			System.out.println("6: Delete all orders");
			System.out.println("7: Quit");
			System.out.print("Enter transaction: ");
			transactionType = scanner.nextInt();
		} while (transactionType < 1 || transactionType > 7);

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
	private void deleteAllOrders(OrderDAO orderDAO) {
		System.out.println("Deleting all orders...");
		int numDeleted = orderDAO.deleteAll();
		System.out.println(numDeleted + " orders deleted");
	}

	private void deleteOrder(OrderDAO orderDAO) {
		int id = 1;
		orderDAO.delete(id);
		System.out.println("Order deleted...");
	}

	private void updateOrder(OrderDAO orderDAO) {
		int id = 1;
		System.out.println("To update: order #" + id + ": " + orderDAO.findById(id));
		RepairJO order = orderDAO.findById(id);
		order.setLastName("...UPDATING...");
		orderDAO.update(order);
		System.out.println("Updated: " + orderDAO.findById(id));
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
