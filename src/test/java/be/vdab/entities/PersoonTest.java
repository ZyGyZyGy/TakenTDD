package be.vdab.entities;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersoonTest {

    @Test(expected = IllegalArgumentException.class)
    public void persoonMetLegeArrayIsVerkeerd() {
	new Persoon(new String[] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void persoonMetBlankcoVoornaamIsVerkeerd() {
	new Persoon(new String[] {"Alex", "", "Jimmy", ""});
    }
    
    @Test(expected = NullPointerException.class)
    public void persoonMetNullIsVerkeerd() {
	new Persoon(null);
    }

    @Test
    public void persoonMet1VoornaamIsOk() {
	new Persoon(new String[] { "Alex" });
    }

    @Test(expected = NullPointerException.class)
    public void persoonMet1VoornaamMetNullIsNietOk() {
	new Persoon(new String[] { null});
    }

    
    @Test
    public void persoonMet2VoornamenIsOk() {
	new Persoon(new String[] { "Alex", "William" });
    }

    @Test(expected = IllegalArgumentException.class)
    public void persoonMet2ZelfdeVoornamenIsVerkeerd() {
	new Persoon(new String[] { "Alex", "Alex" });
    }

    @Test
    public void equalsOpTweeDezelfdePersonenGeeftTrue() {
	assertEquals(
		new Persoon(new String[] { "Alex", "Jimmy"}),
		new Persoon(new String[] { "Alex", "Jimmy" }));
    }

    @Test
    public void equalsOpTweeVerschillendePersonenGeeftFalse() {
	assertNotEquals(
		new Persoon(new String[] { "Alex", "William" }),
		new Persoon(new String[] { "Alex", "Jimmy" }));
    }

    @Test
    public void hashCodeOpTweeDezelfdePersonenMoetGelijkZijn() {
	assertEquals(
		new Persoon(new String[] { "Alex", "Jimmy" }).hashCode(),
		new Persoon(new String[] { "Alex", "Jimmy" }).hashCode());
    }
    
    @Test
    public void toStringMoetAlleVoornamenTeruggevenGescheidenDoorSpatieMetJuisteVolgorde() {
	String alleVoornamen = "Alex William Jimmy";
	assertEquals(alleVoornamen, 
		new Persoon(new String[] { "Alex", "William", "Jimmy" }).toString());
    }
    
}
