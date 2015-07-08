package io.pivotal.bling.server.api.msg;

import io.pivotal.bling.core.model.Beacon;

/**
 * @author sgupta
 * @since 2/20/15.
 */
public class BeaconCreateUpdateRequest {
  private final Beacon beacon;


  public BeaconCreateUpdateRequest(Beacon beacon) {
    this.beacon = beacon;
  }

  public Beacon getBeacon() {
    return beacon;
  }
}
