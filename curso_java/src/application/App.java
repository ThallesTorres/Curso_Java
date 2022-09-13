package application;

import java.util.Locale;
import java.util.Scanner;

import util.AccountBankData;

public class App {
    public static void main(String[] args) throws Exception {
    
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        AccountBankData accountBankData;

        int accountNumber;
        String accountHolder;
        double initialDeposit = 0;

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter account holder: ");
        accountHolder = sc.nextLine();

        String a = " ";

        while(a.equals("Y") == false && a.equals("N") == false) {

            System.out.print("Is there a initial deposit (y/n)? ");
            a = sc.nextLine().strip().toUpperCase();
        }

        if(a.equals("Y") == true) {

            System.out.print("Enter initial deposit value: ");
            initialDeposit = sc.nextDouble();
        }

        accountBankData = new AccountBankData(accountNumber, accountHolder, initialDeposit);

        System.out.printf("Account data: %nAccount %d, Holder: %s, Balance: $%.2f%n", accountBankData.getAccountNumber(), accountBankData.getAccountHolder(), accountBankData.getAccountBalance());

        System.out.print("Enter a deposit value: ");
        double value = sc.nextDouble();

        accountBankData.deposit(value);

        System.out.printf("Updated account data: %nAccount %d, Holder: %s, Balance: $%.2f%n", 
        accountBankData.getAccountNumber(), accountBankData.getAccountHolder(), accountBankData.getAccountBalance());

        System.out.print("Enter a withdraw value: ");
        value = sc.nextDouble();

        accountBankData.withdraw(value);

        System.out.printf("Updated account data: %nAccount %d, Holder: %s, Balance: $%.2f", 
        accountBankData.getAccountNumber(), accountBankData.getAccountHolder(), accountBankData.getAccountBalance());

        sc.close();
    }
}
