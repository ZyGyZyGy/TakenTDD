package be.vdab.valueobjects;

import java.util.regex.Pattern;

public class ISBN {

    private static final Pattern REG_EXPR = Pattern.compile("^\\d{13}$");
    private long isbn;

    public ISBN(long isbn) {
	String isbnStr = String.valueOf(isbn);
	if (!REG_EXPR.matcher(isbnStr).matches()) {
	    throw new IllegalArgumentException("Verkeerd formaat");
	}
	if (!isbnStr.substring(0, 2).equals("978") || !isbnStr.substring(0, 2).equals("979")) {
	    throw new IllegalArgumentException("Eerste 3 cijfers moeten 978 of 979 zijn");
	}
	if (controleerISBN(isbn)) {
	    this.isbn = isbn;
	} else {
	    throw new IllegalArgumentException();
	}
    }

    private boolean controleerISBN(long isbn) {
	long somOneven = 0;
	for (int i = 0; i < 12; i += 2) {
	    somOneven += Long.parseLong(String.valueOf(isbn).substring(i, i + 1));
	}
	long somEven = 0;
	for (int i = 1; i < 12; i += 2) {
	    somEven += Long.parseLong(String.valueOf(isbn).substring(i, i + 1));
	}
	long som = somOneven + somEven * 3;
	
	long hogerGelegenTiental = som;
	while (hogerGelegenTiental % 10 != 0) {
	    hogerGelegenTiental++;
	}
	long verschil = hogerGelegenTiental - som;
	return verschil == Long.parseLong(String.valueOf(isbn).substring(12, 13));
    }

    
    
    //9789027439642
    
    
    
    public long getIsbn() {
	return isbn;
    }

    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }

    @Override
    public String toString() {
	return String.valueOf(isbn);
    }

}
