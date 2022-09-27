package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();
        
        System.out.print("Enter the number of employees: ");
        int temp = sc.nextInt();

        for (int i = 1; i <= temp; i++) {
            System.out.printf("--Employee #%d data-- \n", i);            
            System.out.print("Outsourced (y/n)? ");
            char temp1 = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (temp1 == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("--PAYMENTS--");

        for (Employee employee : employees) {
            System.out.printf("%s - $%.2f\n", employee.getName(), employee.payment());
        }

        sc.close();
    }
}
