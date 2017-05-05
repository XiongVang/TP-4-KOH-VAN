package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contoller.ChangePatronHoldController;

public class ChangePatronHoldControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCurrentPatron() {
		ChangePatronHoldController cphc = new ChangePatronHoldController();
		assertTrue("patron name should be valid",cphc.isValidPatronID("P1"));
		cphc.setCurrentPatron("P1");
		assertEquals("patron name should match",cphc.getCurrentPatronName(),"Patron1");
	}

	@Test
	public void testCurrentPatronHasHold() {
		ChangePatronHoldController cphc = new ChangePatronHoldController();
		cphc.setCurrentPatron("P1");
		assertFalse("patron should not have hold",cphc.currentPatronHasHold());
		cphc.putHold();
		assertTrue("patron should have hold",cphc.currentPatronHasHold());
		cphc.removeHold();
		assertFalse("patron should not have hold",cphc.currentPatronHasHold());
	}

}
