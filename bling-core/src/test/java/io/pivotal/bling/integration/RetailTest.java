package io.pivotal.bling.integration;

import io.pivotal.bling.ReferenceLocations;
import io.pivotal.bling.core.BlingUtils;
import io.pivotal.bling.core.model.App;
import io.pivotal.bling.core.model.Beacon;
import io.pivotal.bling.core.model.Facility;
import io.pivotal.bling.core.repositories.AppRepository;
import io.pivotal.bling.core.repositories.BeaconRepository;
import io.pivotal.bling.core.repositories.FacilityRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sgupta
 * @since 5/10/15.
 */
public class RetailTest {
  private static final String facilityId = "MacysHQ";

  @Autowired
  AppRepository appRepository;

  @Autowired
  FacilityRepository facilityRepository;

  @Autowired
  BeaconRepository beaconRepository;

  @Before
  public void setupRetailTest() {
    App app = new App("MacysApp", "Macy's App", "Macy's App", BlingUtils.createUUID());
    appRepository.save(app);

    Facility facility = new Facility(facilityId,
                                     "Macy's HQ",
                                     false,
                                     ReferenceLocations.MacysNYC, null);
    facilityRepository.save(facility);

    Beacon mensDepartment = new Beacon(facility.getId(),
                                       ReferenceLocations.MacysNYC,
                                       app.getUuid(),
                                       1L, 1L, null);
    Beacon toysDepartment = new Beacon(facility.getId(),
                                       ReferenceLocations.MacysNYC,
                                       app.getUuid(),
                                       1L, 2L, null);
    beaconRepository.save(mensDepartment);
    beaconRepository.save(toysDepartment);

  }

  @Test
  public void testProxitmityToLocation() {

  }


  @After
  public void tearDownRetailTest() {
    facilityRepository.delete(facilityId);
    appRepository.deleteAll();
    beaconRepository.deleteAll();
  }
}
