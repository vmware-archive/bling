package io.pivotal.bling.server.tests.controller;

import io.pivotal.bling.core.model.Beacon;
import io.pivotal.bling.core.model.Location;
import io.pivotal.bling.core.repositories.BeaconRepository;
import io.pivotal.bling.server.api.BeaconController;
import io.pivotal.bling.server.api.msg.BeaconCreateUpdateRequest;
import io.pivotal.bling.server.tests.TestLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author sgupta
 * @since 2/20/15.
 */
@Component
public class BeaconControllerTest {

  @Autowired
  BeaconRepository beaconRepository;

  @Autowired
  BeaconController beaconController;

  public void testCreateBeacon() {
    for (int i = 0; i < TestLocations.BEACON_LOCATIONS.length; i++) {
      Location location = TestLocations.BEACON_LOCATIONS[i];
      Beacon beacon = new Beacon(null,
                                 location,
                                 TestLocations.TEST_UUID, 1000L, 101L + i,
                                 new HashMap<>());
      beaconController.createUpdateBeacon(new BeaconCreateUpdateRequest(beacon));
    }

    List<Beacon> beacons = beaconRepository.findByUuid(TestLocations.TEST_UUID);
    assert beacons.size() == TestLocations.BEACON_LOCATIONS.length;

    List<Beacon> beaconsUuidMajor = beaconRepository.findByUuidAndMajor(TestLocations.TEST_UUID, 1000L);
    assert beaconsUuidMajor.size() == TestLocations.BEACON_LOCATIONS.length;

    Beacon beaconUMM = beaconRepository.findOneByUuidAndMajorAndMinor(TestLocations.TEST_UUID, 1000L, 102L);
    assert beaconUMM != null;


  }


}
