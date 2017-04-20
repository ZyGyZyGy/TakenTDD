package be.vdab.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.repositories.KostenRepository;
import be.vdab.repositories.KostenRepositoryStub;
import be.vdab.repositories.OpbrengstRepository;
import be.vdab.repositories.OpbrengstRepositoryStub;

public class WinstServiceTest {

    private OpbrengstRepository opbrengstRepository;
    private KostenRepository kostenRepository;
    private WinstService winstService;

    @Before
    public void before() {
	opbrengstRepository = new OpbrengstRepositoryStub();
	kostenRepository = new KostenRepositoryStub();
	winstService = new WinstService(opbrengstRepository, kostenRepository);
    }

    @Test
    public void getWinst() {
	assertEquals(0, BigDecimal.valueOf(700).compareTo(winstService.getWinst()));
    }

}
