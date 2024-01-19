import java.util.ArrayList;
import java.util.List;

class Cart {
    private Warehouse warehouse = new Warehouse();
    private List<Product> cartItems = new ArrayList<>();
    public Cart(){
        this.cartItems.addAll(warehouse.getInventory());
    }
    public List<Product> getInventoryCart(){
        return new ArrayList<>(List.of());
    }


    public void addQuantityProductCart(Product product, int quantityToAdd) {

        List<Product> resultList = cartItems.stream().filter(productToCheck -> productToCheck.getProductId() == product.getProductId()).toList();

        if (!resultList.isEmpty()) {
            Product productToUpdate = resultList.getFirst();

            if (product.toString().equals(productToUpdate.toString()))
                cartItems.remove(productToUpdate);
        }

        Product productToAdd;
        try {
            productToAdd = (Product) product.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (productToAdd != null)
        {
            productToAdd.setQuantity(quantityToAdd);
            cartItems.add(productToAdd);
            System.out.println("LOG - Cart - Product added to the Cart");
        }
        else
        {
            System.out.println("Not insert into cart - error");
        }
    }
    public List <Product> removeProductFromCart(Integer productId, Integer quantity) {
        if (productId != null) {
            cartItems.removeIf(product -> product.getProductId() == productId && (quantity == null || quantity<= 0 || product.getQuantity()<= quantity));

        } return cartItems;
    }
//    public void removeProductFromCart(int productId, int quantityToRemove) {
//        warehouse.addQuantityProduct(productId, quantityToRemove);
//        Product productToUpdate = cartItems.stream()
//                .filter(productToCheck -> productToCheck.getProductId() == productId)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Product not found in the Cart"));
//
//        int currentQuantity = productToUpdate.getQuantity();
//        if (currentQuantity < quantityToRemove) {
//            throw new IllegalArgumentException("Insufficient quantity in the Cart");
//        }
//
//        productToUpdate.setQuantity(currentQuantity - quantityToRemove);
//        System.out.println("LOG - CART - Product removed from the Cart");
//
//
//    }
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
