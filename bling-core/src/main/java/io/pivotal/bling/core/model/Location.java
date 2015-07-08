package io.pivotal.bling.core.model;

import io.pivotal.bling.core.BlingUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Location")
public class Location implements Serializable {

  private static final long serialVersionUID = -4651577795724733692L;
  @Id
  private final String id;
  private final String parentId;
  private final String kind;
  private final Double latitude;
  private final Double longitude;
  private final Double altitude;
  private final Long bucket;
  private final Long timestamp;

  /**
   * @param id this is optional, used when a location item has to be stored as a top level item in a region
   * @param kind this is optional, used when a location item has to be stored as a top level item in a region
   * @param latitude required
   * @param longitude required
   * @param altitude the altitude in meters
   * @param timestamp the timestamp in millis
   */
  public Location(String id, String parentId, String kind, Double latitude, Double longitude, Double altitude, Long timestamp) {
    this.id = id;
    this.parentId = parentId;
    this.kind = kind;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.timestamp = timestamp == null ? System.currentTimeMillis() : timestamp;
    this.bucket = BlingUtils.calculateBucket(latitude, longitude);
  }

  public String getId() {
    return id;
  }

  public String getParentId() {
    return parentId;
  }

  public String getKind() {
    return kind;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Long getBucket() {
    return bucket;
  }

  public Double getAltitude() {
    return altitude;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public Point getPoint() {
    return new Point(latitude, longitude);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Location location = (Location) o;
    if(id != null) {
      return id.equals(location.getId());
    }

    return latitude.equals(location.latitude) && longitude.equals(location.longitude);
  }

  @Override
  public int hashCode() {
    if(id != null) {
      return id.hashCode();
    }
    int result = latitude.hashCode();
    result = 31 * result + longitude.hashCode();
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Location{");
    sb.append("id='").append(id).append('\'');
    sb.append(", kind='").append(kind).append('\'');
    sb.append(", latitude=").append(latitude);
    sb.append(", longitude=").append(longitude);
    sb.append(", altitude=").append(altitude);
    sb.append(", bucket=").append(bucket);
    sb.append(", timestamp=").append(timestamp);
    sb.append('}');
    return sb.toString();
  }

  public static Location createLocation(String id, String parentId, String type, Location location) {
    return new Location(id, parentId, type, location.latitude, location.longitude, location.altitude, location.timestamp);
  }

}
