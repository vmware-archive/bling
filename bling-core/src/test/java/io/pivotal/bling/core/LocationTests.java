package io.pivotal.bling.core;

import io.pivotal.bling.ReferenceLocations;
import io.pivotal.bling.core.model.Location;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sgupta
 * @since 2/5/15.
 */
public class LocationTests {


  @Test
  public void testBucketCreation() {
    for (Location location : ReferenceLocations.locations) {
      System.out.println("location.getBucket() = " + location.getBucket());
    }
  }

  @Test
  public void testBucketRangeCreation() {
    for (Location location : ReferenceLocations.locations) {
      Long[] surrounding = BlingUtils.getSurroundingBuckets(location.getBucket(), Radius.SMALL);
      System.out.println("surrounding = " + Arrays.toString(surrounding));
    }
  }
}
