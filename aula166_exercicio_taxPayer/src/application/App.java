package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int payers = sc.nextInt();

        for (int i = 1; i <= payers; i++) {
            System.out.printf("\n--Tax payer #%d data: \n", i);
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();

            switch (ch) {
                case 'c':
                    System.out.print("Number of employees: ");
                    int workers = sc.nextInt();

                    taxPayers.add(new Company(name, annualIncome, workers));
                    break;
            
                default:
                    System.out.print("Health expenditures: ");
                    Double healthExpenses = sc.nextDouble();

                    taxPayers.add(new Individual(name, annualIncome, healthExpenses));
                    break;
            }

        }

        System.out.println("\n--TAXES PAID--");

        Double totalTaxes = 0.0;
        for (TaxPayer person : taxPayers) {
            System.out.println(person.toString());
            totalTaxes += person.taxCalc();
        }

        System.out.printf("TOTAL TAXES: %.2f\n", totalTaxes);

        sc.close();
    }
}
