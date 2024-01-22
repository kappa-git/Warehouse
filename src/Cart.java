import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Product> cartItems = new ArrayList<>();


    public Cart(){
        this.cartItems.addAll(getInventoryCart());
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
    public double calcTotalProduct(Product product) {
        return product.getSellingPrice() * product.getQuantity();
    }


    public double calculateTotal() {
        double totalCart = 0;
        for (Product product : cartItems) {
            totalCart += calcTotalProduct(product);
        }
        return totalCart;
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