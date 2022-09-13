package util;

public class AccountBankData {

    private final double WITHDRAWAL_FEE = 5.0;

    private int accountNumber;
    private String accountHolder;
    private double accountBalance;

    // public AccountBankData(int accountNumber, String accountHolder) {

    //     this.accountNumber = accountNumber;
    //     this.accountHolder = accountHolder;
    // }

    public AccountBankData(int accountNumber, String accountHolder, double initialDeposit) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        deposit(initialDeposit);
    }

    public int getAccountNumber() {

        return accountNumber;
    }

    public String getAccountHolder() {

        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {

        this.accountHolder = accountHolder;
    }

    public double getAccountBalance() {

        return accountBalance;
    }

    public void deposit(double value) {

        accountBalance += value;
    }

    public void withdraw(double value) {

        accountBalance = accountBalance - WITHDRAWAL_FEE - value;
    }

}
