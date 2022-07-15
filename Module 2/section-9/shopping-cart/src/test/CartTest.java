package src.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;

public class CartTest {

    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.addItem(new Item("Spinach", 0.99));
        cart.addItem(new Item("Parsley", 1.29));
    }

    @Test
    public void addItemTest() {
        assertTrue(cart.contains(new Item("Spinach", 0.99)));
    }

    @Test
    public void skipDuplicateTest() {
        assertFalse(cart.addItem(new Item("Spinach", 0.99)));
    }

    @Test
    public void removeItemTest() {
        cart.removeItem("spinach");
        assertFalse(cart.contains(new Item("Spinach", 0.99)));
    }

    @Test(expected = IllegalStateException.class)
    public void removeFromEmptyCart() {
        cart.clearCart();
        cart.removeItem("spinach");
    }

    @Test
    public void subtotalIsValid() {
        assertEquals(2.28, cart.getSubtotal(), 0);
    }

    @Test
    public void taxIsValid() {
        assertEquals(0.34, cart.getTax(), 0);
    }

    @Test
    public void totalIsValid() {
        assertEquals(2.62, cart.getTotal(), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void checkoutEmptyCart() {
        cart.clearCart();
        cart.checkout();
    }
    
}
