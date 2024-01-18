import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Cart {
    Cart cart;
    WarehouseManager warehouseManager;
    Warehouse warehouse;

    private List<Product> cartItems = new ArrayList<>();
    public Cart(){
        this.cartItems.addAll(getInventoryCart());
    }
    public List<Product> getInventoryCart(){
        return new ArrayList<>(Arrays.asList());
    }
    public void addQuantityProductCart(Product product, int quantityToAdd) {
        Product productToUpdate = cartItems.stream().filter(productToCheck -> productToCheck == product).collect(Collectors.toList()).getFirst();
        cartItems.remove(productToUpdate);
        productToUpdate.setQuantity(productToUpdate.getQuantity()+quantityToAdd);
        cartItems.add(productToUpdate);
        System.out.println("LOG - Cart - Product added to the Cart");
    }

    public Boolean addToCart(int deviceIdToAdd, int quantityToAdd) {

        Product product = warehouse.getItems().stream().filter(productToFind -> productToFind.getProductId() == deviceIdToAdd).toList().getFirst();
        if (product != null && product.getQuantity() > 0) {
            warehouseManager.removeFromWarehouse(deviceIdToAdd);
            cart.addQuantityProductCart(product, quantityToAdd);
            System.out.println("LOG - CARTMANAGER - Product Added");
            return true;
        } else {
            System.out.println("LOG - CARTMANAGER - Product Not Added");
            return false;
        }
    }

//    public List <Product> addToCart2 (int productIdToAdd, int quantitytoAdd){
//        List <Product>product = warehouse.getItems();
//        if (product != null){
//            cart.addQuantityProductCart(product, quantitytoAdd);
//            warehouseManager.removeFromWarehouse(productIdToAdd);
//
//        }
//    }





//    public List <Product> addToCart(Product product) {
//        if (product != null){
//            cartItems.add(product);
//        }
//            return cartItems;
//    }

    public List <Product> removeProductFromCart(Integer productId, Integer quantity) {
        if (productId != null) {
            cartItems.removeIf(product -> product.getProductId() == productId && (quantity == null || quantity<= 0 || product.getQuantity()<= quantity));

        } return cartItems;
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(Product::getSellingPrice).sum();
    }

    public void clearCart() {
        cartItems.clear();
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public double calculateMidPrice() {
        return cartItems.stream()
                .mapToDouble(Product::getSellingPrice)
                .average()
                .orElse(0.0);
    }


}
