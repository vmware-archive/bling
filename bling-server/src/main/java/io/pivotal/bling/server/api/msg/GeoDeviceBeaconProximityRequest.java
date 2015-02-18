package io.pivotal.bling.server.api.msg;

/**
 * @author sgupta
 * @since 2/9/15.
 */
public final class GeoDeviceBeaconProximityRequest {

  private final String deviceId;
  private final BeaconPoint[] beaconPoints;
  private final Long timestamp;

  public GeoDeviceBeaconProximityRequest(String deviceId, BeaconPoint[] beaconPoints, Long timestamp) {
    this.deviceId = deviceId;
    this.beaconPoints = beaconPoints;
    this.timestamp = timestamp;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public BeaconPoint[] getBeaconPoints() {
    return beaconPoints;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public static final class BeaconPoint {
    private final String uuid;
    private final Integer major;
    private final Integer minor;
    private final String direction;
    private final Double lat;
    private final Double lon;
    private final Double proximity;

    public BeaconPoint(String uuid, Integer major, Integer minor, String direction, Double lat, Double lon, Double proximity) {
      this.uuid = uuid;
      this.major = major;
      this.minor = minor;
      this.direction = direction;
      this.lat = lat;
      this.lon = lon;
      this.proximity = proximity;
    }

    public String getUuid() {
      return uuid;
    }

    public Integer getMajor() {
      return major;
    }

    public Integer getMinor() {
      return minor;
    }

    public String getDirection() {
      return direction;
    }

    public Double getLat() {
      return lat;
    }

    public Double getLon() {
      return lon;
    }

    public Double getProximity() {
      return proximity;
    }
  }


}
