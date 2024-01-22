import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager= new Manager();
    @Test
    public void addNegativeQuantityCart(){
        int deviceIdToAdd = 1123;
        int quantityToAdd = -1;
        Boolean result = manager.addToCart(deviceIdToAdd, quantityToAdd);
        Assert.assertFalse(result);
    }
    @Test
    public void addToCartExactCart(){
        int deviceIdToAdd = 1123;
        int quantityToAdd = 100;
        manager.addToWarehouse(deviceIdToAdd, quantityToAdd);
        Boolean result = manager.addToCart(deviceIdToAdd, quantityToAdd);
        Assert.assertTrue(result);
    }
    @Test
    public void addToCartMagg1Cart(){
        int deviceIdToAdd = 1123;
        int quantityToAdd = 105;
        manager.addToWarehouse(deviceIdToAdd, quantityToAdd);
        int deviceIdToAdd1 = 1123;
        int quantityToAdd1 = 100;
        Boolean result = manager.addToCart(deviceIdToAdd1, quantityToAdd1);
        Assert.assertTrue(result);
    }
    @Test
    public void addToCartMin1Cart(){
        int deviceIdToAdd = 1123;
        int quantityToAdd = 99;
        manager.addToWarehouse(deviceIdToAdd, quantityToAdd);
        int deviceIdToAdd1 = 1123;
        int quantityToAdd1 = 100;
        Boolean result = manager.addToCart(deviceIdToAdd1, quantityToAdd1);
        Assert.assertFalse(result);
    }
    @Test
    public void wrongIdCart(){
        int deviceIdToAdd = 1122;
        int quantityToAdd = 100;
        Boolean result = manager.addToCart(deviceIdToAdd, quantityToAdd);
        Assert.assertFalse(result);
    }
    @Test
    public void productNullCart(){
        Integer deviceIdToAdd = null;
        int quantityToAdd = 100;
        Assert.assertThrows(NullPointerException.class, () -> manager.addToCart(deviceIdToAdd, quantityToAdd));
    }
    @Test
    public void quantityNullCart(){
        Integer quantityToAdd = null;
        int deviceIdToAdd = 100;
        Assert.assertThrows(NullPointerException.class, () -> manager.addToCart(deviceIdToAdd, quantityToAdd));
    }
    @Test
    public void quantityEquals0(){
        int deviceIdToAdd = 1123;
        int quantityToAdd = 0;
        Boolean result = manager.addToCart(deviceIdToAdd, quantityToAdd);
        Assert.assertFalse(result);
    }
    @Test // Controllo se il metodo searchPurchasePrice è valido
    void checkIfSearchPurchasePriceIsValid(){
        Double price = null;
        Manager warehouseManager = new Manager();
        assertThrows(NullPointerException.class, ()-> warehouseManager.searchByPurchasePrice(price));
        /*Il metodo si aspetta un primitivo e noi gli stiamo passando null*/
    }

    @Test // Controllo che il metodo searchPurchasePrice non ritorna un null
    void checkIfSearchPurchasePriceIsNotRetrurnNull(){
        double input = new Random().nextDouble();
        Manager warehouseManager = new Manager();
        assertNotEquals(warehouseManager.searchByPurchasePrice(input), null);
        /* Cosa stiamo testando?
        * Passando come input un valore che non sia null, vogliamo testare se il
        * metodo restituisce una Lista che non sia null*/
    }
    @Test
    void checkIfSearchPurchasePriceIsNegative(){
        double input = -1;
        Manager warehouseManager = new Manager();
        List<Product> result = warehouseManager.searchByPurchasePrice(input);
        assertEquals(result, Collections.emptyList());
    }
    @Test
    void checkIfSearchBySellingPriceThereIsAnElementOf500Dollars(){
        Manager warehouseManager = new Manager();
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

}