package com.geybriyel.business;

import com.geybriyel.business.dao.OrderDAO;
import com.geybriyel.business.entity.JobOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(OrderDAO orderDAO) {
		return runner -> {
			saveOrder(orderDAO);
		};
	}

	private void saveOrder(OrderDAO orderDAO) {
		JobOrder tempOrder = new JobOrder();
		tempOrder.setFirstName("Migo");
		tempOrder.setLastName("Mogul");
		tempOrder.setPhoneNumber("09090909909");
		tempOrder.setTelephoneNumber("0000000");
		tempOrder.setAddress("Migo Street");

		orderDAO.save(tempOrder);
		System.out.println("Order saved.");
	}
}
