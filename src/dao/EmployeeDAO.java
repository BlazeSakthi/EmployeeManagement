package dao;

import database.DBConnection;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (name, age, department, salary, joining_date, designation) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getJoiningDate());
            statement.setString(6, employee.getDesignation());
            statement.executeUpdate();

            System.out.println("✅ Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllEmployees() {
        String query = "SELECT * FROM employees";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("emp_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("joining_date"),
                        resultSet.getString("designation")
                );
                employees.add(employee);
            }
            if (employees.isEmpty()) {
                System.out.println("⚠️ No employees found!");
            } else {
                System.out.println("======================= Employee List =======================");
                System.out.println("--------------------------------------------------------------");
                employees.forEach(System.out::println);
                System.out.println("--------------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId) {
        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, empId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Employee deleted successfully!");
            } else {
                System.out.println("❌ Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    

    public void updateEmployee(int empId, String name, int age, String department, double salary, String joiningDate, String designation) {
        String query = "UPDATE employees SET name = ?, age = ?, department = ?, salary = ?, joining_date = ?, designation = ? WHERE emp_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, department);
            statement.setDouble(4, salary);
            statement.setString(5, joiningDate);
            statement.setString(6, designation);
            statement.setInt(7, empId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Employee updated successfully!");
            } else {
                System.out.println("❌ Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchEmployee(String query) {
        String sql = "SELECT * FROM employees WHERE name LIKE ? OR department LIKE ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");
            ResultSet resultSet = statement.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("emp_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("joining_date"),
                        resultSet.getString("designation")
                ));
            }
            if (employees.isEmpty()) {
                System.out.println("⚠️ No matching employees found.");
            } else {
                employees.forEach(System.out::println);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortEmployees(int choice) {
        String orderBy = "";
        switch (choice) {
            case 1: orderBy = "salary"; break;
            case 2: orderBy = "age"; break;
            case 3: orderBy = "department"; break;
            default: System.out.println("❌ Invalid choice."); return;
        }
        String query = "SELECT * FROM employees ORDER BY " + orderBy;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("emp_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("joining_date"),
                        resultSet.getString("designation")
                ));
            }
            employees.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateReport() {
        System.out.println("Generating Report...");
    }
}
