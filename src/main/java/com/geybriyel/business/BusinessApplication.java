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
//			saveOrder(orderDAO);
//			findOrderById(orderDAO);
//			findOrderByLastName(orderDAO);
//			findAllOrders(orderDAO);
//			updateOrder(orderDAO);
//			deleteOrder(orderDAO);
//			deleteAllOrders(orderDAO);



			System.out.println("Welcome to BusinessName");
			System.out.println("========================");
			Scanner scanner = new Scanner(System.in);
			int transactionType;
			do {
				showMainMenu();
				transactionType = scanner.nextInt();
			} while (transactionType < 1 || transactionType > 6);

			System.out.println("You selected: " + transactionType);
			switch (transactionType) {
				case 1: {
					saveOrder(orderDAO);
					break;
				}
				case 2: {
					findOrderById(orderDAO);
				}
			}
		};
	}

	public void showMainMenu() {
		System.out.println("MENU");
		System.out.println("1: Add an order");
		System.out.println("2: Find an order by JO number");
		System.out.println("3: Find order/s based on client's last name");
		System.out.println("4: Delete an order by JO");
		System.out.println("5: Delete all orders");
		System.out.println("6: Quit");
		System.out.print("Enter transaction: ");
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
		System.out.println("Printing all orders...");
		printList(orderDAO.findAll());
	}

	private void findOrderByLastName(OrderDAO orderDAO) {
		System.out.println("...Found by last name....");
		printList(orderDAO.findByLastName("Venema"));
	}

	private void findOrderById(OrderDAO orderDAO) {
		System.out.println("Order Found...");
		System.out.println(orderDAO.findById(1));
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
