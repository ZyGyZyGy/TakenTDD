package be.vdab.entities;

import java.util.Arrays;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Persoon {

    private String[] voornamen;

    public Persoon(String[] voornamen) {
	setVoornamen(voornamen);
    }

    public void setVoornamen(String[] voornamen) {
	if (voornamen == null) {
	    throw new NullPointerException("Voornamen mag niet null zijn");
	}
	if (voornamen.length == 0) {
	    throw new IllegalArgumentException("Voornamen mag niet leeg zijn");
	}
	if (Arrays.stream(voornamen).anyMatch(voornaam -> voornaam.isEmpty())) {
	    throw new IllegalArgumentException("Een van de voornamen is leeg");
	}
	Set<String> set = Arrays.stream(voornamen).collect(Collectors.toSet());
	if (voornamen.length != set.size()) {
	    throw new IllegalArgumentException("Persoon mag geen twee dezelfde namen hebben");
	}
	this.voornamen = voornamen;
    }

    public String[] getVoornamen() {
	return voornamen;
    }

    @Override
    public boolean equals(Object obj) {
	if (!(obj instanceof Persoon)) {
	    return false;
	}
	Persoon anderePersoon = (Persoon) obj;
	return Arrays.equals(voornamen, anderePersoon.voornamen);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(voornamen);
	return result;
    }

    @Override
    public String toString() {

//	StringBuilder alleVoornamen = new StringBuilder();
//	int index = 0;
//	if (voornamen.length != 0) {
//	    while (index < voornamen.length) {
//		alleVoornamen.append(voornamen[index]);
//		if (index != voornamen.length - 1) {
//		    alleVoornamen.append(" ");
//		}
//		index++;
//	    }
//	} else {
//	    return "";
//	}
//	return alleVoornamen.toString();

	StringJoiner joiner = new StringJoiner(" ");
	for (String voornaam : voornamen) {
	    joiner.add(voornaam);
	}
	return joiner.toString();
    }

}
