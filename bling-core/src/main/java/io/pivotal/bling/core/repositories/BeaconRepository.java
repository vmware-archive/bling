package io.pivotal.bling.core.repositories;

import io.pivotal.bling.core.model.Beacon;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.gemfire.repository.GemfireRepository;

/**
 * @author sgupta
 * @since 2/9/15.
 */
//@Repository
@Region("Beacon")
public interface BeaconRepository extends GemfireRepository<Beacon, String> {
}
