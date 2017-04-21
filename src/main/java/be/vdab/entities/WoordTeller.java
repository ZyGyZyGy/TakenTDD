package be.vdab.entities;

public class WoordTeller {

    private String zin;
//    private static final String REG_EXPR = "\\s+";

    public WoordTeller(String zin) {
	if (zin == null) {
	    throw new NullPointerException();
	}
	this.zin = zin;
    }

    @Override
    public String toString() {
	return zin;
    }

    // new WoordTeller(",, , ");
    
    public int telWoorden() {
	int aantalWoorden = 0;
	int index = 0;
	while (index != zin.length()) {
	    while (index != zin.length() && (zin.charAt(index) == ' ' || zin.charAt(index) == ',')) {
		index++;
	    }
	    if (index != zin.length()) {
		aantalWoorden++;
		while (index != zin.length() && zin.charAt(index) != ' ' && zin.charAt(index) != ',') {
		    index++;
		}
	    }
	}
	return aantalWoorden;
    }
    
    
    
    
    
    
    
    
    

    // bij rare zinnen met alles behalve alfanumerike tekens werkt niet goed
    // public int telWoorden() {
    // int aantalWoorden = 0;
    // if (!zin.isEmpty()) {
    // String[] arrWoorden = zin.trim().split(REG_EXPR);
    // for (String woord : arrWoorden) {
    // aantalWoorden++;
    // }
    // }
    // return aantalWoorden;
    // }

}
