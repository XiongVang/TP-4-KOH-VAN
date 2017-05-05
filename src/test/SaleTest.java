package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Copy;
import domain.Sale;
import domain.Textbook;
import lib.StdOut;

public class SaleTest {

	private Copy testCopy;
	
	@Before
	public void setUp() throws Exception {
		Textbook t = new Textbook("TEST12345","test title", "test author", 1);
		this.testCopy = new Copy("TEST12345", t);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSale() {
		assertNotNull("new Sale object should not be null",new Sale());
	}

	@Test
	public final void testCopiesInSale() {
		Sale s = new Sale();
		s.addSaleCopy(this.testCopy);
		assertEquals("sale should have 1 copy",1,s.copiesInSale());
	}

	@Test
	public final void testGetTotal() {
		Sale s = new Sale();
		s.addSaleCopy(this.testCopy);
		StdOut.println(s.getTotal());
		assertEquals("sale should have total of 1",s.getTotal(),1.0,.001);		
	}

	@Test
	public final void testComplete() {
		try {
			Sale s = new Sale();
			s.addSaleCopy(this.testCopy);
			s.complete();
		} catch (Exception e) {
			fail("addSaleCopy and complete should not result in exception: " + e);
		}
	}

	@Test
	public final void testHasCopy() {
		Sale s = new Sale();
		s.addSaleCopy(this.testCopy);
		assertTrue("sale should have copy",s.hasCopy("TEST12345"));
	}

	@Test
	public final void testToString() {
		Sale s = new Sale();
		s.addSaleCopy(this.testCopy);
		assertNotNull("toString should not be null",s.toString());
	}

}
