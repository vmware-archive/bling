package io.pivotal.bling.core;

import io.pivotal.bling.core.model.Location;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sgupta
 * @since 2/5/15.
 */
public class LocationTests {

  public static final Location ColumbusCircle = new Location(null, null, null, 40.768109, -73.981880, null, System.currentTimeMillis());
  public static final Location TimesSquare = new Location(null, null, null, 40.758894, -73.985130, null, System.currentTimeMillis());
  public static final Location MacysNYC = new Location(null, null, null, 40.750711, -73.988586, null, System.currentTimeMillis());
  public static final Location NYPublicLibrary = new Location(null, null, null, 40.753179, -73.982263, null, System.currentTimeMillis());
  public static final Location BryantPark = new Location(null, null, null, 40.753983, -73.984124, null, System.currentTimeMillis());

  public static final Location[] locations = new Location[]{
      ColumbusCircle,
      TimesSquare,
      MacysNYC,
      NYPublicLibrary,
      BryantPark,
  };


  @Test
  public void testBucketCreation() {
    for (Location location : locations) {
      System.out.println("location.getBucket() = " + location.getBucket());
    }
  }

  @Test
  public void testBucketRangeCreation() {
    for (Location location : locations) {
      Long[] surrounding = BlingUtils.getSurroundingBuckets(location.getBucket(), Radius.SMALL);
      System.out.println("surrounding = " + Arrays.toString(surrounding));
    }
  }
}
