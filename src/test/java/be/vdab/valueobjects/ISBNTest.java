package be.vdab.valueobjects;

import org.junit.Test;
import static org.junit.Assert.*;

public class ISBNTest {

    @Test
    public void getalMet13CorrecteCijfersIsOk() {
	new ISBN(9789027439642L);
    }

    @Test
    public void eerste3CijfersMoeten978Zijn() {
	ISBN isbn = new ISBN(9789027439642L);
	assertEquals("978", isbn.toString().substring(0, 2));
    }

    @Test
    public void eerste3CijfersMoeten979Zijn() {
	ISBN isbn = new ISBN(9799027439642L);
	assertEquals("979", isbn.toString().substring(0, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getalMet12CijfersIsVerkeerd() {
	new ISBN(978902743964L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getalMet14CijfersIsVerkeerd() {
	new ISBN(97890274396421L);
    }

    @Test(expected = NullPointerException.class)
    public void getalMetNullIsVerkeerd() {
	new ISBN(Long.valueOf(null));
    }

    @Test
    public void toStringGeeftNummerTerug() {
	long nummer = 9789027439642L;
	assertEquals(nummer, new ISBN(nummer).toString());
    }

    @Test
    public void somVanDeCijfersOpDeEersteZesOnevenPositiesMoet33Zijn() {
	ISBN isbn = new ISBN(9789027439642L);
	long somOneven = 0;
	for (int i = 0; i < 12; i += 2) {
	    somOneven += Long.parseLong(isbn.toString().substring(i, i));
	}
	long somEven = 0;
	for (int i = 1; i < 12; i += 2) {
	    somEven += Long.parseLong(isbn.toString().substring(i, i));
	}
	long som = somOneven + somEven * 3;
	assertEquals(2, 140 - som);
    }

}
