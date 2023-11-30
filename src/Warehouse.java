import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warehouse {
    public static void main(String[] args) {
        Notebook laptop = new Notebook("Notebook", "Asus", "ZenBook", "Non disponibile", 14, 512, 850.00, 1000.00, 4431);
        Notebook laptop1 = new Notebook("Notebook", "Hp", "Pavilion Plus", "Non disponibile", 16, 1000, 780.00, 1199.00, 4432);
        Tablet tablet = new Tablet("Tablet","Lenovo","M10 plus","Non disponibile",10.6,64,300.00,359.01,1268);
        Tablet tablet1 = new Tablet("Tablet","Microsoft","Surface Pro 9","Non disponibile",13,256,998.00,1300.00,1269);
        Tablet tablet2 = new Tablet("Tablet","Apple","Ipad Air","Non disponibile",10.9,256,550.00,630.00,1270);
        Smartphone phone = new Smartphone("Smartphone","Apple","Iphone 11","Non disponibile",6.1,128,320.00,480.00,1123);
        Smartphone phone2 = new Smartphone("Smartphone","TCL","40SE","Non disponibile",6.0,256,120.00,230.00,7648);

        List<Notebook> lista = Arrays.asList(laptop, laptop1);
        List<Tablet> lista1 = Arrays.asList(tablet,tablet1,tablet2);
        List<Smartphone> lista2 = Arrays.asList(phone,phone2);

        StringBuilder notebook = new StringBuilder();
        for (Notebook element : lista){
            notebook.append(element).append(" ");

        }
        StringBuilder tab = new StringBuilder();
        for (Tablet element : lista1){
            tab.append(element).append(" ");

        }
        StringBuilder smartphone = new StringBuilder();
        for (Smartphone element : lista2){
            smartphone.append(element).append(" ");

        }

        System.out.println("Computer Portatili disponibili: " + '\n' + notebook);
        System.out.println("Tablet disponibili: " + '\n' + lista1);
        System.out.println("Smartphone disponibili: " + '\n' + lista2);

    }

}
