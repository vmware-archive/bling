package io.pivotal.bling.server.api.msg;

import io.pivotal.bling.core.model.Facility;

import java.util.List;

/**
 * @author sgupta
 * @since 2/16/15.
 */
public class GeoNearResponse extends GenericResponse {

  private final List<Facility> facilities;

  public GeoNearResponse(List<Facility> facilities) {
    this.facilities = facilities;
  }

  public List<Facility> getFacilities() {
    return facilities;
  }
}
