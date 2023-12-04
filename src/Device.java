import java.util.ArrayList;
import java.util.List;

public class Device {
    private String model;

    public Device(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class Warehouse {
    private List<Device> devices;

    public Warehouse(List<Device> devices) {
        this.devices = devices;
    }

    public List<Device> searchByModel(String model) {
        List<Device> results = new ArrayList<>();

        for (Device device : devices) {
            if (device.getModel().equalsIgnoreCase(model)) {
                results.add(device);
            }
        }

        return results;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("ModelA"));
        devices.add(new Device("ModelB"));

        Warehouse warehouse = new Warehouse(devices);

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
}

