package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CopyTest.class, PatronTest.class, SaleTest.class, TextbookTest.class, WorkerTest.class })
public class AllTests {

}
