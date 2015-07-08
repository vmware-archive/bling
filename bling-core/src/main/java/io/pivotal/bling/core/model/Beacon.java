package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;
import java.util.Map;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Beacon")
public class Beacon implements Serializable {
  private static final long serialVersionUID = -4117844420009027804L;

  /**
   * the id of the facility that owns this beacon
   */
  private final String parentId;

  @Id
  private final String id;
  private final Location location;
  private final String uuid;
  private final Long major;
  private final Long minor;
  private final Map<String,String> metadata;


  public Beacon(String parentId, Location location, String uuid, Long major, Long minor, Map<String, String> metadata) {
    this.parentId = parentId;
    this.id = uuid+"/"+major+"/"+minor;
    this.location = location;
    this.uuid = uuid;
    this.major = major;
    this.minor = minor;
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Beacon beacon = (Beacon) o;

    if (!id.equals(beacon.id)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  public String getParentId() {
    return parentId;
  }

  public String getId() {
    return id;
  }

  public Location getLocation() {
    return location;
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

}
