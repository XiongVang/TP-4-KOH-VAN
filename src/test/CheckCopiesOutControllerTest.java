package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contoller.CheckCopiesOutController;

public class CheckCopiesOutControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCopyOut() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		String cid = "C2T1R";
		ccoc.addCopy(cid);
		assertTrue("copy has already been added",ccoc.isDuplicateCopy(cid));
		ccoc.setCurrentPatron("P1");
		assertFalse("copy is not checked out",ccoc.copyIsOut(cid));
		assertNotNull("copies entered is not null",ccoc.getCopiesEnteredString());
	}

	@Test
	public void testIsValidPatronID() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		assertTrue("patron ID is valid",ccoc.isValidPatronID("P2"));
	}

	@Test
	public void testIsValidCopyID() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		String cid = "C2T1R";
		assertTrue("copy ID is valid",ccoc.isValidCopyID(cid));
	}

	@Test
	public void testCurrentPatronHasHold() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		ccoc.setCurrentPatron("P1");
		assertFalse("patron 1 has no hold",ccoc.currentPatronHasHold());
		ccoc.setCurrentPatron("P2");
		assertTrue("patron 2 has a hold",ccoc.currentPatronHasHold());
	}

	@Test
	public void testGetCurrentPatronName() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		ccoc.setCurrentPatron("P1");
		assertEquals("patron name matches",ccoc.getCurrentPatronName(),"Patron1");
	}

	@Test
	public void testNoCopiesEnteredYet() {
		CheckCopiesOutController ccoc = new CheckCopiesOutController();
		assertTrue("no copies entered yet",ccoc.noCopiesEnteredYet());
	}

}
