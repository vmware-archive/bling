package io.pivotal.bling;

import io.pivotal.bling.core.model.Location;

/**
 * @author sgupta
 * @since 5/10/15.
 */
public class ReferenceLocations {
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
}
