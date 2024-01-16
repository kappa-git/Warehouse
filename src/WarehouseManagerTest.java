import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseManagerTest {
    @Test // Controllo se il metodo searchPurchasePrice è valido
    void checkIfSearchPurchasePriceIsValid(){
        Double price = null;
        WarehouseManager warehouseManager = new WarehouseManager();
        assertThrows(NullPointerException.class, ()-> warehouseManager.searchByPurchasePrice(price));
        /*Il metodo si aspetta un primitivo e noi gli stiamo passando null*/
    }

    @Test // Controllo che il metodo searchPurchasePrice non ritorna un null
    void checkIfSearchPurchasePriceIsNotRetrurnNull(){
        double input = new Random().nextDouble();
        WarehouseManager warehouseManager = new WarehouseManager();
        assertNotEquals(warehouseManager.searchByPurchasePrice(input), null);
        /* Cosa stiamo testando?
        * Passando come input un valore che non sia null, vogliamo testare se il
        * metodo restituisce una Lista che non sia null*/
    }
    @Test
    void checkIfSearchPurchasePriceIsNegative(){
        double input = -1;
        WarehouseManager warehouseManager = new WarehouseManager();
        List<Product> result = warehouseManager.searchByPurchasePrice(input);
        assertEquals(result, Collections.emptyList());
    }
    @Test
    void checkIfSearchBySellingPriceThereIsAnElementOf500Dollars(){
        WarehouseManager warehouseManager = new WarehouseManager();
        double price = 500.0;
        List<Product> result = warehouseManager.searchBySellingPrice(price);
//        Boolean listIsEmpty = result.isEmpty();

        List<Product> resultPrice = new ArrayList<>();
        for(Product product : result){
            if(product.getSellingPrice() == price){
                resultPrice.add(product);
            }
        }
           assertEquals(result, resultPrice);

    }
    @Test
    void checkIfSearchBySellingPriceInputIsNull(){
        Double input = null;
        WarehouseManager warehouseManager = new WarehouseManager();
        assertThrows(NullPointerException.class, ()-> warehouseManager.searchBySellingPrice(input));

    }
    @Test
    void checkIfSearchBySellingPriceReturnIsNotNull(){
        WarehouseManager warehouseManager = new WarehouseManager();
        Double input = 230.90;
        List<Product> result = warehouseManager.searchBySellingPrice(input);
        assertNotEquals(null, result);
    }

   //test sotto da finire, da sistemare searchBySellingPrice
    @Test
    void checkifSearchBySellingPriceInputIsNegative(){
        WarehouseManager warehouseManager = new WarehouseManager();
        Integer input = -1;
        List<Product> result = warehouseManager.searchBySellingPrice(input);

    }
}