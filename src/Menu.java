import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final WarehouseManager warehouseManager;
    private final Cart cart;
    private final Scanner scanner = new Scanner(System.in);

    //private Product product;

    public Menu(WarehouseManager warehouseManager, Cart cart) {
        this.cart = cart;
        this.warehouseManager = warehouseManager;
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
                0. Exit""");
        System.out.print("Enter your choice: ");
        readChoiceInputFromUser();
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
            default -> MenuChoice.NotValid;
        };
    }
    private void readChoiceInputFromUser() {
        int choice;

        try {
            choice = scanner.nextInt();
            MenuChoice menuChoice = checkInputChoice(choice);
            doTheChoice(menuChoice);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }




    private void printProducts() {
        warehouseManager.printProducts();
        start();
    }
    private void addToWareHouse() {
        try {
            System.out.println("Enter product ID: ");
            int deviceIdToAdd = scanner.nextInt();

            System.out.println("Enter quantity: ");
            int quantityToAdd = scanner.nextInt();

            warehouseManager.addToWarehouse(deviceIdToAdd, quantityToAdd);
            System.out.println("Product added to warehouse.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid integers for product ID and quantity.");
        } finally {
            // Pulizia dello scanner e chiamata a start()
            scanner.nextLine(); // Pulizia del buffer
            start();
        }
    }
    private void removeFromWareHouse() {
        System.out.println("Enter product ID to remove: ");
        int deviceIdToRemove = scanner.nextInt();
        warehouseManager.removeFromWarehouse(deviceIdToRemove);
    }
    private void addToCart() {
        System.out.println("Enter device ID to add to cart: ");
        int deviceIdToAddToCart = checkIfIntEntered();

        // Cerca il prodotto nel magazzino
        Product product = warehouseManager.searchById(deviceIdToAddToCart);
        if (product != null) {

            // Verifica se il prodotto può essere aggiunto al carrello
            if (cart.addToCart(product)) {
                System.out.println("Product added to cart.");
            } else {
                System.out.println("Product is NOT added to cart. Please check cart capacity.");
            }
        } else {
            System.out.println("Product not found in the warehouse. Please enter a valid device ID.");
        }
        start();
    }
    private void removeFromCart() {
        System.out.println("Enter device ID to removed from cart");
        int deviceIdToRemoveToCart = checkIfIntEntered();
        Product productToRemove = warehouseManager.searchById(deviceIdToRemoveToCart);
        if (productToRemove != null){
            int quantity = productToRemove.getQuantity();
            Integer productId = productToRemove.getProductId();
            if (cart.removeProductFromCart(productId,quantity)){
                System.out.println("Product removed from cart");
                start();
            } else {
                System.out.println("Product not removed from cart, please retry");
                start();
            }

        } else {
            System.out.println("Product not found in the warehouse");
        }



    }
    private void calculateCartTotal() {
        cart.calculateTotal();}
    private void calculateMidTotal(){
        warehouseManager.calculateMidPrice();
    }
    private void finalizeSale(){
        double total = cart.calculateTotal();
        cart.clearCart();
        System.out.println("Sale finalized. Your total payed is: " + total);
    }
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
