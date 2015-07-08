package io.pivotal.bling.server.api;

import io.pivotal.bling.core.BlingUtils;
import io.pivotal.bling.core.Radius;
import io.pivotal.bling.core.model.Facility;
import io.pivotal.bling.core.model.Location;
import io.pivotal.bling.core.repositories.DeviceRepository;
import io.pivotal.bling.core.repositories.FacilityRepository;
import io.pivotal.bling.core.repositories.LocationRepository;
import io.pivotal.bling.server.api.msg.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sgupta
 * @since 2/9/15.
 */
@Controller
@RequestMapping(value = "/api/geo/**", produces = "application/json")
public class GeoController {

  @Autowired
  DeviceRepository deviceRepository;

  @Autowired
  LocationRepository locationRepository;

  @Autowired
  FacilityRepository facilityRepository;

  @RequestMapping(value = "loc", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<GenericResponse> updateLocation(GeoUpdateLocationRequest request) {
    if(request.getDeviceId() == null) {
      return new ResponseEntity<>(new GenericResponse(Status.error,
                                                      ErrorCode.deviceIdRequired,
                                                      "device id cannot be null"),
                                  HttpStatus.BAD_REQUEST);
    }
    if(!deviceRepository.exists(request.getDeviceId())) {
      return new ResponseEntity<>(new GenericResponse(Status.error,
                                                      ErrorCode.deviceIdNotFound,
                                                      "device id not found"),
                                  HttpStatus.NOT_FOUND);
    }
    Location location = new Location("Device/" + request.getDeviceId(),
                                     request.getDeviceId(),
                                     "Device",
                                     request.getLat(),
                                     request.getLon(),
                                     request.getAlt(),
                                     request.getTimestamp() == null ? System.currentTimeMillis() : request.getTimestamp());
    locationRepository.save(location);
    return new ResponseEntity<>(new GenericResponse(), HttpStatus.OK);
  }


  /**
   * given a [lat, lon] by a device, find the things nearby
   * @param lat
   * @param lon
   * @param radius
   */
  @RequestMapping(value = "near", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<GeoNearResponse> findNearby(@RequestParam(value = "deviceId", required = true) String deviceId,
                                                    @RequestParam(value = "lat", required = true) Double lat,
                                                    @RequestParam(value = "lon", required = true) Double lon,
                                                    @RequestParam(value = "radius", required = false, defaultValue = "MEDIUM") Radius radius,
                                                    @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit) {
    if(!deviceRepository.exists(deviceId)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Long[] buckets = BlingUtils.getSurroundingBuckets(lat, lon, radius);
    List<Facility> facilities = new LinkedList<>();
    for (Long bucket : buckets) {
      List<Location> locations = locationRepository.findByBucketAndKind(bucket, "Facility");
      for (Location location : locations) {
        Facility facility = facilityRepository.findOne(location.getParentId());
        if(facility != null) {
          facility.setLocation(location);
          facilities.add(facility);
        }
      }
    }
//    List<Location> locations = locationRepository.findByBuckets(Arrays.asList(buckets)/*, "Facility"*/);
    return new ResponseEntity<>(new GeoNearResponse(facilities), HttpStatus.OK);
  }

  public void proximityDetected() {

  }



}
