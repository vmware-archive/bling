package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Fence")
public class Fence implements Serializable {
  private static final long serialVersionUID = 1107187059057279638L;

  @Id
  private final String id;
  private final Location location;
  private final Long lastUpdateTimestamp;
  /**
   * radius of the fence in
   */
  private final Double radius;

  public Fence(String id, Location location, Long lastUpdateTimestamp, Double radius) {
    this.id = id;
    this.location = location;
    this.lastUpdateTimestamp = lastUpdateTimestamp;
    this.radius = radius;
  }

  public String getId() {
    return id;
  }

  public Location getLocation() {
    return location;
  }

  public Long getLastUpdateTimestamp() {
    return lastUpdateTimestamp;
  }

  public Double getRadius() {
    return radius;
  }

  public boolean locationIsInFence(Point point) {
    return false;
  }
}
