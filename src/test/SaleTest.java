package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Copy;
import domain.Sale;
import domain.Textbook;

public class SaleTest {
	
	private Sale sale = new Sale();
	
	@Test
	public void addSaleCopyTest(){
		sale.addSaleCopy(new Copy("C1T1",
				new Textbook("ISBN","Book1","Author1",1.0)));
		assertEquals(sale.copiesInSale(),1);
		assertEquals(sale.getTotal(),1,.001);
		
	}

}
