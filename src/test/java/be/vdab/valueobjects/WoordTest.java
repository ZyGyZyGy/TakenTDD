package be.vdab.valueobjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WoordTest {

    @Test
    public void lepel_is_palindroom() {
	assertTrue(new Woord("lepel").isPalindroom());
    }

    @Test
    public void toetsenboord_is_geen_palindroom() {
	assertFalse(new Woord("toetsenboord").isPalindroom());
    }

    @Test
    public void lege_string_is_palindroom() {
	assertTrue(new Woord("").isPalindroom());
    }
}
