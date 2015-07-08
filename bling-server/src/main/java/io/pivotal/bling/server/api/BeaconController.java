package io.pivotal.bling.server.api;

import io.pivotal.bling.core.model.Beacon;
import io.pivotal.bling.core.model.Location;
import io.pivotal.bling.core.repositories.BeaconRepository;
import io.pivotal.bling.core.repositories.LocationRepository;
import io.pivotal.bling.server.api.msg.BeaconCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.GenericCreateUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sgupta
 * @since 2/15/15.
 */
@Controller
@RequestMapping(value = "/api/beacon/**", produces = "application/json")
public class BeaconController {

  @Autowired
  BeaconRepository beaconRepository;

  @Autowired
  LocationRepository locationRepository;

  @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<GenericCreateUpdateResponse> createUpdateBeacon(BeaconCreateUpdateRequest request) {
    Beacon beacon = request.getBeacon();
    if(beacon.getId() == null) {
      beacon = new Beacon(beacon.getParentId(),
                          beacon.getLocation(),
                          beacon.getUuid(), beacon.getMajor(),
                          beacon.getMinor(),
                          beacon.getMetadata());
    }
    beaconRepository.save(beacon);
    locationRepository.save(Location.createLocation("Beacon/"+beacon.getId(),
                                                    beacon.getId(),
                                                    "Beacon",
                                                    beacon.getLocation()));
    return new ResponseEntity<>(new GenericCreateUpdateResponse("Beacon",
                                                                beacon.getId()),
                                HttpStatus.OK);
  }

  @RequestMapping(value = "/{uuid}/{major}/{minor}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Beacon> getBeacon(@PathVariable("uuid")String uuid,
                                          @PathVariable("major")Long major,
                                          @PathVariable("minor")Long minor) {
    Beacon beacon = beaconRepository.findOneByUuidAndMajorAndMinor(uuid, major, minor);
    if(beacon == null) {
      return new ResponseEntity<Beacon>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Beacon>(beacon, HttpStatus.OK);
  }
}
