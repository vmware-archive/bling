package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;

/**
 * @author sgupta
 * @since 2/5/15.
 */
@Region("Event")
public class Event implements Serializable {
  private static final long serialVersionUID = 2733758708876310722L;

  @Id
  private final String id;

  public Event(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
