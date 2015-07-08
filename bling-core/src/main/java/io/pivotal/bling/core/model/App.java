package io.pivotal.bling.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import java.io.Serializable;

/**
 * This is the application entity that stores the root uuid that will
 * be available for all instances of this application.
 * Since bling is a multi-tenant system, each bling install can host
 * multiple apps
 * @author sgupta
 * @since 2/20/15.
 */
@Region("App")
public class App implements Serializable {
  private static final long serialVersionUID = -8150537977630889076L;
  @Id
  private final String id;
  private final String name;
  private final String description;
  private final String uuid;

  public App(String id, String name, String description, String uuid) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.uuid = uuid;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getUuid() {
    return uuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    App app = (App) o;

    return id.equals(app.id);

  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
