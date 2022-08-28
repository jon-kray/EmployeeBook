package start;

import model.Employee;
import service.MemEmployeeService;

import java.util.Scanner;

public class StartUI {


    public static void main(String[] args) {
        MemEmployeeService employeeService1 = new MemEmployeeService();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {

            StartUI.showMenu();

            System.out.println("Enter value of menu.");

            int value = scanner.nextInt();

            if (value == 1) {
                System.out.println("Enter name");
                String name = scanner.next();

                System.out.println("Enter country");
                String country = scanner.next();

                Employee employee = new Employee(name, country);

                employeeService1.save(employee);

            }else if (value == 2) {
                System.out.println("Enter id");
                long id = scanner.nextLong();
                employeeService1.delete(id);
            }else if (value == 3) {
                for (Employee employee : employeeService1.findAll()) {
                    System.out.println(employee);
                }
            }else if (value == 4) {
                isRunning = false;
                System.out.println("Close program.");
            }

        }

    }

    private static void showMenu() {
        System.out.println("1. Save employee.");
        System.out.println("2. Delete employee.");
        System.out.println("3. Find all employees.");
        System.out.println("4. Close program.");
    }

}












