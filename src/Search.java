import java.util.ArrayList;
import java.util.List;

public class Search {
    private String model;

    public Search (String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class Device {
    private final String devices;

    public Device (String devices) {
        this.devices = devices;
    }

    public List<Device> searchByModel(String model) {
        List<Device> results = new ArrayList<>();

        for (Device device = devices) {
            if (device.getModel().equalsIgnoreCase(model)) {
                results.add(device);
            }
        }

        return results;
    }

    public String getModel() {
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Model A"));
        devices.add(new Device("Model B"));

        Warehouse warehouse = new Warehouse();

        String searchModel = "ModelA";
        List<Device> searchResults = warehouse.searchByModel(searchModel);

        if (!searchResults.isEmpty()) {
            System.out.println("Search results for model " + searchModel + ":");
            for (Device device : searchResults) {
                System.out.println("Model: " + device.getModel());
            }
        } else {
            System.out.println("No results found for model " + searchModel);
        }
    }