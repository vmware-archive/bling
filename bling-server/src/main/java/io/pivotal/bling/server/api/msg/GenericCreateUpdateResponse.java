package io.pivotal.bling.server.api.msg;

/**
 * @author sgupta
 * @since 2/15/15.
 */
public class GenericCreateUpdateResponse {
  private final String type;
  private final String id;

  public GenericCreateUpdateResponse(String type, String id) {
    this.type = type;
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public String getId() {
    return id;
  }
}
