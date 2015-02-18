package io.pivotal.bling.server.api.msg;

/**
 * @author sgupta
 * @since 2/9/15.
 */
public class GeoUpdateLocationRequest {

  private final String type;
  private final String deviceId;
  private final Long timestamp;
  private final Double lat;
  private final Double lon;
  private final Double alt;


  public GeoUpdateLocationRequest(String type, String deviceId, Long timestamp, Double lat, Double lon, Double alt) {
    this.type = type;
    this.deviceId = deviceId;
    this.timestamp = timestamp;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
  }

  public String getType() {
    return type;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public Double getLat() {
    return lat;
  }

  public Double getLon() {
    return lon;
  }

  public Double getAlt() {
    return alt;
  }
}
