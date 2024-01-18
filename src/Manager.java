import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Manager {
    private Warehouse warehouse;
    private Cart cart;

    public Manager() {
        this.warehouse = new Warehouse();
        this.cart = new Cart();
    }

    public void printProducts() {
        warehouse.getInventory().forEach(product -> System.out.println(product));
    }

    public void printItemInCart() {
        cart.getCartItems().forEach(product -> System.out.println(product));
    }

    public void printItemInWarehouse() {
        warehouse.getItems().forEach(product -> System.out.println(product));
    }

    public Boolean addToWarehouse(int deviceIdToAdd, int quantityToAdd) {
        boolean exist;

        List<Product> list = warehouse.getItems().stream().filter(productToFind -> productToFind.getProductId()== deviceIdToAdd).toList();
        Product product = null;

        exist = !list.isEmpty();
        if (exist)
            product = list.getFirst();

        if (product != null) {
            warehouse.addQuantityProduct(product, quantityToAdd);
            System.out.println("LOG - WAREHOUSEMANAGER - Product added.");
            return true;
        } else {
            if (!exist)
                System.out.println("No match found for given id product");
            else
                System.out.println("LOG - WAREHOUSEMANAGER - Product not added.");
            return false;
        }
    }

    public Boolean addToCart(int deviceIdToAdd, int quantityToAdd) {

        List<Product> list = warehouse.getItems().stream().filter(productToFind -> productToFind.getProductId()== deviceIdToAdd).toList();
        Product product = null;

        if (!list.isEmpty())
            product = list.getFirst();

        if (product != null && (product.getQuantity() > 0 && quantityToAdd <= product.getQuantity())) {
            cart.addQuantityProductCart(product,quantityToAdd);
            removeFromWarehouse(deviceIdToAdd,quantityToAdd);
            System.out.println("LOG - CARTMANAGER - Product Added");
            return true;
        } else {
            System.out.println("LOG - CARTMANAGER - Product Not Added");
            return false;
        }
    }

    public void removeFromWarehouse(int productId, int quantity) {
        warehouse.removeProduct(productId, quantity);
    }

    public void removeFromCart(int productId, int quantity) {
        Product product = searchById(productId);
        if (product != null) {
            cart.removeProductFromCart(productId, product.getQuantity());
            addToWarehouse(productId, product.getQuantity());
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

    public Product searchById (Integer id){
        Product result = warehouse.getItems().stream().filter(product -> Objects.equals(product.getProductId(), id)).collect(Collectors.toList()).getFirst();

        System.out.println("LOG - MANAGER - products filtered by ID. Products: " + result);
        return result;
    }

    public List<Product> searchByDevice(String type){
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
