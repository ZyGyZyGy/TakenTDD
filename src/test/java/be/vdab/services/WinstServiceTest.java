package be.vdab.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.repositories.KostenRepository;
import be.vdab.repositories.OpbrengstRepository;

public class WinstServiceTest {

    private OpbrengstRepository opbrengstRepository;
    private KostenRepository kostenRepository;
    private WinstService winstService;

    @Before
    public void before() {
	opbrengstRepository = mock(OpbrengstRepository.class);
	when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(1000));
	kostenRepository = mock(KostenRepository.class);
	when(kostenRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(300));
	winstService = new WinstService(opbrengstRepository, kostenRepository);
    }

    @Test
    public void getWinst() {
	assertEquals(0, BigDecimal.valueOf(700).compareTo(winstService.getWinst()));
	verify(opbrengstRepository).findTotaleOpbrengst();
	verify(kostenRepository).findTotaleKost();
    }

}
