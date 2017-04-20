package be.vdab.valueobjects;

import java.util.HashSet;
import java.util.Set;

public class ISBN {

    private static final long KLEINSTE_GETAL_MET_13_CIJFERS = 1000_000_000_000L;
    private static final long GROOTSTE_GETAL_MET_13_CIJFERS = 9999_999_999_999L;
    private static final Set<Short> MOGELIJKE_EERSTE_3_CIJFERS = new HashSet<>();
    private final long nummer;

    static {
	MOGELIJKE_EERSTE_3_CIJFERS.add((short) 978);
	MOGELIJKE_EERSTE_3_CIJFERS.add((short) 979);
    }

    // 9789027439642

    public ISBN(long nummer) {
	if (nummer < KLEINSTE_GETAL_MET_13_CIJFERS || nummer > GROOTSTE_GETAL_MET_13_CIJFERS) {
	    throw new IllegalArgumentException("Bevat geen 13 cijfers");
	}
	short eerste3Cijfers = (short) (nummer / 10_000_000_000L);
	if (!MOGELIJKE_EERSTE_3_CIJFERS.contains(eerste3Cijfers)) {
	    throw new IllegalArgumentException("Begint niet met " + MOGELIJKE_EERSTE_3_CIJFERS);
	}
	long somEvenCijfers = 0;
	long somOnEvenCijfers = 0;
	long teVerwerkenCijfers = nummer / 10;
	// teVerwerkenCijfers = 978902743964
	for (int teller = 0; teller != 6; teller++) {
	    somEvenCijfers += teVerwerkenCijfers % 10;
	    // somEvenCijfers += 4
	    teVerwerkenCijfers /= 10;
	    // teVerwerkenCijfers = 97890274396
	    somOnEvenCijfers += teVerwerkenCijfers % 10;
	    // somOnEvenCijfers += 6
	    teVerwerkenCijfers /= 10;
	    // teVerwerkenCijfers = 9789027439
	}
	long controleGetal = somEvenCijfers * 3 + somOnEvenCijfers;
	long naastGelegenHoger10Tal = controleGetal - controleGetal % 10 + 10;
	// naastGelegenHoger10Tal = 138 - 8 + 10
	// naastGelegenHoger10Tal = 140
	long verschil = naastGelegenHoger10Tal - controleGetal;
	// verschil = 140 - 138 = 2
	long laatsteCijfer = nummer % 10;
	// laatsteCijfer = 9789027439642 % 10 = 2
	if (verschil == 10) {
	    if (laatsteCijfer != 0) {
		throw new IllegalArgumentException("Verkeerd controlegetal");
	    }
	} else {
	    if (laatsteCijfer != verschil) {
		throw new IllegalArgumentException("Verkeerd controlegetal");
	    }
	}
	this.nummer = nummer;
    }

    @Override
    public String toString() {
	return String.valueOf(nummer);
    }
}
// test
