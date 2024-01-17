import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Cart {
    public List<Product> cartItems = new ArrayList<>();
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
