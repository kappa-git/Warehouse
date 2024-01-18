

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Cart cart = new Cart();
        Product product = new Product();

        Menu menu = new Menu(manager, cart, product);
        menu.start();
    }
}