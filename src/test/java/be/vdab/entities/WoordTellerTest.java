package be.vdab.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WoordTellerTest {

    @Test(expected = IllegalArgumentException.class)
    public void zinMet0WoordenIsVerkeerd() {
	new WoordTeller("");
    }

    @Test(expected = NullPointerException.class)
    public void zinMetNullIsVerkeerd() {
	new WoordTeller(null);
    }

    @Test
    public void zinMet1WoordIsOk() {
	new WoordTeller("Hello");
    }

    @Test
    public void zinMet2WoordenIsOk() {
	new WoordTeller("Hello world");
    }

    @Test
    public void zinMet2WoordenEnMeerdereSpatiesIsOk() {
	new WoordTeller("Hello    world");
    }

    @Test
    public void telWoordenRetourneert1WoordInZin() {
	WoordTeller woordTeller = new WoordTeller("Hello");
	assertEquals(1, woordTeller.telWoorden());
    }

    @Test
    public void telWoordenRetourneert1WoordInZinMet2Spaties() {
	WoordTeller woordTeller = new WoordTeller(" Hello ");
	assertEquals(1, woordTeller.telWoorden());
    }

    @Test
    public void telWoordenRetourneert2WoordenInZinMet1Spatie() {
	WoordTeller woordTeller = new WoordTeller("Hello world");
	assertEquals(2, woordTeller.telWoorden());
    }

    @Test
    public void telWoordenRetourneert2WoordenInZinMet3Spaties() {
	WoordTeller woordTeller = new WoordTeller(" Hello  world");
	assertEquals(2, woordTeller.telWoorden());
    }

    @Test
    public void telWoordenRetourneert3WoordenInZinMet5Spaties() {
	WoordTeller woordTeller = new WoordTeller("Java  is  awesome ");
	assertEquals(3, woordTeller.telWoorden());
    }

    @Test
    public void toStringGeeftDeZinTerug() {
	String zin = "Dit is een zin, ik heb niets originelers kunnen bedenken";
	assertEquals(zin, new WoordTeller(zin).toString());
    }

}