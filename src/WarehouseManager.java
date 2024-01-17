import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class WarehouseManager {
    private Warehouse warehouse;
    private Cart cart;


    public WarehouseManager() {
        this.warehouse = new Warehouse();
        this.cart = new Cart();
    }

    public void printProducts() {
        warehouse.getInventory().forEach(product ->
                System.out.println("ID: " + product.getProductId() + ", Type: " + product.getDeviceType()
                        + ", Manufacturer: " + product.getManufacturer() + ", Model: " + product.getModel()
                        + ", Selling Price: " + product.getSellingPrice() + ", Display Size: " + product.getDisplaySize() + ",\n"
                        + "          Storage Size: " + product.getStorageSize() + ", Purchase Price: " + product.getPurchasePrice()
                        + ", Description: " + product.getDescription() + ", Quantity: " + product.getQuantity()));
    }
    public void getItemInCart() {
        cart.getCartItems().forEach(product ->
                System.out.println("ID: " + product.getProductId() + ", Type: " + product.getDeviceType()
                        + ", Manufacturer: " + product.getManufacturer() + ", Model: " + product.getModel()
                        + ", Selling Price: " + product.getSellingPrice() + ", Display Size: " + product.getDisplaySize() + ",\n"
                        + "          Storage Size: " + product.getStorageSize() + ", Purchase Price: " + product.getPurchasePrice()
                        + ", Description: " + product.getDescription() + ", Quantity: " + product.getQuantity()));
    }

    public void getItemInWarehouse() {
        warehouse.getItems().forEach(product ->
                System.out.println("ID: " + product.getProductId() + ", Type: " + product.getDeviceType()
                        + ", Manufacturer: " + product.getManufacturer() + ", Model: " + product.getModel()
                        + ", Selling Price: " + product.getSellingPrice() + ", Display Size: " + product.getDisplaySize() + ",\n"
                        + "          Storage Size: " + product.getStorageSize() + ", Purchase Price: " + product.getPurchasePrice()
                        + ", Description: " + product.getDescription() + ", Quantity: " + product.getQuantity()));
    }


    public void removeFromWarehouse(int productId, int quantity) {
        warehouse.removeProduct(productId, quantity);
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

    public Integer searchById(Integer id) {
        Optional<Product> result = warehouse.getItems().stream()
                .filter(product -> Objects.equals(product.getProductId(), id))
                .findFirst();

        result.ifPresent(product -> System.out.println("LOG - WAREHOUSEMANAGER - Product found: " + product));
        return result.map(Product::getProductId).orElse(null);
    }


    public boolean addToWarehouse(int deviceIdToAdd, int quantityToAdd) {
        Integer product = searchById(deviceIdToAdd);

        if (product != null) {
            warehouse.addQuantityProduct(product, quantityToAdd);
            System.out.println("LOG - WAREHOUSEMANAGER - Product added.");
            return true;
        } else {
            System.out.println("LOG - WAREHOUSEMANAGER - Product not added.");
            return false;
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
