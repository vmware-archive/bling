package io.pivotal.bling.core.repositories;

import io.pivotal.bling.core.model.Facility;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.gemfire.repository.GemfireRepository;

/**
 * @author sgupta
 * @since 2/9/15.
 */
//@Repository
@Region("Facility")
public interface FacilityRepository extends GemfireRepository<Facility, String> {
}
