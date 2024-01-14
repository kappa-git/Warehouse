import java.util.ArrayList;
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

    public Boolean removeProductFromCart(Integer productId, Integer quantity) {
        if (productId != null) {
            return cartItems.removeIf(product -> product.getProductId() == productId && (quantity == null || quantity<= 0 || product.getQuantity()<= quantity));

        } else {
            return false;
        }
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
