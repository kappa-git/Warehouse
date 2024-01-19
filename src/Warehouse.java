import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Warehouse {
    private List<Product> scaffoldItems = new ArrayList<>();

    public Warehouse() {
        this.scaffoldItems.addAll(getInventory());
    }

    public void addQuantityProduct(Product product, int quantityToAdd) {
        Product productToUpdate = scaffoldItems.stream()
                .filter(productToCheck -> productToCheck.getProductId() == product.getProductId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        productToUpdate.setQuantity(productToUpdate.getQuantity() + quantityToAdd);
        System.out.println("LOG - Warehouse - Product added to the Warehouse");
    }

    public Boolean removeProduct(int deviceToRemove, int quantityToRemove) {
        List<Product> list = scaffoldItems.stream().filter(productToFind -> productToFind.getProductId()== deviceToRemove).toList();
        Product product = null;

        if (!list.isEmpty()) {
            product = list.getFirst();
            product.setQuantity(product.getQuantity()-quantityToRemove);
            return true;
        }
        else
            return false;
    }
//    public void removeProduct(Integer productId, int quantityToRemove) {
//        Product productToUpdate = scaffoldItems.stream()
//                .filter(productToCheck -> productToCheck.getProductId() == productId)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
//
//        int currentQuantity = productToUpdate.getQuantity();
//        if (currentQuantity < quantityToRemove) {
//            throw new IllegalArgumentException("Insufficient quantity in the warehouse");
//        }
//
//        productToUpdate.setQuantity(currentQuantity - quantityToRemove);
//        System.out.println("LOG - WAREHOUSE - Product removed from the Warehouse");
//    }


    public List<Product> getInventory() {
        Notebook laptop = new Notebook("Notebook", "Asus", "ZenBook", "Non disponibile", 14, 1024, 850.00, 1000.00, 4431);
        Notebook laptop1 = new Notebook("Notebook", "Hp", "Pavilion Plus", "Non disponibile", 16, 2048, 780.00, 1199.00, 4432);
        Tablet tablet1 = new Tablet("Tablet", "Lenovo", "M10 plus", "Non disponibile", 10.6, 128, 300.00, 359.01, 1268);
        Tablet tablet2 = new Tablet("Tablet", "Microsoft", "Surface Pro 9", "Non disponibile", 13, 256, 998.00, 1300.00, 1269);
        Tablet tablet3 = new Tablet("Tablet", "Apple", "Ipad Air", "Non disponibile", 10.9, 64, 550.00, 630.00, 1270);
        Smartphone phone = new Smartphone("Smartphone", "Apple", "Iphone 11", "Non disponibile", 6.1, 128, 320.00, 480.00, 1123);
        Smartphone phone2 = new Smartphone("Smartphone", "TCL", "40SE", "Non disponibile", 6.0, 32, 120.00, 230.00, 7648);

        return new ArrayList<>(Arrays.asList(laptop, laptop1, tablet1, tablet2, tablet3, phone, phone2));
    }

    public List<Product> getItems() {
        return scaffoldItems;
    }


}
