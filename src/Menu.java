import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        WarehouseManager manager = new WarehouseManager();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int choice;
        do {
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
                    12. Search by Model
                    13. Search by Type
                    14. Search by Range of Price
                    0. Exit""");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    manager.printProducts();
                    break;
                case 2:
                    // Input and add product to warehouse
                    System.out.print("Enter device ID: ");
                    int deviceIdToAdd = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine();
                    manager.addToWarehouse(deviceIdToAdd, quantityToAdd);
                    break;
                case 3:
                    // Input and remove product from warehouse
                    System.out.print("Enter device ID to remove: ");
                    int deviceIdToRemove = scanner.nextInt();
                    manager.removeFromWarehouse(deviceIdToRemove);
                    break;
                case 4:
                    // Input and add product to cart
                    manager.printProducts();
                    System.out.print("Enter device ID to add to cart: ");
                    int deviceIdToAddToCart = scanner.nextInt();
                    manager.addToCart(deviceIdToAddToCart);
                    break;
                case 5:
                    // Input and remove product from cart
                    manager.getItemInCart();
                    System.out.print("Enter device ID to remove from cart: ");
                    int deviceIdToRemoveFromCart = scanner.nextInt();
                    manager.removeFromCart(deviceIdToRemoveFromCart);
                    break;
                case 6:
                    manager.getItemInCart();
                    System.out.println("Cart Total: " + manager.calculateCartTotal());
                    break;
                case 7:
                    manager.getItemInCart();
                    System.out.println("Cart Mid Price: " + manager.calculateMidPrice());
                    break;
                case 8:
                    manager.finalizeSale();
                    break;
                case 9:
                    manager.printProducts();
                    System.out.print("Enter manufacturer to search: ");
                    String manufacturerToSearch = scanner.next();
                    List<Device> searchResults = manager.searchByManufacturer(manufacturerToSearch);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Device device : searchResults) {
                            System.out.println(device);
                        }
                    }
                    break;
                case 10:
                    manager.printProducts();
                    System.out.print("Enter selling price to search: ");
                    double priceToSearch = Double.parseDouble(scanner.next());
                    List<Device> searchSellingPricericeResults = manager.searchBySellingPrice(priceToSearch);
                    if (!searchSellingPricericeResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Device device : searchSellingPricericeResults) {
                            System.out.println(device);
                        }
                    }
                    break;
                case 11:
                    manager.printProducts();
                    System.out.print("Enter purchase price to search: ");
                    double purchasePriceToSearch = Double.parseDouble(scanner.next());
                    List<Device> searchPurchasePricericeResults = manager.searchByPurchasePrice(purchasePriceToSearch);
                    if (!searchPurchasePricericeResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Device device : searchPurchasePricericeResults) {
                            System.out.println(device);
                        }
                    }
                    break;
                case 12:
                    manager.printProducts();
                    System.out.print("Enter model to search: ");
                    String modelToSearch = scanner.next();
                    List<Device> searchModelResults = manager.searchByModel(modelToSearch);
                    if (!searchModelResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Device device : searchModelResults) {
                            System.out.println(device);
                        }
                    }
                    break;
                case 13:
                    manager.printProducts();
                    System.out.print("Enter type to search: ");
                    String typeToSearch = scanner.next();
                    List<Device> typeToSearchResult = manager.searchByDevice(typeToSearch);
                    if (!typeToSearchResult.isEmpty()) {
                        System.out.println("Search results:");
                        for (Device device : typeToSearchResult) {
                            System.out.println(device);
                        }
                    }
                    break;
                case 14:
                    manager.printProducts();
                    System.out.print("Enter min price to search: ");
                    double purchaseminPrice = Double.parseDouble(scanner.next());
                    System.out.print("Enter max price to search: ");
                    double purchasemaxPrice = Double.parseDouble(scanner.next());
                    List<Device> searchRangeResults = manager.searchByRangeOfPrice(purchaseminPrice, purchasemaxPrice);
                    if (!searchRangeResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Device device : searchRangeResults) {
                            System.out.println(device);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}
