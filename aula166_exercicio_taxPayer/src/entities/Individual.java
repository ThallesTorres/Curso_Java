package entities;

public class Individual extends TaxPayer {
    private Double healthExpenses;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double taxCalc() {
        Double tax = (super.getAnnualIncome() < 20000) ? 15.0 : 25.0;

        return tax / 100.0 * super.getAnnualIncome() - 50.0 / 100.0 * healthExpenses;
    }
    
    public String toString() {
        return super.toString() + String.format("%.2f", taxCalc());
    }
}
