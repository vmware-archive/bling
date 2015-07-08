package io.pivotal.bling.server;

import io.pivotal.bling.server.tests.controller.BeaconControllerTest;
import io.pivotal.bling.server.tests.controller.DevicesControllerTest;
import io.pivotal.bling.server.tests.integration.LocationEventsTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlingServerApplication.class)
@ContextConfiguration("classpath:bling-server-context.xml")
public class BlingServerApplicationTests {

  @Autowired
  DevicesControllerTest devicesControllerTest;

  @Autowired
  LocationEventsTest locationEventsTest;

  @Autowired
  BeaconControllerTest beaconControllerTest;

	@Test
	public void contextLoads() {
	}

  @Test
  public void runDeviceControllersTest() {
    System.out.println(">>>>>>>\n>>>>>> devicesControllerTest = " + devicesControllerTest);
    devicesControllerTest.runTests();
  }

  @Test
  public void runLocationsEventTest() {
    locationEventsTest.runTests();
  }

  @Test
  public void runBeaconsControllerTest() {
    beaconControllerTest.testCreateBeacon();
  }

}
