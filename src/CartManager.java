import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CartManager {
    Warehouse warehouse;
    WarehouseManager warehouseManager;
    Cart cart;
    public CartManager(){
        this.cart=new Cart();
        this.warehouse= new Warehouse();
        this.warehouseManager=new WarehouseManager();
    }

    /*TODO: Da sistemare, entra nel secondo if, non vede che getQuantity() è maggiore di quantityToAdd*/
    public List<Product> addToCart(int deviceIdToAdd, int quantityToAdd) {
        List<Product> addedProducts = new ArrayList<>();

        List<Product> checkProductInCart = warehouse.getInventory().stream()
                .filter(productToFind -> productToFind.getProductId() == deviceIdToAdd)
                .toList();

        if (checkProductInCart != null && !checkProductInCart.isEmpty()) {
            Optional<Product> optionalProduct = checkProductInCart.stream()
                    .filter(productToFind -> productToFind.getProductId() == deviceIdToAdd)
                    .findFirst();

            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();

                if (product.getQuantity() >= quantityToAdd) {
                    // Rimuovi dal magazzino separatamente
                    warehouseManager.removeFromWarehouse(deviceIdToAdd);

                    // Aggiungi al carrello
                    cart.addQuantityProductCart(product, quantityToAdd);

                    System.out.println("LOG - CARTMANAGER - Product Added");
                    addedProducts.add(product);
                } else {
                    System.out.println("LOG - CARTMANAGER - Insufficient quantity in stock");
                }
            } else {
                System.out.println("LOG - CARTMANAGER - Product Not Found");
            }
        }
        return addedProducts;
    }

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



//    public Boolean addToCart(int deviceIdToAdd, int quantityToAdd) {
//
//        Product product = cart.getCartItems().stream().filter(productToFind -> productToFind.getProductId()== deviceIdToAdd).toList().get(0);
//        if (product != null && product.getQuantity() > 0) {
//            cart.addQuantityProductCart(product,quantityToAdd);
//            warehouseManager.removeFromWarehouse(deviceIdToAdd);
//            System.out.println("LOG - CARTMANAGER - Product Added");
//            return true;
//        } else {
//            System.out.println("LOG - CARTMANAGER - Product Not Added");
//            return false;

//        }

//    }



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


}
