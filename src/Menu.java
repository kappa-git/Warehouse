import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Manager manager;
    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart;
    private final Product product;
    private final Warehouse warehouse;

    public Menu(Manager manager, Cart cart, Product product, Warehouse warehouse) {
        this.manager = manager;
        this.cart = cart;
        this.product = product;
        this.warehouse = warehouse;
    }

    public void start() {
        System.out.println("""

                1.  Print Products
                2.  Add to Warehouse
                3.  Remove from Warehouse
                4.  Add to Cart
                5.  Remove from Cart
                6.  Calculate Cart Total
                7.  Calculate Mid Total
                8.  Finalize Sale
                9.  Search by Manufacturer
                10. Search by Selling Price
                11. Search by Purchase Price
                12. Print Cart Items
                13. Print Warehouse Items
                0.  Exit""");
        System.out.print("Enter your choice: ");
        readChoiceInputFromUser();
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
        manager.printProducts();
        start();
    }

    private void GetItemInCart() {
        manager.printItemInCart();
        start();
    }

    private void GetItemInWarehouse() {
        manager.printItemInWarehouse();
        start();
    }

    private void addToWareHouse() {
        System.out.println("Enter product ID: ");
        int deviceIdToAdd = scanner.nextInt();

        if (deviceIdToAdd > 0) {
            boolean productExists = warehouse.getItems().stream()
                    .anyMatch(productToFind -> productToFind.getProductId() == deviceIdToAdd);

            if (productExists) {
                System.out.println("Enter quantity: ");
                int quantityToAdd = scanner.nextInt();
                if (quantityToAdd > 0) {
                    manager.addToWarehouse(deviceIdToAdd, quantityToAdd);
                } else {
                    System.out.println("Quantity not valid.");
                    addToWareHouse();
                }
            } else {
                System.out.println("Product ID not found in the warehouse.");
                addToWareHouse();
            }
        } else {
            System.out.println("ID not valid. Please enter a valid ID greater than 0.");
            addToWareHouse();
        }
        start();
    }


    private void removeFromWareHouse() {
        System.out.println("Enter product ID to remove: ");
        int deviceIdToRemove = scanner.nextInt();
        System.out.println("Enter quantity: ");
        int quantityToRemove = scanner.nextInt();
        manager.removeFromWarehouse(deviceIdToRemove, quantityToRemove);
        start();
    }

    private void addToCart() {
        System.out.println("Enter product ID: ");
        int deviceIdToAdd = scanner.nextInt();
        System.out.println("Enter quantity: ");
        int quantityToAdd = scanner.nextInt();
        manager.addToCart(deviceIdToAdd, quantityToAdd);
        start();
    }

    private void calculateCartTotal() {
        double total1 = manager.calculateCartTotal();
        System.out.println("Il totale del carrello è: " + total1);
        start();
    }

    private void removeFromCart() {
        System.out.println("Enter device ID to add to cart: ");
        int deviceIdToRemoveToCart;

        deviceIdToRemoveToCart = checkIfIntEntered();

        manager.searchById(deviceIdToRemoveToCart);
        int quantity = product.getQuantity();
        int productId = product.getProductId();
        if (deviceIdToRemoveToCart == productId) {
            if (cart.removeProductFromCart(productId, quantity).contains(product)) {
                System.out.println("Product is added to cart");
                start();
            } else {
                System.out.println("Product is NOT added to cart, please retry");
                start();
            }
        }
    }

    private Double calculateMidTotal() {
        return manager.calculateMidPrice();
    }

    private void finalizeSale() {
        double total2 = manager.calculateCartTotal();
        cart.clearCart();
        System.out.println("Sale finalized. Your total payed is " + total2);
    }

    private void searchByPurchasePrice() {
        System.out.println("Enter purchase price to search: ");
        double purchasePriceToSearch = checkIfDoubleIsEntered();

        List<Product> result = manager.searchBySellingPrice(purchasePriceToSearch);
        if (!result.isEmpty()) {
            for (Product product : result) {
                System.out.println(product);
            }
        }
    }


    private void searchByManufacturer() {
        System.out.println("Enter manufacturer to search: ");

        String manufacturerToSearch = checkIfStringIsEntered();


        List<Product> result = manager.searchByManufacturer(manufacturerToSearch);
        if (!result.isEmpty()) {
            for (Product product : result) {
                System.out.println(product);
                start();
            }
        } else {
            System.out.println("The manufacturer not exist");
            start();
        }
    }

    private void searchBySellingPrice() {
        System.out.println("Enter selling price to search: ");
        int sellingPriceToSearch = checkIfIntEntered();

        List<Product> result = manager.searchBySellingPrice(sellingPriceToSearch);
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
