import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private WarehouseManager warehouseManager;
    private CartManager cartManager;
    private Scanner scanner = new Scanner(System.in);

    public Menu(WarehouseManager warehouseManager, CartManager cartManager) {
        this.cartManager = cartManager;
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
    private void readChoiceInputFromUser(){
        Integer choice;

            try {
                choice = scanner.nextInt();
                MenuChoiche menuChoiche = checkInputChoice(choice);
                doTheChoice(menuChoiche);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }

            private static MenuChoice checkInputChoice(Integer choice){
            return switch (choice) {
                case 1 -> MenuChoice.PrintProduct;
                case 2 -> MenuChoice.AddToWarehouse;
                case 3 -> MenuChoice.RemoveFromWarehouse;
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

        private void printProducts(){
            warehouseManager.printProducts();
            start();
        }

        private void addToWarehouse(){
            System.out.println("Enter product ID: ");
            int deviceToAdd = scanner.nextInt();
            System.out.println("Enter quantity: ");
            int quantityToAdd = scanner.nextInt();
            warehouseManager.addToWarehouse(deviceIdToAdd,quantityToAdd);
            start();
        }

        private void removeFromWarehouse(){
            System.out.println("Enter product ID to remove: ");
            int deviceIdToRemove = scanner.nextInt();
            warehouseManager.removeFromWarehouse(deviceIdToRemove);
        }

        private void addToCart() {
            System.out.println("Enter device ID to add to cart: ");
            int deviceIdToAddToCart;

            deviceIdToAddToCart = checkIfIntEntered();

            Device device = warehouseManager.searchById(deviceIdToAddToCart);
            if (device != null & cartManager.addToCart(device)) {
                System.out.println("Product is added to cart");
                start();
            } else {
                System.out.println("Product is NOT added to cart, please retry");
                start();
            }
        }
        private void removeFromCart(){
            System.out.println("Enter device ID to remove from cart: ");
            int deviceIdToRemoveFromCart;

            deviceIdToRemoveFromCart = checkIfIntEntered();
            Device device = warehouseManager.searchById(deviceIdToRemoveFromCart);
            if (Device != null & cartManager.removeFromCart(device)) {
                System.out.println("Product is removed from cart");
            } else {
                System.out.println("Product is NOT removed from cart, please retry");
                start();
            }
        }

    private void searchByPurchasePrice(){
            System.out.println("Enter purchase price to search: ");
            double purchasePriceToSearch = chechIfDoubleEntered();

            List<Device> result = warehouseManager.searchBySellingPrice(purchasePriceToSearch);
            if (!result.isEmpty()) {
                for(Device product : result) {
                    System.out.println(product);
                }
            }

            }
        }
    private void searchByManufacturer(){
            System.out.println("Enter manufacturer to search: ");
            String manufacturerToSearch = checkIfStringEntered();

            List<Device> result = warehouseManager.searchByManufacturer(manufacturerToSearch);
            if (!result.isEmpty()) {
                for (Device device : result) {
                    System.out.println(device.getDeviceType());
                }
            }

        }
    private void searchBySellingPrice(){
        System.out.println("Enter selling price to search: ");
        int sellingPriceToSearch = checkIfIntEntered();

        List<Device> result = warehouseManager.searchBySellingPrice(sellingPriceToSearch);
        if (!result.isEmpty()) {
            for (Device device : result) {
                System.out.println(device.getSellingPrice());
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
    private Double checkIfDoubleIsEntered(){
                try {
                    return Double.parseDouble(scanner.next())
                } catch (Exception e) {
                    System.out.println("Invalid input. Please re-enter.");
                    return checkIfDoubleIsEntered;
                }
        }



}
