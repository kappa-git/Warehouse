public class CartManager {
    Warehouse warehouse;
    WarehouseManager warehouseManager;
    Cart cart;
    public CartManager(){
        this.cart=new Cart();
        this.warehouse= new Warehouse();
        this.warehouseManager=new WarehouseManager();
    }
    public void addToCart(int productId, int quantity) {
        cart.addQuantityProductCart(productId, quantity);
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
public void removeProductFromCart(int productId, int quantity) {
    cart.removeProductFromCart(productId, quantity);
}



}
