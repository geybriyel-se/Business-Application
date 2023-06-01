# Business-Application

This is a CRUD application for managing job orders in a business environment. 
The project is built using Spring Boot and Hibernate, and it is connected to a MySQL database. 
The current implementation provides a command-line interface to interact with the application.

## Features
- **Job Order Creation**: Create new job orders with customer details
- **Job Order Listing**: Display the list of all existing orders
- **Job Order Updating**: Update job orders by modifying information
- **Job Order Deletion**: Delete job orders that are no longer needed
	- all existing job orders
	- specific job order number
- **Search Functionality**: Provide a search feature to find specific job orders based on various criteria 
	- job order number
	- customer's last name
- DAO is configurable as it uses an interface
- **Basic Validation**: Implement validation rules using MySQL to prevent invalid input during job order creation and updates
- **Command-line Interface**: Provide a command-line interface for interacting with the CRUD operations
- **Data Persistence**: Store job orders and related information in a MySQL database using Hibernate
- **Data Retrieval**: Retrieve job orders and associated data from the database for display and manipulation

## Limitations and Issues
The following are the areas that must be improved
- Currently, users can only interact with the app using the command line interface
- Only basic customer information is stored
- Job Order Date is not properly mapped
- Exception Handling is not implemented
- Problem with the Scanner object
- Better input validation of fields such as the phone number
- Addition of Sort and Filter functionality
- RepairJO (entity) needs a parent class to make it configurable
- Other advanced features such as security, reporting...

## Dev Tools Used
1. IntelliJ IDEA
2. MySQL Workbench

## Dev Technologies Used
1. MySQL
2. Spring Boot
3. Hibernate
4. Dependencies:
    - SpringBoot Dev Tools
    - Spring Data JPA
    - MySQL Driver
    - Spring Initializr
