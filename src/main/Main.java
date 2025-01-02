package main;

import dao.EmployeeDAO;
import model.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {
            printHeader();
            System.out.println("1. View All Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Sort Employees");
            System.out.println("7. Generate Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    employeeDAO.viewAllEmployees();
                    break;
                case 2:
                    addEmployee(scanner, employeeDAO);
                    break;
                case 3:
                    deleteEmployee(scanner, employeeDAO);
                    break;
                case 4:
                    updateEmployee(scanner, employeeDAO);
                    break;
                case 5:
                    searchEmployee(scanner, employeeDAO);
                    break;
                case 6:
                    sortEmployees(scanner, employeeDAO);
                    break;
                case 7:
                    employeeDAO.generateReport();
                    break;
                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private static void printHeader() {
        System.out.println("==================================================");
        System.out.println("              Employee Management System          ");
        System.out.println("==================================================");
    }

    private static void addEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println("\nEnter Employee Name (e.g., John Doe): ");
        String name = scanner.nextLine();
        System.out.println("Enter Employee Age (e.g., 30): ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Employee Department (e.g., IT): ");
        String department = scanner.nextLine();
        System.out.println("Enter Employee Salary (e.g., 60000.00): ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Employee Joining Date (YYYY-MM-DD): ");
        String joiningDate = scanner.nextLine();
        if (!isValidDate(joiningDate)) {
            System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
            return;
        }
        System.out.println("Enter Employee Designation (e.g., Developer): ");
        String designation = scanner.nextLine();

        Employee employee = new Employee(name, age, department, salary, joiningDate, designation);
        employeeDAO.addEmployee(employee);
    }

    private static void deleteEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println("\nEnter Employee ID to delete: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        employeeDAO.deleteEmployee(deleteId);
    }

    private static void updateEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println("\nEnter Employee ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter New Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter New Age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter New Department: ");
        String newDepartment = scanner.nextLine();
        System.out.println("Enter New Salary: ");
        double newSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter New Joining Date (YYYY-MM-DD): ");
        String newJoiningDate = scanner.nextLine();
        if (!isValidDate(newJoiningDate)) {
            System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
            return;
        }
        System.out.println("Enter New Designation: ");
        String newDesignation = scanner.nextLine();

        employeeDAO.updateEmployee(updateId, newName, newAge, newDepartment, newSalary, newJoiningDate, newDesignation);
    }

    private static void searchEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println("\nEnter name or department to search: ");
        String searchQuery = scanner.nextLine();
        employeeDAO.searchEmployee(searchQuery);
    }

    private static void sortEmployees(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println("\nSort by (1: Salary, 2: Age, 3: Department): ");
        int sortChoice = scanner.nextInt();
        employeeDAO.sortEmployees(sortChoice);
    }
    
    
    
    

    // Method to validate date format
    private static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
