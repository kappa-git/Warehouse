import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void checkIfProductAddedIsNull(){
        Cart cart = new Cart();
        Product product = null;
        List<Product> result = cart.addToCart(product);
        assertTrue(result.contains(product));


    }
    @Test
    void checkIfProductWasAddedToCart(){
        Cart cart = new Cart();
        Product product = new Product();
        List<Product> result = cart.addToCart(product);
        assertTrue(result.contains(product));
    }

}