package com.example.devsecops;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void greetReturnsDefaultWhenNameIsNull() {
        assertEquals("Hello, world!", App.greet(null));
    }

    @Test
    public void greetReturnsDefaultWhenNameIsBlank() {
        assertEquals("Hello, world!", App.greet(" "));
    }

    @Test
    public void greetReturnsNameWhenProvided() {
        assertEquals("Hello, John!", App.greet("John"));
    }

    @Test
    public void mainExecutesWithoutError() {
        App.main(new String[] { "John" });
    }

    @Test
    public void mainWhenNoArgs() {
        App.main(new String[] {}); // sin argumentos
    }

    @Test
    public void constructorIsCovered() {
        new App();
    }
}
