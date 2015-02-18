package io.pivotal.bling.server.tests.integration;

import io.pivotal.bling.core.Radius;
import io.pivotal.bling.core.model.Facility;
import io.pivotal.bling.server.api.DevicesController;
import io.pivotal.bling.server.api.FacilityController;
import io.pivotal.bling.server.api.GeoController;
import io.pivotal.bling.server.api.msg.FacilityCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.GeoNearResponse;
import io.pivotal.bling.server.api.query.LocationQuery;
import io.pivotal.bling.server.tests.TestLocations;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author sgupta
 * @since 2/15/15.
 */
@Component
public class LocationEventsTest {

  @Autowired
  DevicesController devicesController;

  @Autowired
  FacilityController facilityController;

  @Autowired
  GeoController geoController;

  @Autowired
  LocationQuery locationQuery;

  public void runTests() {
    createFacilities();
      testNearbyLocationsHalfBlock();
    testNearbyLocationsFullBlockLarge();
  }

  @Before
  void createFacilities() {
    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("BryantPark",
                                                                           "Bryant Park",
                                                                           false,
                                                                           TestLocations.BryantPark,
                                                                           new HashMap<String, String>())));
    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("ColumbusCircle",
                                                                           "Columbus Circle",
                                                                           false,
                                                                           TestLocations.ColumbusCircle,
                                                                           new HashMap<String, String>())));
    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("MacysNYC",
                                                                           "Macys NYC",
                                                                           false,
                                                                           TestLocations.MacysNYC,
                                                                           new HashMap<String, String>())));
    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("NYPublicLibrary",
                                                                           "NY Public Library",
                                                                           false,
                                                                           TestLocations.NYPublicLibrary,
                                                                           new HashMap<String, String>())));
    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("TimesSquare",
                                                                           "Times Square",
                                                                           false,
                                                                           TestLocations.TimesSquare,
                                                                           new HashMap<String, String>())));

    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("ColumbiaUniversityButlerLib",
                                                                           "Columbia University Butler Library",
                                                                           false,
                                                                           TestLocations.ColumbiaUniversityButlerLib,
                                                                           new HashMap<String, String>())));

    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("ColumbiaUniversityLowLib",
                                                                           "Columbia University Low Library",
                                                                           false,
                                                                           TestLocations.ColumbiaUniversityLowLib,
                                                                           new HashMap<String, String>())));

    facilityController
        .facilityCreateUpdate(new FacilityCreateUpdateRequest(new Facility("ColumbiaUniversityEnggSchool",
                                                                           "Columbia University Engineering School",
                                                                           false,
                                                                           TestLocations.ColumbiaUniversityEnggSchool,
                                                                           new HashMap<String, String>())));


    ResponseEntity<List<Facility>> facilitiesResponse = facilityController.facilities(0, 100);
    List<Facility> facilities = facilitiesResponse.getBody();
    for (Facility facility : facilities) {
      System.out.println("facility = " + facility);
    }

  }

  @Test
  public void testNearbyLocationsHalfBlock() {
/*
    List<Location> locations = locationQuery.findLocationsInBuckets(Arrays.asList(BlingUtils.getSurroundingBuckets(TestLocations.TimesSquare_halfBlock.getLatitude(),
                                                                                                     TestLocations.TimesSquare_halfBlock.getLongitude(),
                                                                                                     Radius.MEDIUM)));
    printFacilities("0. location query test:::: ", locations);
*/

    ResponseEntity<GeoNearResponse> response =
        geoController.findNearby(TestLocations.TimesSquare_halfBlock.getLatitude(),
                                 TestLocations.TimesSquare_halfBlock.getLongitude(),
                                 Radius.SMALL,
                                 100);
    printFacilities("1. TimesSquare_halfBlock", response.getBody().getFacilities());
  }

  @Test
  public void testNearbyLocationsFullBlockLarge() {
    ResponseEntity<GeoNearResponse> response =
        geoController.findNearby(TestLocations.TimesSquare_OneBlock.getLatitude(),
                                 TestLocations.TimesSquare_OneBlock.getLongitude(),
                                 Radius.MEDIUM,
                                 100);
    printFacilities("2. TimesSquare_OneBlock", response.getBody().getFacilities());
  }

  private void printFacilities(String message, List<?> facilities) {
    System.out.println(message + "facilities.size() = " + facilities.size());
    for (Object facility : facilities) {
      System.out.println(message + "facility = " + facility);
    }
    System.out.println(">>>>>>>>>> --------------------------------");
  }

}
