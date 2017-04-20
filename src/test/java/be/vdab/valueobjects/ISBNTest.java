package be.vdab.valueobjects;

import org.junit.Test;
import static org.junit.Assert.*;

public class ISBNTest {

    @Test(expected = IllegalArgumentException.class)
    public void hetNummer0IsVerkeerd() {
	new ISBN(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void eenNegatiefNummerIsVerkeerd() {
	new ISBN(-9789027439642L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void eenNummerMet12CijfersIsVerkeerd() {
	new ISBN(978902743964L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void eenNummerMet14CijfersIsVerkeerd() {
	new ISBN(97890274396421L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deEerste3CijfersMoeten978of979Zijn() {
	new ISBN(9779227439643L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void eenNummerMet13CijfersMetVerkeerdControleGetal2() {
	new ISBN(8789027439642L);
    }

    @Test
    public void eenNummerMet13CijfersMetCorrectControleGetal2() {
	new ISBN(9789027439642L); // CORRECTE WAARDE - dit mag geen exception veroorzaken
    }

    @Test(expected = IllegalArgumentException.class)
    public void eenNummerMet13CijfersMetVerkeerdControleGetal3() {
	new ISBN(9789027439643L);
    }

    @Test
    public void eenNummerMet13CijfersMetCorrectControleGetal0() {
	new ISBN(9789227439640L);
    }

    @Test
    public void toStringMoetHetNummerTeruggeven() {
	long nummer = 9789027439642L;
	assertEquals(nummer, Long.parseLong(new ISBN(nummer).toString()));
    }

}
