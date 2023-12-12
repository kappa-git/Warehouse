import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        List<Device> devices = getDevices();


        StringBuilder notebook = new StringBuilder();
        for (Device element : devices) {
            notebook.append(element).append(" ");

        }
        StringBuilder tablet = new StringBuilder();
        for (Device element : devices) {
            tablet.append(element).append(" ");

        }
        StringBuilder smartphone = new StringBuilder();
        for (Device element : devices) {
            smartphone.append(element).append(" ");

        }

        System.out.println("Computer Portatili disponibili: " + '\n' + notebook);
        System.out.println("Tablet disponibili: " + '\n' + tablet);
        System.out.println("Smartphone disponibili: " + '\n' + smartphone);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il produttore da cercare: ");
        String manufacturerToSearch = scanner.nextLine();

        List<Device> searchResults = searchByManufacturer(devices, manufacturerToSearch);

        System.out.println("Risultati della ricerca per produttore '" + manufacturerToSearch + "':");
        for (Device result : searchResults) {
            System.out.println(result);
        }


    }

    private static List<Device> getDevices() {
        Notebook laptop = new Notebook("Notebook", "Asus", "ZenBook", "Non disponibile", 14, 512, 850.00, 1000.00, 4431);
        Notebook laptop1 = new Notebook("Notebook", "Hp", "Pavilion Plus", "Non disponibile", 16, 1000, 780.00, 1199.00, 4432);
        Tablet tablet1 = new Tablet("Tablet", "Lenovo", "M10 plus", "Non disponibile", 10.6, 64, 300.00, 359.01, 1268);
        Tablet tablet2 = new Tablet("Tablet", "Microsoft", "Surface Pro 9", "Non disponibile", 13, 256, 998.00, 1300.00, 1269);
        Tablet tablet3 = new Tablet("Tablet", "Apple", "Ipad Air", "Non disponibile", 10.9, 256, 550.00, 630.00, 1270);
        Smartphone phone = new Smartphone("Smartphone", "Apple", "Iphone 11", "Non disponibile", 6.1, 128, 320.00, 480.00, 1123);
        Smartphone phone2 = new Smartphone("Smartphone", "TCL", "40SE", "Non disponibile", 6.0, 256, 120.00, 230.00, 7648);
        Smartphone phone3= new Smartphone("Smartphone", "Apple","Iphone 15","Non disponibile", 6.12, 256, 500.00, 899.00, 2111);
        Smartphone phone4= new Smartphone("Smartphone", "Samsung","Galaxy 23","Non disponibile", 6.10, 256, 450.00, 720.00, 2112);
        Smartphone phone5= new Smartphone("Smartphone", "Huawei","P60","Non disponibile", 6.67, 256, 500.00, 1099.00, 2113);
        return new ArrayList<>(Arrays.asList(laptop, laptop1, tablet1, tablet2, tablet3, phone, phone2, phone3, phone4, phone5));
    }
    private static List<Device> devices;
    public static void initializeDevices() {
        devices = getDevices();
    }
    private static void processDevices(List<Device> devices) {
        List<Device> filteredNotebooks = searchDevicesBySellingPrice(devices, 800.0, 1100.0);
        System.out.println("Notebooks within the price range are: ");
        for (Device device : filteredNotebooks) {
            System.out.println(device.getModel() + " - Selling Price: $" + device.getSellingPrice());
        }

        List<Device> filteredTablets = searchDevicesBySellingPrice(devices, 400.0, 700.0);
        System.out.println("Tablets within the price range are: ");
        for (Device device : filteredTablets) {
            System.out.println(device.getModel() + "- Selling Price: $" + device.getSellingPrice());
        }

        List<Device> filteredSmartphones = searchDevicesBySellingPrice(devices, 700, 1000);
        System.out.println("Smartphones within the price range are: ");
        for (Device device : filteredSmartphones) {
            System.out.println(device.getModel() + " - Selling Price: $" + device.getSellingPrice());
        }
    }

    public static List<Device> searchDevicesBySellingPrice(List<Device> devices, double minPrice, double maxPrice) {
        List<Device> filteredDevices = new ArrayList<>();

        for (Device device : devices) {
            if (device instanceof Notebook && device.getSellingPrice() >= minPrice && device.getSellingPrice() <= maxPrice) {
                filteredDevices.add(device);
            } else if (device instanceof Tablet && device.getSellingPrice() >= minPrice && device.getSellingPrice() <= maxPrice) {
                filteredDevices.add(device);
            } else if (device instanceof Smartphone && device.getSellingPrice() >= minPrice && device.getSellingPrice() <= maxPrice) {
                filteredDevices.add(device);
            }
        }

        return filteredDevices;
    }





    public static List<Device> searchByManufacturer(List<? extends Device> devices, String manufacturer){
        List<Device> results = new ArrayList<>();

        for (Device device : devices) {
            if (device.getManufacturer().equalsIgnoreCase(manufacturer)){
                results.add(device);
            }
        }
        if (results.isEmpty()){
            System.out.println("Nessun dispositivo trovato per il produttore: " + manufacturer);
        }
        return results;
    }

}
