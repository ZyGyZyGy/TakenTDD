package be.vdab.entities;

public class WoordTeller {

    private String zin;
    // private static final Pattern REG_EXPR = Pattern.compile("\\s+");
    private static final String REG_EXPR = "\\s+";

    public WoordTeller(String zin) {
	if (zin.isEmpty()) {
	    throw new IllegalArgumentException("Mag geen lege string zijn");
	}
	this.zin = zin;
    }

    @Override
    public String toString() {
	return zin;
    }

    public int telWoorden() {
	String[] arrWoorden = zin.trim().split(REG_EXPR);
	int aantalWoorden = 0;
	for (String string : arrWoorden) {
	    aantalWoorden++;
	}
	return aantalWoorden;
    }

}
