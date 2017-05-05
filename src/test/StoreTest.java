package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Copy;
import domain.Patron;
import domain.Textbook;
import mock.Store;

public class StoreTest {

	Store s;
	
	@Before
	public void setUp() throws Exception {
		this.s = new Store();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetPatron() {
		assertNotNull(s.getPatron("P1"));		
	}

	@Test
	public void testGetRentalCopy() {
		assertNotNull(s.getRentalCopy("C1T1R"));
	}

	@Test
	public void testGetSaleCopy() {
		assertNotNull(s.getSaleCopy("C1T1S"));
	}

	@Test
	public void testRemoveSaleCopy() {
		try {
			s.removeSaleCopy("C1T1S");
		} catch (Exception e) {
			fail("failed to remove sale copy: "+e.toString());
		}
	}

	@Test
	public void testGetTextbook() {
		assertNotNull(s.getTextbook("111"));
	}

	@Test
	public void testGetDueDate() {
		assertNotNull(s.getDueDate());
	}

}
