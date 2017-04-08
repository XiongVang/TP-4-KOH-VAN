package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import domain.Copy;
import domain.Patron;
import domain.Textbook;

public class PatronTest {

	private Patron patron;
	
	@Before
	public void setUp() throws Exception {
		this.patron = new Patron("P1", "test name");
	}

	private Copy fakeCopy(int i) {
		Textbook tb = new Textbook("", "", "", 1.00);
		Copy c = new Copy("C"+i,tb);
		return c;
	}
	private Copy fakeCopy() {
		return fakeCopy(1);
	}
	@Test
	public void testPatron() {
		assertNotNull("patron should not be null",patron);
		assertNotNull("patron should not be null",new Patron("",""));
		assertNotNull("patron should not be null",new Patron("","",new Hold(false)));
	}

	@Test
	public void testGetPatronID() {
		assertSame("values should match",patron.getPatronID(),"P1");
	}

	@Test
	public void testGetName() {
		assertSame("values should match",patron.getName(),"test name");
	}

	@Test
	public void testSetName() {
		assertSame("values should match",patron.getName(),"test name");
		patron.setName("new name");
		assertSame("values should match",patron.getName(),"new name");
	}

	@Test
	public void testPutHasHold() {
		assertFalse("there should be no hold",patron.hasHold());
		patron.putHold();
		assertTrue("there should be a hold",patron.hasHold());
	}

	@Test
	public void testRemoveHasHold() {
		patron.putHold();
		assertTrue("there should be a hold",patron.hasHold());
		patron.removeHold();
		assertFalse("there should be no hold",patron.hasHold());
	}

	@Test
	public void testCheckOutHasCopyOut() {
		assertTrue("check out should succeed",patron.checkCopyOut(fakeCopy()));		
		assertTrue("has checked out copy",patron.hasCopyOut(fakeCopy().getCopyID()));		
	}

	@Test
	public void testCheckCopyOutInString() {
		assertTrue("check out should succeed",patron.checkCopyOut(fakeCopy()));		
		assertTrue("check in should succeed",patron.checkCopyIn(fakeCopy().getCopyID()));		
	}

	@Test
	public void testCheckCopyOutInCopy() {
		assertTrue("check out should succeed",patron.checkCopyOut(fakeCopy()));		
		assertTrue("check in should succeed",patron.checkCopyIn(fakeCopy()));		
	}

	@Test
	public void testGetCopiesOut() {
		patron.checkCopyOut(fakeCopy(5));
		assertNotNull("copy list should not be null" + patron.getCopiesOut().size(),patron.getCopiesOut().size());
	}

	@Test
	public void testToString() {
		assertNotNull("copy list should not be null",patron.toString());
	}

}
