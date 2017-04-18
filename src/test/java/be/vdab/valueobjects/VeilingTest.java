package be.vdab.valueobjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class VeilingTest {

    @Test
    public void hoogsteBodVanNieuweVeilingIs0() {
	Veiling veiling = new Veiling();
	assertEquals(0, veiling.getHoogsteBod());
    }
    
    @Test
    public void hoogsteBodNaEersteBodIs1000() {
	Veiling veiling = new Veiling();
	veiling.doeBod(1000);
	assertEquals(1000, veiling.getHoogsteBod());
    }
    
    @Test
    public void hoogsteBodNaMeerdereBoddenIs3000() {
	Veiling veiling = new Veiling();
	veiling.doeBod(1000);
	veiling.doeBod(2000);
	veiling.doeBod(3000);
	assertEquals(3000, veiling.getHoogsteBod());
    }

}
