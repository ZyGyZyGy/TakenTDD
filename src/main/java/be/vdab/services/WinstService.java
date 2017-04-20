package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.repositories.KostenRepository;
import be.vdab.repositories.OpbrengstRepository;

public class WinstService {

    private final OpbrengstRepository opbrengstRepository;
    private final KostenRepository kostenRepository;

    public WinstService(OpbrengstRepository opbrengstRepository, KostenRepository kostenRepository) {
	this.opbrengstRepository = opbrengstRepository;
	this.kostenRepository = kostenRepository;
    }

    public BigDecimal getWinst() {
	return opbrengstRepository.findTotaleOpbrengst().subtract(kostenRepository.findTotaleKost());
    }

}
