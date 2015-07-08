package io.pivotal.bling.core.repositories;

import io.pivotal.bling.core.model.App;
import org.springframework.data.gemfire.repository.GemfireRepository;

/**
 * @author sgupta
 * @since 2/20/15.
 */
public interface AppRepository extends GemfireRepository<App, String> {

  public App findByUuid(String uuid);
}
