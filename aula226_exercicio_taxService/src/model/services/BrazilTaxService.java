package model.services;

public class BrazilTaxService implements TaxService{
    public double taxService(double amount) {
        if (amount <= 100) {
            return amount * 0.2;
        }
        else {
            return amount * 0.15;
        }
    }
}
