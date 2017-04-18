package be.vdab.valueobjects;

public class Woord {

    String woord;

    public Woord(String woord) {
	this.woord = woord;
    }

    public String getWoord() {
	return woord;
    }

    public void setWoord(String woord) {
	this.woord = woord;
    }

    public boolean isPalindroom() {
	StringBuilder sb = new StringBuilder(woord);
	return sb.toString().equals(sb.reverse().toString());
    }

}
