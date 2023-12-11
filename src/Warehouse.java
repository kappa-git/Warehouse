import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warehouse {

    public static List<Notebook> searchNotebooksBySellingPrice(List<Notebook> notebooks, double minPrice, double maxPrice) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            double sellingPrice = notebook.getSellingPrice();

            if (sellingPrice >= minPrice && sellingPrice <= maxPrice) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    public static List<Tablet> searchTabletsBySellingPrice(List<Tablet> tablets, double minPrice, double maxPrice) {
        List<Tablet> filteredTablets = new ArrayList<>();

        for (Tablet tablet : tablets) {
            double sellingPrice = tablet.getSellingPrice();

            if (sellingPrice >= minPrice && sellingPrice <= maxPrice) {
                filteredTablets.add(tablet);
            }
        }

        return filteredTablets;
    }

    public static List<Smartphone>searchSmartphonesBySellingPrice(List<Smartphone> smartphones, double minPrice,double maxPrice){
        List<Smartphone> filteredSmartphones= new ArrayList<>();

        for (Smartphone smartphone: smartphones){
            double sellingPrice= smartphone.getSellingPrice();
            if (sellingPrice>= minPrice && sellingPrice <= maxPrice){
                filteredSmartphones.add(smartphone);
            }
        }
        return filteredSmartphones;
    }

    public static void main(String[] args) {
        Notebook laptop = new Notebook("Notebook", "Asus", "ZenBook", "Non disponibile", 14, 512, 850.00, 1000.00, 4431);
        Notebook laptop2 = new Notebook("Notebook", "Hp", "Pavilion Plus", "Non disponibile", 16, 1000, 780.00, 1199.00, 4432);
        Tablet tablet = new Tablet("Tablet","Lenovo","M10 plus","Non disponibile",10.6,64,300.00,359.01,1268);
        Tablet tablet2 = new Tablet("Tablet","Microsoft","Surface Pro 9","Non disponibile",13,256,998.00,1300.00,1269);
        Tablet tablet3 = new Tablet("Tablet","Apple","Ipad Air","Non disponibile",10.9,256,550.00,630.00,1270);
        Smartphone smartphone= new Smartphone("Smartphone", "Apple","Iphone 15","Non disponibile", 6.12, 256, 500.00, 899.00, 2111);
        Smartphone smartphone2= new Smartphone("Smartphone", "Samsung","Galaxy 23","Non disponibile", 6.10, 256, 450.00, 720.00, 2112);
        Smartphone smartphone3= new Smartphone("Smartphone", "Huawei","P60","Non disponibile", 6.67, 256, 500.00, 1099.00, 2113);



        List<Notebook> lista = Arrays.asList(laptop, laptop2);
        List<Tablet> lista1 = Arrays.asList(tablet,tablet2,tablet3);
        List<Smartphone>lista2 = Arrays.asList(smartphone,smartphone2,smartphone3);

        List<Notebook> filteredNotebooks = searchNotebooksBySellingPrice(lista, 800.0, 1100.0);
        System.out.println("Notebooks within the price range are: ");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.getModel() + " - Selling Price: $" + notebook.getSellingPrice());
        }

        List<Tablet> filteredTablets = searchTabletsBySellingPrice(lista1, 400.0, 700.0);
        System.out.println("Tablets within the price range are: ");
        for (Tablet tabletItem : filteredTablets) {
            System.out.println(tabletItem.getModel() + "- Selling Price: $" + tabletItem.getSellingPrice());
        }

        List<Smartphone> filtertedSmartphones = searchSmartphonesBySellingPrice(lista2,700,1000);
        System.out.println("Smartphones within the price range are: ");
        for (Smartphone smartphoneItem : filtertedSmartphones){
            System.out.println(smartphoneItem.getModel() + " - Selling Price: $" + smartphoneItem.getSellingPrice());
        }



        /*List<Notebook> lista = new ArrayList<Notebook>();
        lista.add(laptop);
        lista.add(laptop2);
        List<Tablet> lista1 = new ArrayList<Tablet>();
        lista1.add(tablet);
        lista1.add(tablet2);
        lista1.add(tablet3);*/


        System.out.println("Computer Portatili: " + lista);
        System.out.println();
        System.out.println("Tablet: " + lista1);

    }

}
