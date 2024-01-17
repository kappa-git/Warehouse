import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<Product> cartItems = new ArrayList<>();

    public List<Product> addToCart(Product product) {
        if (product != null){
            cartItems.add(product);
        }
        return cartItems;
    }

    public List<Product> removeProductFromCart(Integer productId, Integer quantity) {
        if (productId != null) {
            cartItems.removeIf(product -> product.getProductId() == productId && (quantity == null || quantity<= 0 || product.getQuantity()<= quantity));

        }
        return cartItems;
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
