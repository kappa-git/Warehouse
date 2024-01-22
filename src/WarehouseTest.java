import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
class WarehouseTest {
class WarehouseTest {
class WarehouseTest {

    @Test

    public void inventoryIsNotEmpty(){
        Warehouse warehouse = new Warehouse();
        List<Product> inventory = warehouse.getInventory();
        assertFalse(inventory.isEmpty());
    }
    @Test
    public void getInventoryGivesPositivePrices(){
        Warehouse warehouse = new Warehouse();
        List<Product> inventory = warehouse.getInventory();
        Boolean result = true;
        for(Product product : inventory){
            if(product.getSellingPrice() < 0 || product.getPurchasePrice() < 0){
                result = false;
            }
        }
        assertTrue(result);
    }
}