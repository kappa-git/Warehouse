public class Metodo {
    public List<Device> searchByModel(String model) {
    List<Device> results = new ArrayList<>();

    for (Device device = devices) {
        if (device.getModel().equalsIgnoreCase(model)) {
            results.add(device);
        }
    }

    return results;
}
}
