package model;

public class Employee {
    private int empId;
    private String name;
    private int age;
    private String department;
    private double salary;
    private String joiningDate;
    private String designation;

    public Employee(String name, int age, String department, double salary, String joiningDate, String designation) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    public Employee(int empId, String name, int age, String department, double salary, String joiningDate, String designation) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-15s | %-4d | %-17s | %-10.2f |", empId, name, age, department, salary);
    }
}
