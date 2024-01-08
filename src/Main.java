public class Main {
    public static void main(String[] args) {
        CartManager cartManager = new CartManager();
        WarehouseManager warehouseManager = new WarehouseManager();

        Menu menu = new Menu(warehouseManager, cartManager);
        menu.start();
    }
}

