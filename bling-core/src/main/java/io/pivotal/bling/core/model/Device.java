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
  private final String deviceType;
  private final Map<String,String> metadata;
  private Long lastUpdateTimestamp;

  @Transient
  private Location location;

  public Device(String id, String deviceType, Map<String, String> metadata) {
    this.id = id;
    this.deviceType = deviceType;
    this.metadata = metadata;
    this.lastUpdateTimestamp = System.currentTimeMillis();
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getId() {
    return id;
  }

  public String getDeviceType() {
    return deviceType;
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

    if (!id.equals(device.id)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
