import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Assert;
import java.util.List;

class WarehouseManagerTest {
    WarehouseManager warehouseManager = new WarehouseManager();
    Warehouse warehouse = new Warehouse();
    @Test
    public void searchBySellingPrice() {
        double price1 = 500.0;
        List<Product> result = warehouseManager.searchBySellingPrice(price1);
        Boolean listNotNull = result != null;
        Boolean listIsEmpty = result.isEmpty();

        Assert.assertEquals(500, result);
    }
}