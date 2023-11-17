import java.util.ArrayList;
import java.util.List;

class Dispositivo {
    private String type;

    public Dispositivo(String tipo) {

        this.type = type;
    }

    public String getType() {
        return type;
    }
}

public class SearchDevice {

    public List<Device> searchForTipe(List<Device> listDevice, String typeSearch) {
        List<Device> resultSearch = new ArrayList<>();

        for (Device device : listDevice) {
            if (dispositivo.getType().equalsIgnoreCase(typeSearch)) {
                resultSearch.add(device);
            }
        }

        if (resultSearch.isEmpty()) {
            System.out.println("Not find device: " + typeSearch);
        }

        return resultSearch;
    }

    public static void main(String[] args) {
        List<Device> listDevice = new ArrayList<>();
        listDevice.add(new Device("Smartphone"));
        listDevice.add(new Device("Laptop"));
        listDevice.add(new Device("Tablet"));
        listDevice.add(new Device("Smartwatch"));

        SearchDevice search = new SearchDevice();
        List<Device> result = search.searchForTipe(listDevice, "Smartphone");

        for (Device device : result) {
            System.out.println("Device finded: " + device.getType());
        }
    }
}
