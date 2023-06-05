# Job Order Management API
A RESTful API for managing job orders in a business environment.
It provides endpoints for creating, reading, updating, and deleting job orders, 
enabling CRUD operations.

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
- **Flexible DAO Implementation**: DAO is configurable as it uses an interface
- **Basic Validation**: Implement validation rules using MySQL to prevent invalid input during job order creation and updates
- **Data Persistence**: Store job orders and related information in a MySQL database using Hibernate
- **Data Retrieval**: Retrieve job orders and associated data from the database for display and manipulation
- **Authentication and Authorization**: Secure the API endpoints and restrict access to authorized users or roles. 
  Implement user authentication and authorization mechanisms to ensure secure access to the API resources.

## Architecture
The Job Order Management API follows a layered architecture design, separating concerns into different components:

1. **Entity**
2. **DAO (Data Access Object)**
3. **Service**
4. **Security**
5. **Main Spring Boot Application**

## API Endpoints
- `GET /api/orders` - Retrieve a list of all job orders
  - **Authorization**: Requires the role "EMPLOYEE" for access 
- `GET /api/orders/id/{id}` - Retrieve a specific job order by its ID
  - **Authorization**: Requires the role "EMPLOYEE" for access
- `GET /api/orders/lastname/{lastname}` - Retrieve a specific job order by customer's last name
  - **Authorization**: Requires the role "EMPLOYEE" for access
- `POST /api/orders` - Create a new job order
  - **Authorization**: Requires the role "MANAGER" for access
- `PUT /api/orders` - Update an existing job order
  - **Authorization**: Requires the role "MANAGER" for access
- `DELETE /api/orders/delete/{id}` - Delete a job order by its ID
  - **Authorization**: Requires the role "ADMIN" for access
- `DELETE /api/orders` - Delete all job orders
  - **Authorization**: Requires the role "ADMIN" for access

## Limitations and Issues
The following are the areas that must be improved:
- Only basic customer information is stored
- Job Order Date is not properly mapped
- Better input validation of fields such as the phone number 
- Addition of Sort and Filter functionality 
- RepairJO (entity) needs a parent class to make it configurable

## Current Version
**Version 3.0**: Security Enhancement

In this version, the RESTful API has been enhanced with security features to ensure secure access to the application. 
The key changes and improvements in this version include:
- Integration of Spring Security for authentication and authorization
- Introduction of role-based access control to API endpoints, allowing different levels of access based on user roles. 
- Configuration of secured endpoints and permissions for specific roles. 
- Implementation of authentication mechanisms such as HTTP Basic Authentication. 
- Enhancements to protect against cross-site request forgery (CSRF) attacks.

_**NOTE**: This utilizes the default schema for JDBC-based authentication of Spring Security for seamless integration and simplified configuration._

## Previous Versions
- **Version 1.0**: Command-Line Interface (CLI)
  - The initial version of the application featured a command-line interface for interacting with the application. 
  Users could perform basic CRUD operations and navigate through the available functionalities.
- **Version 2.0**: RESTful API
  - In this version, the application has been transformed into a RESTful API, providing enhanced flexibility and scalability for managing job orders. 
    The key changes and improvements in this version include:
    - Implementation of API endpoints for creating, reading, updating, and deleting job orders
    - Addition of validation rules and error handling for better input handling

## Tools Used
- IntelliJ IDEA
- Spring Initializr
- MySQL Workbench
- Postman
- Maven

## Technologies Used
- Java
- Spring Boot
- Hibernate
- MySQL
- Spring Security