package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;
import java.util.Map;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Facility")
public class Facility implements Serializable {
  private static final long serialVersionUID = 2063335865139280521L;

  @Id
  private final String id;

  private String name;

  private final boolean isMobile;

  private Location location;

  private Map<String,String> metadata;


  public Facility(String id, String name, boolean isMobile, Location location,Map<String,String> metadata) {
    this.id = id;
    this.name = name;
    this.isMobile = isMobile;
    this.location = location;
    this.metadata = metadata;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isMobile() {
    return isMobile;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Map<String, String> getMetadata() {
    return metadata;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Facility{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", isMobile=").append(isMobile);
    sb.append(", location=").append(location);
    sb.append('}');
    return sb.toString();
  }
}
