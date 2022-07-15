package src.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Store;
import src.main.models.Movie;

public class StoreTest {

    Store store;

    @Before
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test
    public void addMovieTest() {
        assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }
    
    @Test
    public void sellMovieTest() {
        store.sellMovie("the godfather");
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test(expected = IllegalStateException.class)
    public void movieNotInStockTest() {
        store.rentMovie("the godfather");
        store.sellMovie("the godfather");
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("the shawshank redemption");
        assertFalse(store.getMovie(0).isAvailable());

    }

    @Test
    public void returnMovieTest() {
        store.rentMovie("the shawshank redemption");
        store.returnMovie("the shawshank redemption");
        assertTrue(store.getMovie(0).isAvailable());
    }
}
