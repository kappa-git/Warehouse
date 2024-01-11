import java.util.List;

public class CartManager {
    Warehouse warehouse;
    WarehouseManager warehouseManager;
    Cart cart;
    public void addToCart(int product) {

        Product product = warehouseManager.searchById(product);
        if (product != null && product.getQuantity() > 0) {
            cart.addToCart(product);
            warehouseManager.removeFromWarehouse(product);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found in the warehouse.");
        }
        return product;
    }
    public void removeFromCart(int productId) {
        Product product = warehouseManager.searchById(productId);
        if (product != null) {
            cart.removeFromCart(productId, product.getQuantity());
            warehouseManager.addToWarehouse(productId, product.getQuantity());
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

}
