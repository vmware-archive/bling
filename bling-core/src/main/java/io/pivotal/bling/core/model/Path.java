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

  public Path(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
