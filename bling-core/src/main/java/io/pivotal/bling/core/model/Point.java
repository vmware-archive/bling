package io.pivotal.bling.core.model;

import java.io.Serializable;

/**
 * Immutable representation of a lat/lon pair
 * Since the trailing digits of a lat/lon pair can change frequently for the same
 * location, this object doesn't have a custom equals/hashcode override; it is
 * not advisable to use this object as a key for a lookup or anything else
 * that requires uniqueness criteria.
 * @author sgupta
 * @since 4/20/15.
 */
public class Point implements Serializable {

  private static final long serialVersionUID = 876350227507296261L;

  private final Double latitude;
  private final Double longitude;

  public Point(Double latitude, Double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }
}
