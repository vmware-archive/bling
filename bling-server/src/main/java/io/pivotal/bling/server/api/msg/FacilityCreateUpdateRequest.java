package io.pivotal.bling.server.api.msg;

import io.pivotal.bling.core.model.Facility;

/**
 * @author sgupta
 * @since 2/15/15.
 */
public class FacilityCreateUpdateRequest {
  private final Facility facility;

  public FacilityCreateUpdateRequest(Facility facility) {
    this.facility = facility;
  }

  public Facility getFacility() {
    return facility;
  }
}
