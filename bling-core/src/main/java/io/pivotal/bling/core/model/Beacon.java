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

  private final String parentId;
  @Id
  private final String id;
  private final Location location;
  private final Long major;
  private final Long minor;
  private final Map<String,String> metadata;


  public Beacon(String parentId, String id, Location location, Long major, Long minor, Map<String, String> metadata) {
    this.parentId = parentId;
    this.id = id;
    this.location = location;
    this.major = major;
    this.minor = minor;
    this.metadata = metadata;
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
