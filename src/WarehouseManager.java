import java.util.ArrayList;
import java.util.List;

class WarehouseManager {
    private Warehouse warehouse;
    private Cart cart;

    public WarehouseManager() {
        this.warehouse = new Warehouse();
        this.cart = new Cart();
    }

    public void printProducts() {
        warehouse.getInventory().forEach(device ->
                System.out.println("ID: " + device.getDeviceId() + ", Type: " + device.getDeviceType()
                        + ", Manufacturer: " + device.getManufacturer() + ", Model: " + device.getModel()
                        + ", Selling Price: " + device.getSellingPrice() + ", Display Size: " + device.getDisplaySize() + ",\n"
                        + "          Storage Size: " + device.getStorageSize() + ", Purchase Price: " + device.getPurchasePrice()
                        + ", Description: " + device.getDescription() + ", Quantity: " + device.getQuantity()));
    }
    public void getItemInCart() {
        cart.getCartItems().forEach(device ->
                System.out.println("ID: " + device.getDeviceId() + ", Type: " + device.getDeviceType()
                        + ", Manufacturer: " + device.getManufacturer() + ", Model: " + device.getModel()
                        + ", Selling Price: " + device.getSellingPrice() + ", Display Size: " + device.getDisplaySize() + ",\n"
                        + "          Storage Size: " + device.getStorageSize() + ", Purchase Price: " + device.getPurchasePrice()
                        + ", Description: " + device.getDescription() + ", Quantity: " + device.getQuantity()));
    }



    public void removeFromWarehouse(int deviceId) {
        warehouse.removeProduct(deviceId);
    }

    public void addToCart(int deviceId) {
        Device device = findProductById(deviceId, warehouse.getInventory());
        if (device != null && device.getQuantity() > 0) {
            cart.addToCart(device);
            removeFromWarehouse(deviceId);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found in the warehouse.");
        }
    }

    public void removeFromCart(int deviceId) {
        Device device = findProductById(deviceId, cart.getCartItems());
        if (device != null) {
            cart.removeFromCart(deviceId);
            addToWarehouse(deviceId, 1);
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }
    public double calculateMidPrice() {
        return cart.calculateMidPrice();
    }

    public double calculateCartTotal() {
        return cart.calculateTotal();
    }

    public void finalizeSale() {
        cart.clearCart();
        System.out.println("Sale finalized. Cart cleared.");
    }

    private Device findProductById(int deviceId, List<Device> devices) {
        for (Device device : devices) {
            if (device.getDeviceId() == (deviceId)) {
                return device;
            }
        }

        return null;
    }

    public void addToWarehouse(int deviceIdToAdd, int quantityToAdd) {
        Device device = findProductById(deviceIdToAdd, warehouse.getInventory());

        if (device != null) {
            int currentQuantity = device.getQuantity();
            device.setQuantity(currentQuantity + quantityToAdd);

            warehouse.addProduct(device);

            System.out.println("Product added to the warehouse: " + device);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    public  List<Device> searchByDevice(String type){
        List<Device> results = new ArrayList<>();

        for (Device device : warehouse.getInventory()) {
            if (device.getDeviceType().equalsIgnoreCase(String.valueOf(type))){
                results.add(device);
            }
        }
        if (results.isEmpty()){
            System.out.println("No result for search by Type: " + type);
        }
        return results;
    }
    public List<Device> searchByManufacturer(String manufacturer) {
        List<Device> searchResults = new ArrayList<>();

        for (Device device : warehouse.getInventory()) {
            if (device.getManufacturer().equalsIgnoreCase(manufacturer)) {
                searchResults.add(device);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No result for search by manufacturer: " + manufacturer);
        }

        return searchResults;
    }
    public List<Device> searchBySellingPrice(double sellingPrice) {
        List<Device> searchPrice = new ArrayList<>();

        for (Device device : warehouse.getInventory()) {
            if (device.getSellingPrice() == sellingPrice) {
                searchPrice.add(device);
            }
        }

        if (searchPrice.isEmpty()) {
            System.out.println("No result for search by Selling Price: " + sellingPrice);
        }
        return searchPrice;
    }

    public List<Device> searchByPurchasePrice (double purchasePrice){
        List<Device> searchPurchasePrice = new ArrayList<>();

        for (Device device : warehouse.getInventory()) {
            if (device.getPurchasePrice() == purchasePrice) {
                searchPurchasePrice.add(device);
            }
        }

        if (searchPurchasePrice.isEmpty()) {
            System.out.println("No result for search by Selling Price: " + purchasePrice);
        }
        return searchPurchasePrice;
    }
    public List<Device> searchByRangeOfPrice (double purchaseminPrice, double purchasemaxPrice){
        List<Device> searchByRangeOfPrice = new ArrayList<>();

        for (Device device : warehouse.getInventory()) {
            double purchasePrice= device.getPurchasePrice();
            if (purchasePrice >= purchaseminPrice && purchasePrice <= purchasemaxPrice) {
                searchByRangeOfPrice.add(device);
            }
        }

        if (searchByRangeOfPrice.isEmpty()) {
            System.out.println("No result for search between: " + purchaseminPrice + " and: " + purchasemaxPrice);
        }
        return searchByRangeOfPrice;
    }

    public List<Device> searchByModel (String model) {
        List<Device> searchModel = new ArrayList<>();

        for (Device device : warehouse.getInventory()) {
            if (device.getModel().equals(model)) {
                searchModel.add(device);
            }
        }

        if (searchModel.isEmpty()) {
            System.out.println("No result for search by Model: " + model);
        }
        return searchModel;
    }
}
