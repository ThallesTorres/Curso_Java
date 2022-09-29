package entities;

public class Company extends TaxPayer {
    private Integer workers;

    public Company() {
        super();
    }

    public Company(String name, Double annualIncome, Integer workers) {
        super(name, annualIncome);
        this.workers = workers;
    } 

    public Integer getWorkers() {
        return workers;
    }
    
    public void setWorkers(Integer workers) {
        this.workers = workers;
    }
    
    @Override
    public Double taxCalc() {
        Double tax = (workers < 10) ? 16.0 : 14.0;

        return tax / 100 * super.getAnnualIncome();
    }

    public String toString() {
        return super.toString() + String.format("%.2f", taxCalc());
    }
}
