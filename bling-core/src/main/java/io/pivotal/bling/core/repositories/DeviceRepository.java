package io.pivotal.bling.core.repositories;

import io.pivotal.bling.core.model.Device;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.gemfire.repository.GemfireRepository;

/**
 * @author sgupta
 * @since 2/9/15.
 */
//@Repository
@Region("Device")
public interface DeviceRepository extends GemfireRepository<Device, String> {
}
