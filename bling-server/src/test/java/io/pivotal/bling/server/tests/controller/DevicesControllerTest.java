package io.pivotal.bling.server.tests.controller;

import io.pivotal.bling.core.model.Device;
import io.pivotal.bling.server.api.DevicesController;
import io.pivotal.bling.server.api.msg.DeviceCreateUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sgupta
 * @since 2/9/15.
 */
@Component
public class DevicesControllerTest {

  @Autowired
  DevicesController devicesController;

  public void runTests() {
    devicesController.createUpdateDevice(new DeviceCreateUpdateRequest(new Device("123", "ios", null)));
  }

}
