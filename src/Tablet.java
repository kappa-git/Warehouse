import java.util.ArrayList;
import java.util.List;
public class Tablet {

    private String type;
    private String brand;
    private String model;
    private String description;
    private double displaySize;
    private int storageSize;
    private double purchasePrice;
    private double sellingPrice;
    private int deviceId;

    public Tablet(String type, String brand, String model, String description,
                  double displaySize, int storageSize,
                  double purchasePrice, double sellingPrice, int deviceId) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.displaySize = displaySize;
        this.storageSize = storageSize;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "type='" + type + '\'' +
                ", manufacturer='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", displaySize=" + displaySize +
                ", storageSize=" + storageSize +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", deviceId=" + deviceId +
                '}';
    }

    public static void main(String[] args) {

        List<Tablet> tabletList = new ArrayList<>();

        tabletList.add(new Tablet("Tablet", "Samsung", "Galaxy Tab S7", "Old but gold", 11.0, 128, 699.99, 799.99, 103));
        tabletList.add(new Tablet("Tablet", "Apple", "Pro", "M2 chip. Next-generation performance. Next generation capabilities.",12.9 ,128, 1059.00, 1099.00, 13));
        tabletList.add(new Tablet("Tablet", "Samsung", "Galaxy Tab S9 Ultra", "Powerful tablet", 14.6, 256, 1059.99, 1199.99, 186));

        for (Tablet tablet : tabletList) {
            System.out.println();
        }
    }
}
