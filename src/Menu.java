import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private WarehouseManager warehouseManager;
    private CartManager cartManager;
    private Scanner scanner = new Scanner(System.in);
    private Cart cart;
    private Product product;


    public Menu(WarehouseManager warehouseManager, CartManager cartManager, Cart cart, Product product) {
        this.cartManager = cartManager;
        this.warehouseManager = warehouseManager;
        this.cart = cart;
        this.product = product;
    }

    public void start() {
        System.out.println("""

                1. Print Products
                2. Add to Warehouse
                3. Remove from Warehouse
                4. Add to Cart
                5. Remove from Cart
                6. Calculate Cart Total
                7. Calculate Mid Total
                8. Finalize Sale
                9. Search by Manufacturer
                10. Search by Selling Price
                11. Search by Purchase Price
                12. Print Cart Items
                13. Print Warehouse Items
                0. Exit""");
        System.out.print("Enter your choice: ");
        readChoiceInputFromUser();
    }

    private void readChoiceInputFromUser() {
        Integer choice;

        try {
            choice = scanner.nextInt();
            MenuChoice menuChoice = checkInputChoice(choice);
            doTheChoice(menuChoice);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            choice = 0;
        }
    }

    private MenuChoice checkInputChoice(Integer choice) {
        return switch (choice) {
            case 1 -> MenuChoice.PrintProduct;
            case 2 -> MenuChoice.AddToWareHouse;
            case 3 -> MenuChoice.RemoveFromWareHouse;
            case 4 -> MenuChoice.AddToCart;
            case 5 -> MenuChoice.RemoveFromCart;
            case 6 -> MenuChoice.CalculateCartTotal;
            case 7 -> MenuChoice.CalculateMidTotal;
            case 8 -> MenuChoice.FinalizeSale;
            case 9 -> MenuChoice.SearchByManufacturer;
            case 10 -> MenuChoice.SearchBySellingPrice;
            case 11 -> MenuChoice.SearchByPurchasePrice;
            case 12 -> MenuChoice.GetItemInCart;
            case 13 -> MenuChoice.GetItemInWarehouse;
            case 0 -> MenuChoice.Exit;
            default -> MenuChoice.NotValid;
        };
    }

    private void doTheChoice(MenuChoice menuChoice) {
        switch (menuChoice) {
            case PrintProduct -> printProducts();
            case AddToWareHouse -> addToWareHouse();
            case RemoveFromWareHouse -> removeFromWareHouse();
            case AddToCart -> addToCart();
            case RemoveFromCart -> removeFromCart();
            case CalculateCartTotal -> calculateCartTotal();
            case CalculateMidTotal -> calculateMidTotal();
            case FinalizeSale -> finalizeSale();
            case SearchByManufacturer -> searchByManufacturer();
            case SearchBySellingPrice -> searchBySellingPrice();
            case SearchByPurchasePrice -> searchByPurchasePrice();
            case GetItemInCart -> GetItemInCart();
            case GetItemInWarehouse -> GetItemInWarehouse();
            case Exit -> {
                System.out.println("Exiting program. Goodbye!");
                scanner.close();
            }
            case NotValid -> {
                System.out.println("Choice not managed! Restart.");
                start();
            }
        }
    }

    private void printProducts() {
        warehouseManager.printProducts();
        start();
    }
    private void GetItemInCart(){
        warehouseManager.getItemInCart();
        start();
    }
    private void GetItemInWarehouse(){
        warehouseManager.getItemInWarehouse();
        start();
    }

    private void addToWareHouse() {
        System.out.println("Enter product ID: ");
        int deviceIdToAdd = scanner.nextInt();
        System.out.println("Enter quantity: ");
        int quantityToAdd = scanner.nextInt();
        warehouseManager.addToWarehouse(deviceIdToAdd, quantityToAdd);
        start();
    }

    private void removeFromWareHouse() {
        System.out.println("Enter product ID to remove: ");
        int deviceIdToRemove = scanner.nextInt();
        warehouseManager.removeFromWarehouse(deviceIdToRemove);
    }
    private void addToCart() {
        System.out.println("Enter product ID: ");
        int deviceIdToAdd = scanner.nextInt();
        System.out.println("Enter quantity: ");
        int quantityToAdd = scanner.nextInt();
        cartManager.addToCart(deviceIdToAdd, quantityToAdd);
        start();
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

    private Double calculateCartTotal(){
        return cart.calculateTotal();
    }
    private void removeFromCart() {
        System.out.println("Enter device ID to add to cart: ");
        int deviceIdToRemoveToCart;

        deviceIdToRemoveToCart = checkIfIntEntered();

        warehouseManager.searchById(deviceIdToRemoveToCart);
        int quantity = product.getQuantity();
        Integer productId = product.getProductId();
        if (deviceIdToRemoveToCart == productId) {
            if (product != null && cart.removeProductFromCart(productId, quantity).contains(product)) {
                System.out.println("Product is added to cart");
                start();
            } else {
                System.out.println("Product is NOT added to cart, please retry");
                start();
            }
        }
    }

    private Double calculateMidTotal(){
        return warehouseManager.calculateMidPrice();
    }

    private void finalizeSale(){
        double total= calculateCartTotal();
        cart.clearCart();
        System.out.println("Sale finalized. Your total payed is " + total);
    }
//        private void removeFromCart(){
//            System.out.println("Enter device ID to remove from cart: ");
//            int deviceIdToRemoveFromCart = checkIfIntEntered();
//            Product product = warehouseManager.searchById(deviceIdToRemoveFromCart);
//            if (product != null && cartManager.removeFromCart(product)) {
//                System.out.println("Product is removed from cart");
//            } else {
//                System.out.println("Product is NOT removed from cart, please retry");
//                start();
//            }
//        }

    private void searchByPurchasePrice() {
        System.out.println("Enter purchase price to search: ");
        double purchasePriceToSearch = checkIfDoubleIsEntered();

        List<Product> result = warehouseManager.searchBySellingPrice(purchasePriceToSearch);
        if (!result.isEmpty()) {
            for (Product product : result) {
                System.out.println(product);
            }
        }

    }


    private void searchByManufacturer() {
        System.out.println("Enter manufacturer to search: ");

        String manufacturerToSearch = checkIfStringIsEntered();


        List<Product> result = warehouseManager.searchByManufacturer(manufacturerToSearch);
        if (!result.isEmpty()) {
            for (Product product : result) {
                System.out.println(product.getDeviceType());
            }
        }

    }

    private void searchBySellingPrice() {
        System.out.println("Enter selling price to search: ");
        int sellingPriceToSearch = checkIfIntEntered();

        List<Product> result = warehouseManager.searchBySellingPrice(sellingPriceToSearch);
        if (!result.isEmpty()) {
            for (Product product : result) {
                System.out.println(product.getSellingPrice());
            }
        }
    }


    private int checkIfIntEntered() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            return scanner.nextInt();
        }
    }

    private Double checkIfDoubleIsEntered() {
        try {
            return Double.parseDouble(scanner.next());
        } catch (Exception e) {
            System.out.println("Invalid input. Please re-enter.");
            return Double.parseDouble(scanner.next());
        }
    }
    private String checkIfStringIsEntered() {
        try {
            return scanner.next();
        } catch (Exception e) {
            System.out.println("Invalid input. Please re-enter.");
            return scanner.next();
        }
    }
}
