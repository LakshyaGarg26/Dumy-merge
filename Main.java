import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ",salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override

    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void changes(){
        System.out.println("This is the changes done by Gurpreet");
    }
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full time Employee's name:");
        String fullTName = sc.next();
        System.out.println("Enter full time Employee's id:");
        int id = sc.nextInt();
        System.out.println("Enter full time Employee's salary:");
        int monthlySalary = sc.nextInt();

        System.out.println("Enter Part time Employee's name:");
        String partTName = sc.next();
        System.out.println("Enter Part time Employee's id:");
        id = sc.nextInt();
        System.out.println("Enter full time Employee's hoursWorked:");
        int hoursWorked = sc.nextInt();
        System.out.println("Enter full time Employee's hourlyRate:");
        int hourlyRate = sc.nextInt();
        FullTimeEmployee emp1 = new FullTimeEmployee(fullTName, id, monthlySalary);
        PartTimeEmployee emp2 = new PartTimeEmployee(partTName, id, hoursWorked, hourlyRate);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Enter the id of the employee to be removed:");
        id = sc.nextInt();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(1);

        System.out.println("Remaining Employees Details");

        payrollSystem.displayEmployees();

        changes();
    }
}
