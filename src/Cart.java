package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
private ArrayList<String> warehouse;
private ArrayList<String> cart;

public Cart() {
warehouse = new ArrayList<String>();
cart = new ArrayList<String>();
        }

public void addToWarehouse(String device) {
warehouse.add(device);
        System.out.println(device + " aggiunto al magazzino.");
        }

public void unloadFromWarehouse(String device) {
        if (warehouse.contains(device)) {
            warehouse.remove(device);
        System.out.println(device + " rimosso da magazzino.");
        } else {
        System.out.println("Questo " + device + " non è disponibile.");
        }
        }

public void addToCart(String device) {
        if (warehouse.contains(device)) {
cart.add(device);
warehouse.remove(device);
        System.out.println(device + " aggiunto al carrello.");
        } else {
        System.out.println("Il dispositivo non è disponibile nel magazzino: " + device);
        }
        }

public void stampWarehouse() {
        System.out.println("Dispositivi disponibili in magazzino:");
        for (String device : warehouse) {
        System.out.println(device);
        }
        }

public void stampCart() {
        System.out.println("Dispositivi nel carrello:");
        for (String device : cart) {
        System.out.println(device);
        }
        }

public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
        System.out.println("Seleziona un'operazione da compiere:");
        System.out.println("1. Aggiungi dispositivo al magazzino");
        System.out.println("2. Scarica dispositivo dal magazzino");
        System.out.println("3. Aggiungi dispositivo al carrello");
        System.out.println("4. Stampa magazzino e carrello");
        System.out.println("5. Esci");

        choice = scanner.nextInt();

        switch (choice) {
        case 1:
        System.out.println("Inserisci il nome del dispositivo da aggiungere al magazzino:");
        String deviceAdded = scanner.next();
        cart.addToWarehouse(deviceAdded);
        break;
        case 2:
        System.out.println("Inserisci il nome del dispositivo da scaricare dal magazzino:");
        String deviceDownloaded = scanner.next();
        cart.unloadFromWarehouse(deviceDownloaded);
        break;
        case 3:
        System.out.println("Inserisci il nome del dispositivo da aggiungere al carrello:");
        String deviceAddedOnCart = scanner.next();
        cart.addToCart(deviceAddedOnCart);
        break;
        case 4:
        cart.stampWarehouse();
        cart.stampCart();
        break;
        case 5:
        System.out.println("Arrivederci.");
        break;
default:
        System.out.println("Scelta non valida");
        break;
        }
        }

        scanner.close();
        }
        }
