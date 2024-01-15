public class Main {
    public static void main(String[] args) {
        CartManager cartManager = new CartManager();
        WarehouseManager warehouseManager = new WarehouseManager();
        Cart cart = new Cart();
        Product product = new Product();

        Menu menu = new Menu(warehouseManager, cartManager, cart, product);
        menu.start();
    }
}

