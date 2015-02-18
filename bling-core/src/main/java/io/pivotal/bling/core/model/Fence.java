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

  public Fence(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
