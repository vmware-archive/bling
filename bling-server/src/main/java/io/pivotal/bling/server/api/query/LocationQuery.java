package io.pivotal.bling.server.api.query;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.query.*;
import io.pivotal.bling.core.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sgupta
 * @since 2/17/15.
 */
@Component
public class LocationQuery {
  @Autowired
  ClientCache clientCache;

  public List<Location> findLocationsInBuckets(List<Long> buckets) throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {
    StringBuilder queryStringBuilder = new StringBuilder("SELECT t FROM /Location t WHERE t.bucket IN ");
    boolean isFirst = true;
    for (Long bucket : buckets) {
      if(!isFirst) {
        queryStringBuilder.append(' ');
      }
      queryStringBuilder.append("\"").append(bucket).append("");
      if(isFirst) {
        isFirst = false;
      }
    }
//    queryStringBuilder.append("'");
    Query query = clientCache.getQueryService().newQuery(queryStringBuilder.toString());
    SelectResults<?> locations = (SelectResults<?>) query.execute();
    List<Location> locationList =
        locations.stream().map(location -> (Location) location).collect(Collectors.toCollection(() -> new LinkedList<>()));
    return null;
  }
}
