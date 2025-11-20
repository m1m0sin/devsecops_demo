package com.example.devsecops;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testGreetWithName() {
        assertEquals("Hello, Alice!", App.greet("Alice"));
    }

    @Test
    public void testGreetNull() {
        assertEquals("Hello, world!", App.greet(null));
    }
}
