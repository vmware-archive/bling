package io.pivotal.bling.core;

import io.pivotal.bling.integration.RetailTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {LocationTests.class, RetailTest.class})
public class BlingCoreTests {

	@Test
	public void contextLoads() {
	}


}
