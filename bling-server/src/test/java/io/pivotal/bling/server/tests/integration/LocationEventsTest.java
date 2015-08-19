package io.pivotal.bling.server.tests.integration;

import com.gemstone.gemfire.cache.query.FunctionDomainException;
import com.gemstone.gemfire.cache.query.NameResolutionException;
import com.gemstone.gemfire.cache.query.QueryInvocationTargetException;
import com.gemstone.gemfire.cache.query.TypeMismatchException;
import io.pivotal.bling.core.BlingUtils;
import io.pivotal.bling.core.Radius;
import io.pivotal.bling.core.model.Device;
import io.pivotal.bling.core.model.Facility;
import io.pivotal.bling.core.model.Location;
import io.pivotal.bling.core.repositories.LocationRepository;
import io.pivotal.bling.server.api.DevicesController;
import io.pivotal.bling.server.api.FacilityController;
import io.pivotal.bling.server.api.GeoController;
import io.pivotal.bling.server.api.msg.DeviceCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.FacilityCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.GeoNearResponse;
import io.pivotal.bling.server.tests.TestLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
  LocationRepository locationRepository;

  public void runTests() throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {
    createFacilities();
    testNearbyLocationsHalfBlock();
    testNearbyLocationsFullBlockLarge();
  }

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
    devicesController.createUpdateDevice(new DeviceCreateUpdateRequest(new Device(TestLocations.TEST_UUID, "foo", "ios", TestLocations.TEST_UUID, 123L, 123L, new HashMap<String, String>())));
  }

  public void testNearbyLocationsHalfBlock() throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {

    List<Long> bucketIds = Arrays.asList(BlingUtils.getSurroundingBuckets(TestLocations.TimesSquare_halfBlock.getLatitude(),
                                                                          TestLocations.TimesSquare_halfBlock.getLongitude(),
                                                                          Radius.SMALL));
    System.out.println("bucketIds = " + bucketIds);
    List<Location> locations = locationRepository.findByBucketIn(bucketIds);
    printFacilities("0. location query test:::: ", locations);

    ResponseEntity<GeoNearResponse> response =
        geoController.findNearby(TestLocations.TEST_UUID,
                                 TestLocations.TimesSquare_halfBlock.getLatitude(),
                                 TestLocations.TimesSquare_halfBlock.getLongitude(),
                                 Radius.SMALL,
                                 100);
    printFacilities("1. TimesSquare_halfBlock", response.getBody().getFacilities());
  }

  public void testNearbyLocationsFullBlockLarge() {
    ResponseEntity<GeoNearResponse> response =
        geoController.findNearby(TestLocations.TEST_UUID,
                                 TestLocations.TimesSquare_OneBlock.getLatitude(),
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
