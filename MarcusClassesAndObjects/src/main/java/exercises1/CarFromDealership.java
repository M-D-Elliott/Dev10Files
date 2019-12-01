package exercises1;

public class CarFromDealership {
    private String make;
    private String model;
    
    private int year;
    
    private int miles;
    private int kellyBlueBookValue;
    private int costOfDamages;
    
    private String history;
    
    private final double milesCostReduction = 0.70;

    public CarFromDealership(String make, String model, int year, int miles, int kellyBlueBookValue, int costOfDamages, String history) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
        this.kellyBlueBookValue = kellyBlueBookValue;
        this.costOfDamages = costOfDamages;
        this.history = history;
    }

    
    public double calculateCost() {
        return (kellyBlueBookValue - costOfDamages - (miles * milesCostReduction));
    }
    
    public String makeModelYear(){
        return year + " " + make + " " + model;
    }
    
    public void show() {
        System.out.println(makeModelYear());
        System.out.println(history);
        System.out.println("Listed Cost: " + kellyBlueBookValue);
        System.out.println("Miles: " + miles);
        System.out.println("Damages: " + costOfDamages);
        System.out.println("Current value: " + calculateCost());
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int getKellyBlueBookValue() {
        return kellyBlueBookValue;
    }

    public void setKellyBlueBookValue(int kellyBlueBookValue) {
        this.kellyBlueBookValue = kellyBlueBookValue;
    }

    public int getCostOfDamages() {
        return costOfDamages;
    }

    public void setCostOfDamages(int costOfDamages) {
        this.costOfDamages = costOfDamages;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
