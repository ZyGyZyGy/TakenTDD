package be.vdab.valueobjects;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VeilingTest {

    private Veiling veiling;

    @Before
    public void before() {
	veiling = new Veiling();
    }

    @Test
    public void hoogsteBodVanNieuweVeilingIs0() {
	assertEquals(0, veiling.getHoogsteBod());
    }

    @Test
    public void hoogsteBodNaEersteBodIs1000() {
	veiling.doeBod(1000);
	assertEquals(1000, veiling.getHoogsteBod());
    }

    @Test
    public void hoogsteBodNaMeerdereBoddenIs3000() {
	veiling.doeBod(1000);
	veiling.doeBod(2000);
	veiling.doeBod(3000);
	assertEquals(3000, veiling.getHoogsteBod());
    }

}
