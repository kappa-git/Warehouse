import java.awt.Menu;
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
        Product product = findProductById(deviceId, warehouse.getInventory());
        if (product != null && product.getQuantity() > 0) {
            cart.addToCart(product);
            removeFromWarehouse(deviceId);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found in the warehouse.");
        }
    }

    public void removeFromCart(int productId) {
        Product product = findProductById(productId, cart.getCartItems());
        if (product != null) {
            cart.removeFromCart(productId);
            addToWarehouse(productId, 1);
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

    public Product findProductById(int deviceId, List<Product> devices) {
        for (Product product : devices) {
            if (product.getDeviceId() == (deviceId)) {
                return product;
            }
        }

        return null;
    }

    public void addToWarehouse(int deviceIdToAdd, int quantityToAdd) {
        Product product = findProductById(deviceIdToAdd, warehouse.getInventory());

        if (product != null) {
            int currentQuantity = product.getQuantity();
            product.setQuantity(currentQuantity + quantityToAdd);

            warehouse.addProduct(product);

            System.out.println("Product added to the warehouse: " + product);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    public  List<Product> searchByDevice(String type){
        List<Product> results = new ArrayList<>();

        for (Product product : warehouse.getInventory()) {
            if (product.getDeviceType().equalsIgnoreCase(String.valueOf(type))){
                results.add(product);
            }
        }
        if (results.isEmpty()){
            System.out.println("No result for search by Type: " + type);
        }
        return results;
    }
    public List<Product> searchByManufacturer(String manufacturer) {
        List<Product> searchResults = new ArrayList<>();

        for (Product product : warehouse.getInventory()) {
            if (product.getManufacturer().equalsIgnoreCase(manufacturer)) {
                searchResults.add(product);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No result for search by manufacturer: " + manufacturer);
        }

        return searchResults;
    }
    public List<Product> searchBySellingPrice(double sellingPrice) {
        List<Product> searchPrice = new ArrayList<>();

        for (Product product : warehouse.getInventory()) {
            if (product.getSellingPrice() == sellingPrice) {
                searchPrice.add(product);
            }
        }

        if (searchPrice.isEmpty()) {
            System.out.println("No result for search by Selling Price: " + sellingPrice);
        }
        return searchPrice;
    }

    public List<Product> searchByPurchasePrice (double purchasePrice){
        List<Product> searchPurchasePrice = new ArrayList<>();

        for (Product product : warehouse.getInventory()) {
            if (product.getPurchasePrice() == purchasePrice) {
                searchPurchasePrice.add(product);
            }
        }

        if (searchPurchasePrice.isEmpty()) {
            System.out.println("No result for search by Selling Price: " + purchasePrice);
        }
        return searchPurchasePrice;
    }
    public List<Product> searchByRangeOfPrice (double purchaseminPrice, double purchasemaxPrice){
        List<Product> searchByRangeOfPrice = new ArrayList<>();

        for (Product product : warehouse.getInventory()) {
            double purchasePrice= product.getPurchasePrice();
            if (purchasePrice >= purchaseminPrice && purchasePrice <= purchasemaxPrice) {
                searchByRangeOfPrice.add(product);
            }
        }

        if (searchByRangeOfPrice.isEmpty()) {
            System.out.println("No result for search between: " + purchaseminPrice + " and: " + purchasemaxPrice);
        }
        return searchByRangeOfPrice;
    }

    public List<Product> searchByModel (String model) {
        List<Product> searchModel = new ArrayList<>();

        for (Product product : warehouse.getInventory()) {
            if (product.getModel().equals(model)) {
                searchModel.add(product);
            }
        }

        if (searchModel.isEmpty()) {
            System.out.println("No result for search by Model: " + model);
        }
        return searchModel;
    }
}
