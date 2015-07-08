package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;
import java.util.Map;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Device")
public class Device implements Serializable {
  private static final long serialVersionUID = -3887052369061704084L;

  @Id
  private final String id;
  private final String appId;
  private final String deviceType;
  private final String uuid;
  private final Long major;
  private final Long minor;
  private final Map<String,String> metadata;
  private Long lastUpdateTimestamp;

  @Transient
  private Location location;

  public Device(String id, String appId, String deviceType, String uuid, Long major, Long minor, Map<String, String> metadata) {
    this.id = id;
    this.appId = appId;
    this.deviceType = deviceType;
    this.uuid = uuid;
    this.major = major;
    this.minor = minor;
    this.metadata = metadata;
    this.lastUpdateTimestamp = System.currentTimeMillis();
  }


  public String getAppId() {
    return appId;
  }

  public String getId() {
    return id;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public String getUuid() {
    return uuid;
  }

  public Long getMajor() {
    return major;
  }

  public Long getMinor() {
    return minor;
  }

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public Long getLastUpdateTimestamp() {
    return lastUpdateTimestamp;
  }

  public void setLastUpdateTimestamp(Long lastUpdateTimestamp) {
    this.lastUpdateTimestamp = lastUpdateTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Device device = (Device) o;

    if (!appId.equals(device.appId)) {
      return false;
    }
    if (!id.equals(device.id)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + appId.hashCode();
    return result;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
