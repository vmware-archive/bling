package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Path")
public class Path implements Serializable {
  private static final long serialVersionUID = 7630948471142396305L;

  @Id
  private final String id;

  private final Point[] points;

  /**
   * width of the path, in meters
   */
  private final Long width;

  public Path(String id, Point[] points, Long width) {
    this.id = id;
    this.points = points;
    this.width = width;
  }

  public String getId() {
    return id;
  }

  public Point[] getPoints() {
    return points;
  }

  public Long getWidth() {
    return width;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Path path = (Path) o;

    if (!id.equals(path.id)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
