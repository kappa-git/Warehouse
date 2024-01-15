import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseManagerTest {
    @Test
    void checkIfSearchPurchasePriceIsValid(){
        Double price = null;
        WarehouseManager warehouseManager = new WarehouseManager();
        assertThrows(NullPointerException.class, ()-> warehouseManager.searchByPurchasePrice(price));
        /*Il metodo si aspetta un primitivo e noi gli stiamo passando null*/
    }

    @Test
    void checkIfSearchPurchasePriceIsNotRetrurnNull(){
        Double input = 3.0;
        WarehouseManager warehouseManager = new WarehouseManager();
        assertNotEquals(warehouseManager.searchByPurchasePrice(input), null);
        /* Cosa stiamo testando?
        * Passando come input un valore che non sia null, vogliamo testare se il
        * metodo restituisce una Lista che non sia null*/
    }

}