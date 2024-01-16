import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart = new Cart();
    @Test
    public void checkIfProductAddedIsNull(){
        Product product= null;
        List<Product> result= cart.addToCart(product);
        assertFalse(result.contains(product));
    }
    @Test
    public void checkIfProductWasAdddedtoCart(){
        Product product= new Product();
        List<Product> result = cart.addToCart(product);
        assertTrue(result.contains(product));
    }

}