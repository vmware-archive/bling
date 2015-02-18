package io.pivotal.bling.server.api.msg;

import io.pivotal.bling.core.model.Device;

/**
 * @author sgupta
 * @since 2/9/15.
 */
public class DeviceCreateUpdateRequest {

  private final Device device;

  public DeviceCreateUpdateRequest(Device device) {
    this.device = device;
  }

  public Device getDevice() {
    return device;
  }
}
