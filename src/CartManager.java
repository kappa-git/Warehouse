import java.util.stream.Collectors;

public class CartManager {
    Warehouse warehouse;
    WarehouseManager warehouseManager;
    Cart cart;
    public CartManager(){
        this.cart=new Cart();
        this.warehouse= new Warehouse();
        this.warehouseManager=new WarehouseManager();
    }
    public Boolean addToCart(int deviceIdToAdd, int quantityToAdd) {

        Product product = cart.getCartItems().stream().filter(productToFind -> productToFind.getProductId()== deviceIdToAdd).toList().getFirst();
        if (product != null && product.getQuantity() > 0) {
            cart.addQuantityProductCart(product,quantityToAdd);
            warehouseManager.removeFromWarehouse(deviceIdToAdd);
            System.out.println("LOG - CARTMANAGER - Product Added");
            return true;
        } else {
            System.out.println("LOG - CARTMANAGER - Product Not Added");
            return false;
        }
    }

//    private void addToCart() {
//        System.out.println("Enter device ID to add to cart: ");
//        int deviceIdToAddToCart;
//
//        deviceIdToAddToCart = checkIfIntEntered();
//
//
//        Product product = warehouseManager.searchById(deviceIdToAddToCart);
//        if (product != null && cart.addQuantityProductCart(product,).contains(product)){
//            System.out.println("Product is added to cart");
//            start();
//        } else {
//            System.out.println("Product is NOT added to cart, please retry");
//            start();
//        }
//    }
    public void removeFromCart(int productId) {
        Product product = warehouseManager.searchById(productId);
        if (product != null) {
            cart.removeProductFromCart(productId, product.getQuantity());
            warehouseManager.addToWarehouse(productId, product.getQuantity());
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }
}
