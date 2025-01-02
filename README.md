# Employee Management System

A Java-based Employee Management System that connects to a MySQL database to manage employee records. This project provides a simple way to handle employee data, including CRUD (Create, Read, Update, Delete) operations.

## Features

- **Add new employees**: Add a new employee with details such as name, age, department, salary, and joining date.
- **View employee details**: View the details of an employee based on the search criteria.
- **Update employee information**: Modify existing employee details.
- **Delete employee records**: Remove an employee's record from the system.

## Prerequisites

- **Java 8 or higher**: Ensure that Java is installed on your machine.
- **MySQL Database**: A MySQL server must be set up to store employee records.
- **Maven (optional)**: If using Maven for dependency management.

## Database Setup

1. **Create a new MySQL database**:
   - Open MySQL Workbench or any MySQL client.
   - Run the following SQL command to create a new database:
     ```sql
     CREATE DATABASE employee_management;
     ```

2. **Import the `database_setup.sql` file**:
   - The `database_setup.sql` file contains the necessary schema and sample data to set up the required tables for the system.
   - Import it into the newly created database using the following command:
     ```bash
     mysql -u username -p employee_management < database_setup.sql
     ```
     - Replace `username` with your MySQL username.

3. **Configure the Database Connection**:
   - Open your Java project.
   - Edit the database connection settings in the `DBConnection.java` or `application.properties` file (depending on your setup).
   - Update the database URL, username, and password as per your MySQL server settings.

4. **Run the Application**:
   - Once the database is set up and the connection is configured, you can run the application.

## Project Setup

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/BlazeSakthi/EmployeeManagement.git
