public class Smartphone implements Device{

    private String deviceType;
    private String manufacturer;
    private String model;
    private String description;
    private double displaySize;
    private double storageSize;
    private double purchasePrice;
    private double sellingPrice;
    private int deviceId;

    public Smartphone (String deviceType, String manufacturer, String model, String description,
                       double displaySize, double storageSize, double purchasePrice, double sellingPrice,
                       int deviceId){
        this.deviceType= deviceType;
        this.manufacturer= manufacturer;
        this.model= model;
        this.description= description;
        this.displaySize= displaySize;
        this.storageSize= storageSize;
        this.purchasePrice= purchasePrice;
        this.sellingPrice= sellingPrice;
        this.deviceId= deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public int getStorageSize() {
        return (int) storageSize;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public void setStorageSize(double storageSize) {
        this.storageSize = storageSize;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return  "---------------------------------" + '\n' +
                "- deviceType = " + deviceType + '\n' +
                "- manufacturer = " + manufacturer + '\n' +
                "- model = " + model + '\n' +
                "- description = " + description + '\n' +
                "- displaySize = " + displaySize + '\n' +
                "- storageSize = " + storageSize + '\n' +
                "- purchasePrice = " + purchasePrice + '\n' +
                "- sellingPrice = " + sellingPrice + '\n' +
                "- deviceId = " + deviceId + '\n';
    }

}
