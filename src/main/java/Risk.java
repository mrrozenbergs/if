public class Risk {

    private String name;
    private double yearlyPrice;

    public Risk() {
    }

    public Risk(String name, double yearlyPrice) {
        this.name = name;
        this.yearlyPrice = yearlyPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getYearlyPrice() {
        return yearlyPrice;
    }

    public void setYearlyPrice(double yearlyPrice) {
        this.yearlyPrice = yearlyPrice;
    }
}
