import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Cart {
    private final List<Product> cartItems = new ArrayList<>();

    public Boolean addToCart(Product product) {
        if (product != null){
            return  cartItems.add(product);
        } else{
            return false;
        }
    }

    public boolean removeProductFromCart(Integer productID, Integer quantity) {
        if (productID != null){

            cartItems.stream().filter(product -> product.getProductId() == productID);
            return  true;
        } else{
            return false;
        }
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(Product::getSellingPrice).sum();
    }

    public boolean clearCart() {
        cartItems.clear();
        return cartItems.isEmpty();
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
