package be.vdab.repositories;

import java.math.BigDecimal;

public class KostenRepositoryStub implements KostenRepository {

    @Override
    public BigDecimal findTotaleKost() {
	return BigDecimal.valueOf(300);
    }

}
