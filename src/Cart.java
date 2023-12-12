import java.util.ArrayList;


public class Cart {
    private final ArrayList<Device> Warehouse;
    private static ArrayList<String> cart;

    private Cart() {
        Warehouse = new ArrayList<Device>();
        cart = new ArrayList<String>();
    }

    private void addToWarehouse(Device device) {
        Warehouse.add(device);
        System.out.println(device + " aggiunto al magazzino.");
    }

    private void unloadFromWarehouse(Device device) {
        if (Warehouse.contains(device)) {
            Warehouse.remove(device);
            System.out.println(device + " rimosso da magazzino.");
        } else {
            System.out.println("Questo " + device + " non è disponibile.");
        }
    }

    private void addToCart(String device) {
        if (Warehouse.contains(device)) {
            cart.add(device);
            Warehouse.remove(device);
            System.out.println(device + " aggiunto al carrello.");
        } else {
            System.out.println("Il dispositivo non è disponibile nel magazzino: " + device);
        }
    }

    private void stampWarehouse() {
        System.out.println("Dispositivi disponibili in magazzino:");
        for (Device device : Warehouse) {
            System.out.println(device);
        }
    }

    private void stampCart() {
        System.out.println("Dispositivi nel carrello:");
        for (String device : cart) {
            System.out.println(device);
        }
    }

    public static double calcolaSpesaMedia(ArrayList<Device> devices) {
        if (devices.isEmpty()) {
            return -1;
        }

        double sommaSpese = 0;
        for (Device device : devices) {
            sommaSpese += device.getSellingPrice();
        }

        return sommaSpese / devices.size();
    }
    public static ArrayList<String> addToCart(int deviceId, Device[] devices) {
        for (Device device : devices) {
            if (device.getDeviceId() == deviceId) {
                cart.add(String.valueOf(device));
                cart.remove(device);

            }
        }
        return cart;
    }
}



