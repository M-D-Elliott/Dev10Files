package exercises1;

public class IceCreamControlSystem {
    private String flavor;
    
    private String supervisor;
    
    private String distributor;
    
    private int gallonsInStock;
    
    private int totalStock;
    private int gallonsProducedPerDay;
    private int gallonsUsedPerDay;

    public IceCreamControlSystem(String flavor, String supervisor, String distributor, int gallonsInStock, int totalStock, int gallonsProducedPerDay, int gallonsUsedPerDay) {
        this.flavor = flavor;
        this.supervisor = supervisor;
        this.distributor = distributor;
        this.gallonsInStock = gallonsInStock;
        this.totalStock = totalStock;
        this.gallonsProducedPerDay = gallonsProducedPerDay;
        this.gallonsUsedPerDay = gallonsUsedPerDay;
    }
    
    public String getInformation(){
        String info = "";
        info += "Supervisor: " + supervisor + "\n";
        info += "Distributor: " + distributor + "\n";
        info += "Stock: " + gallonsInStock + " gallons" + "\n";
        info += "Production: " + gallonsProducedPerDay + "\n";
        info += "Demand: " + gallonsUsedPerDay + "\n";
        return info;
    }
    
    public boolean willRunOut(){
        return gallonsProducedPerDay < gallonsUsedPerDay;
    }
    
    public double willRunOutInXDays(){
        int days;
        if (willRunOut()){
            return -1 * (totalStock / ((gallonsProducedPerDay - gallonsUsedPerDay)));
        }
        return 0;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public int getGallonsInStock() {
        return gallonsInStock;
    }

    public void setGallonsInStock(int gallonsInStock) {
        this.gallonsInStock = gallonsInStock;
    }

    public int getGallonsProducedPerDay() {
        return gallonsProducedPerDay;
    }

    public void setGallonsProducedPerDay(int gallonsProducedPerDay) {
        this.gallonsProducedPerDay = gallonsProducedPerDay;
    }

    public int getGallonsUsedPerDay() {
        return gallonsUsedPerDay;
    }

    public void setGallonsUsedPerDay(int gallonsUsedPerDay) {
        this.gallonsUsedPerDay = gallonsUsedPerDay;
    }
}
