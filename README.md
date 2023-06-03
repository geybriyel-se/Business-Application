# Job Order Management
A RESTful API for managing job orders in a business environment.

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
## API Endpoints
- `GET /api/orders` - Retrieve a list of all job orders
- `GET /api/orders/id/{id}` - Retrieve a specific job order by its ID
- `GET /api/orders/lastname/{lastname}` - Retrieve a specific job order by customer's last name
- `POST /api/orders` - Create a new job order
- `PUT /api/orders` - Update an existing job order
- `DELETE /api/orders/delete/{id}` - Delete a job order by its ID
- `DELETE /api/orders` - Delete all job orders
## Limitations and Issues
The following are the areas that must be improved:
- Only basic customer information is stored
- Job Order Date is not properly mapped
- Better input validation of fields such as the phone number 
- Addition of Sort and Filter functionality 
- RepairJO (entity) needs a parent class to make it configurable 
- Other advanced features such as security, reporting...