package io.pivotal.bling.server.api.msg;

import io.pivotal.bling.core.model.App;

/**
 * @author sgupta
 * @since 2/20/15.
 */
public class AppCreateUpdateRequest {
  private final App app;

  public AppCreateUpdateRequest(App app) {
    this.app = app;
  }

  public App getApp() {
    return app;
  }
}
