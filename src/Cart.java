import java.util.ArrayList;
import java.util.List;

class Cart {
    private Warehouse warehouse = new Warehouse();
    private List<Product> cartItems = new ArrayList<>();
    public Cart(){
        this.cartItems.addAll(warehouse.getItems());
    }


    public void addQuantityProductCart(int productId, int quantityToAdd) {
        Product productToUpdate = cartItems.stream()
                .filter(productToCheck -> productToCheck.getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (warehouse.getItems().getFirst().getQuantity() >= quantityToAdd) {
            // Update the quantity in cartItems
            productToUpdate.setQuantity(productToUpdate.getQuantity() + quantityToAdd);

            // Remove the quantity from the warehouse
            warehouse.removeProduct(productId, quantityToAdd);

            System.out.println("LOG - CART - Product added to the Cart");
        } else {
            System.out.println("LOG - CART - Not enough quantity in the warehouse");
        }

    }

    public void removeProductFromCart(int productId, int quantityToRemove) {
        warehouse.addQuantityProduct(productId, quantityToRemove);
        Product productToUpdate = cartItems.stream()
                .filter(productToCheck -> productToCheck.getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found in the Cart"));

        int currentQuantity = productToUpdate.getQuantity();
        if (currentQuantity < quantityToRemove) {
            throw new IllegalArgumentException("Insufficient quantity in the Cart");
        }

        productToUpdate.setQuantity(currentQuantity - quantityToRemove);
        System.out.println("LOG - CART - Product removed from the Cart");


    }
//    public void addQuantityProductCart(Product product, int quantityToAdd) {
//        Product productToUpdate = cartItems.stream()
//                .filter(productToCheck -> productToCheck == product)
//                .findFirst()
//                .orElse(null);
//        if (productToUpdate != null) {
//            cartItems.remove(productToUpdate);
//            productToUpdate.setQuantity(productToUpdate.getQuantity() + quantityToAdd);
//            cartItems.add(productToUpdate);
//            System.out.println("LOG - CART - Product added to the Cart");
//        } else {
//            System.out.println("LOG - CART - Product not found in the Cart");
//        }
//    }
//
//
//    public List <Product> removeProductFromCart(Integer productId, Integer quantity) {
//        if (productId != null) {
//            cartItems.removeIf(product ->
//                    product.getProductId() == productId && (quantity == null || quantity<= 0 || product.getQuantity()<= quantity));
//
//        } return cartItems;
//    }

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
