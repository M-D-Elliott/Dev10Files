package exercises1;

public class IceCreamGrocery {
    private String flavor;

    private int gallonsPurchasedPerDay;
    private int purchaseCostPerGallon;
    
    private int gallonsSoldPerDay;
    private int sellProfitPerGallon;

    private int backRoomInventory;
    private int shelfPresence;

    public IceCreamGrocery(String flavor, int gallonsPurchasedPerDay, int purchaseCost, int gallonsSoldPerDay, int sellProfit, int backRoomInventory, int shelfPresence) {
        this.flavor = flavor;
        this.gallonsPurchasedPerDay = gallonsPurchasedPerDay;
        this.purchaseCostPerGallon = purchaseCost;
        this.gallonsSoldPerDay = gallonsSoldPerDay;
        this.sellProfitPerGallon = sellProfit;
        this.backRoomInventory = backRoomInventory;
        this.shelfPresence = shelfPresence;
    }
    
    public int profitPerDay(){
        return totalSalesPerDay() - totalPurchasesPerDay();
    }
    
    public int totalSalesPerDay(){
        return sellProfitPerGallon /  gallonsSoldPerDay;
    }
    
    public int totalPurchasesPerDay(){
        return purchaseCostPerGallon / gallonsPurchasedPerDay;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getGallonsPurchasedPerDay() {
        return gallonsPurchasedPerDay;
    }

    public void setGallonsPurchasedPerDay(int gallonsPurchasedPerDay) {
        this.gallonsPurchasedPerDay = gallonsPurchasedPerDay;
    }

    public int getPurchaseCostPerGallon() {
        return purchaseCostPerGallon;
    }

    public void setPurchaseCostPerGallon(int purchaseCostPerGallon) {
        this.purchaseCostPerGallon = purchaseCostPerGallon;
    }

    public int getGallonsSoldPerDay() {
        return gallonsSoldPerDay;
    }

    public void setGallonsSoldPerDay(int gallonsSoldPerDay) {
        this.gallonsSoldPerDay = gallonsSoldPerDay;
    }

    public int getSellProfitPerGallon() {
        return sellProfitPerGallon;
    }

    public void setSellProfitPerGallon(int sellProfitPerGallon) {
        this.sellProfitPerGallon = sellProfitPerGallon;
    }

    public int getBackRoomInventory() {
        return backRoomInventory;
    }

    public void setBackRoomInventory(int backRoomInventory) {
        this.backRoomInventory = backRoomInventory;
    }

    public int getShelfPresence() {
        return shelfPresence;
    }

    public void setShelfPresence(int shelfPresence) {
        this.shelfPresence = shelfPresence;
    }
}
