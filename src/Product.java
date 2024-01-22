class Product implements Cloneable{

    private String deviceType;
    private String manufacturer;
    private String model;
    private String description;
    private double displaySize;
    private int storageSize;
    private double purchasePrice;
    private double sellingPrice;
    private int productId;
    private int quantity;

    public Product (){

    }

    public Product (String deviceType, String manufacturer, String model, String description,
                    double displaySize, int storageSize, double purchasePrice,
                    double sellingPrice, int productId) {
        this.deviceType = deviceType;
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.displaySize = displaySize;
        this.storageSize = storageSize;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.productId = productId;
        this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return storageSize;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
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

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return String.format("| ID: %-5s | Type: %-10s | Manufacturer: %-9s | Model: %-13s | Selling Price: %-7.2f | Display Size: %5.2f | Storage: %-5d | Purchase Price: %-6.2f | " +
                        "Quantity: %-6d | Description: %-100s |",
                getProductId(),
                getDeviceType(),
                getManufacturer(),
                getModel(),
                getSellingPrice(),
                getDisplaySize(),
                getStorageSize(),
                getPurchasePrice(),
                getQuantity(),
                getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Product product = (Product) super.clone();

        product.deviceType = new String(this.deviceType);
        product.manufacturer = new String(this.manufacturer);
        product.model = new String(this.model);
        product.description = new String(this.description);
        product.displaySize = this.displaySize;
        product.storageSize = this.storageSize;
        product.purchasePrice = this.purchasePrice;
        product.sellingPrice = this.sellingPrice;
        product.productId = this.productId;
        product.quantity = this.quantity;

        return product;
    }
}