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
		this.checkCopyOut();
		assertNotNull("should get name of patron",ccic.checkCopyIn());
	}
	
	public boolean checkCopyOut() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		String cid = "C1T1R";
		ccoc.addCopy(cid);
		ccoc.setCurrentPatron("P1");
		ccoc.checkOutCopies();
		return true;
	}
	
}
