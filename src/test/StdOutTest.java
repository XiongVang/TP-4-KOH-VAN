package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lib.StdOut;

public class StdOutTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrint() {
		try {
			StdOut.println("0");
			StdOut.print("0");
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintObject() {
		try {
			StdOut.println(new Object());
			StdOut.print(new Object());
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintBoolean() {
		try {
			StdOut.println(true);
			StdOut.print(true);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintChar() {
		try {
			StdOut.println('0');
			StdOut.print('0');
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintDouble() {
		try {
			StdOut.println((double)10.01);
			StdOut.print((double)10.01);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintFloat() {
		try {
			StdOut.println((float).001);
			StdOut.print((float).001);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintInt() {
		try {
			StdOut.println((int)1);
			StdOut.print((int)1);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintLong() {
		try {
			StdOut.println((long)1);
			StdOut.print((long)1);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintShort() {
		try {
			StdOut.println((short)1);
			StdOut.print((short)1);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

	@Test
	public void testPrintByte() {
		try {
			StdOut.println((byte)1);
			StdOut.print((byte)1);
		} catch (Exception e) {
			fail("should not have resulted in exception");
		}
	}

}
