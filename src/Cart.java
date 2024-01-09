import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Cart {
    private final List<Device> cartItems = new ArrayList<>();

    public Boolean addToCart(Product product) {
        if (product != null){
            return  cartItems.add(product);
        } else{
            return false;
        }
    }

    public Boolean removeFromCart(Integer productID, Integer quantity) {
        if (productID != null){
            Product toRemove = cartItems.stream().filter(product -> product.getPrductID() == product);
            return  cartItems.remove(toRemove);
        } else{
            return false;
        }
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(Device::getSellingPrice).sum();
    }

    public boolean clearCart() {
        cartItems.clear();
        return cartItems.isEmpty();
    }

    public List<Device> getCartItems() {
        return cartItems;
    }

    public double calculateMidPrice() {
        return cartItems.stream()
                .mapToDouble(Device::getSellingPrice)
                .average()
                .orElse(0.0);
    }


}
