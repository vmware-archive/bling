package io.pivotal.bling.server.api;

import io.pivotal.bling.core.BlingUtils;
import io.pivotal.bling.core.model.Facility;
import io.pivotal.bling.core.model.Location;
import io.pivotal.bling.core.repositories.FacilityRepository;
import io.pivotal.bling.core.repositories.LocationRepository;
import io.pivotal.bling.server.api.msg.FacilityCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.GenericCreateUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sgupta
 * @since 2/15/15.
 */
@Controller
@RequestMapping(value = "/api/facility/**", produces = "application/json")
public class FacilityController {

  @Autowired
  FacilityRepository facilityRepository;

  @Autowired
  LocationRepository locationRepository;

  @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<GenericCreateUpdateResponse> facilityCreateUpdate(FacilityCreateUpdateRequest request) {
    Facility facility = request.getFacility();
    if(facility.getId() == null) {
      facility = new Facility(BlingUtils.createTimeBasedUid(),
                              facility.getName(),
                              facility.isMobile(),
                              facility.getLocation(),
                              facility.getMetadata());
    }
    facilityRepository.save(facility);
    Location facilityLocation = Location.createLocation("Facility/"+facility.getId(),
                                                        facility.getId(),
                                                        "Facility",
                                                        facility.getLocation());
    locationRepository.save(facilityLocation);
    return new ResponseEntity<>(new GenericCreateUpdateResponse("Facility", facility.getId()),
                                HttpStatus.OK);
  }

  @RequestMapping(value = "/facilities", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<List<Facility>> facilities(@RequestParam(value = "offset", required = false, defaultValue = "0")Integer offset,
                                                   @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit) {
    Iterable<Facility> facilities = facilityRepository.findAll();
    Iterator<Facility> facilityIterator = facilities.iterator();
    if(offset > 0) {
      int index = 0;
      while (facilityIterator.hasNext() && index < offset) {
        index++;
        facilityIterator.next();
      }
    }
    List<Facility> response = new LinkedList<>();
    if(limit > 1000) {
      limit = 1000;
    }
    int count = 0;
    while (facilityIterator.hasNext() && count < limit) {
      count++;
      response.add(facilityIterator.next());
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
