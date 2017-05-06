package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ CopyTest.class, PatronTest.class, SaleTest.class, TextbookTest.class, 
				WorkerTest.class, StationTest.class, StoreTest.class, 
				ChangePatronHoldControllerTest.class, MakeSaleControllerTest.class,
				CheckCopiesOutControllerTest.class, CheckCopiesInControllerTest.class,
				StdOutTest.class })

public class AllTests {

}
