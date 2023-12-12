
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