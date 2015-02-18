package io.pivotal.bling.core.repositories;

import io.pivotal.bling.core.model.Location;
import org.springframework.data.gemfire.repository.GemfireRepository;

import java.util.List;

/**
 * @author sgupta
 * @since 2/16/15.
 */
public interface LocationRepository extends GemfireRepository<Location, String> {


  public List<Location> findByBucket(Long bucket);

  public List<Location> findByBucketAndKind(Long bucket, String kind);

}
