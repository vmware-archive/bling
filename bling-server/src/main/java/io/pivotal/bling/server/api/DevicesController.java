package io.pivotal.bling.server.api;

import io.pivotal.bling.core.BlingUtils;
import io.pivotal.bling.core.model.Device;
import io.pivotal.bling.core.repositories.DeviceRepository;
import io.pivotal.bling.server.api.msg.DeviceCreateUpdateRequest;
import io.pivotal.bling.server.api.msg.GenericCreateUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sgupta
 * @since 2/9/15.
 */
@Controller
@RequestMapping(value = "/api/device/**", produces = "application/json")
public class DevicesController {


  @Autowired
  DeviceRepository deviceRepository;

  @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<GenericCreateUpdateResponse> createUpdateDevice(DeviceCreateUpdateRequest request) {
    Device device = request.getDevice();
    if(device.getId() == null) {
      device = new Device(BlingUtils.createTimeBasedUid(), device.getDeviceType(), device.getMetadata());
    }

    deviceRepository.save(device);
    return new ResponseEntity<>(new GenericCreateUpdateResponse("Device", device.getId()), HttpStatus.OK);
  }



}
