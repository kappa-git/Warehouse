import java.util.List;

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

        List<Product> list = warehouse.getItems().stream().filter(productToFind -> productToFind.getProductId()== deviceIdToAdd).toList();
        Product product = null;

        if (!list.isEmpty())
            product = list.getFirst();

        if (product != null && (product.getQuantity() > 0 && quantityToAdd <= product.getQuantity())) {
            cart.addQuantityProductCart(product,quantityToAdd);
            warehouseManager.removeFromWarehouse(deviceIdToAdd,quantityToAdd);
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
public void removeFromCart(int productId, int quantity) {
    Integer product = warehouseManager.searchById(productId);
    if (product != null) {
        cart.removeProductFromCart(productId, product);
        warehouseManager.addToWarehouse(productId, product);
        System.out.println("Product removed from cart.");
    } else {
        System.out.println("Product not found in the cart.");
    }
}



}
