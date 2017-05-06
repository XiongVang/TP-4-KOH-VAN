package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contoller.CheckCopiesInController;
import contoller.CheckCopiesOutController;

public class CheckCopiesInControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCopyIn() {
		CheckCopiesInController ccic = new CheckCopiesInController();
		String cid = "C1T1R";
		assertTrue("copy ID is valid",ccic.isValidCopyID(cid));
		ccic.setCopy(cid);
		assertEquals("copy ID is " + cid,ccic.getCopyID(),cid);
		assertFalse("copy should not be checked out",ccic.copyWasCheckedOut());
		this.checkCopyOut(cid);
		assertNotNull("should get name of patron",ccic.checkCopyIn());
	}
	
	@Test
	public void testNullCopyIn() {
		CheckCopiesInController ccic = new CheckCopiesInController();
		assertFalse("null copy, return false",ccic.copyWasCheckedOut());
		assertEquals("null copy, empty string","",ccic.checkCopyIn());
	}	
	
	public boolean checkCopyOut(String cid) {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		ccoc.addCopy(cid);
		ccoc.setCurrentPatron("P1");
		ccoc.checkOutCopies();
		return true;
	}
	
}
