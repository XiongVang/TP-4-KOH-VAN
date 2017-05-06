package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contoller.MakeSaleController;

public class MakeSaleControllerTest {

	@Test
	public void testSaleController() {
		MakeSaleController msc = new MakeSaleController();
		String cid = "C2T1S";
		assertTrue("should be valid copy ID",msc.validCopyID(cid));
		msc.addSaleCopy(cid);
		assertTrue("sale should have copy " + cid,msc.saleHasCopy(cid));
		assertTrue("sale should have copies",msc.saleHasCopies());
		assertEquals("sale total should be 1.00",1.00,msc.getSaleTotal(),.001);
		msc.applyPayment(1.01);
		assertEquals(".01 change should be due",.01,msc.getChangeDue(),.001);
		assertTrue("sale should be paid",msc.saleIsPaid());
		assertNotNull("sale string should be returned",msc.getSaleString());
		msc.completeSale();
	}
}
