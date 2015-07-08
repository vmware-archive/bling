package io.pivotal.bling.server.tests;

import io.pivotal.bling.core.model.Location;

/**
 * @author sgupta
 * @since 2/15/15.
 */
public class TestLocations {
  public static final Location ColumbusCircle = new Location(null, null, null, 40.768109, -73.981880, null, System.currentTimeMillis());
  public static final Location TimesSquare = new Location(null, null, null, 40.758894, -73.985130, null, System.currentTimeMillis());
  public static final Location MacysNYC = new Location(null, null, null, 40.750711, -73.988586, null, System.currentTimeMillis());
  public static final Location NYPublicLibrary = new Location(null, null, null, 40.753179, -73.982263, null, System.currentTimeMillis());
  public static final Location BryantPark = new Location(null, null, null, 40.753983, -73.984124, null, System.currentTimeMillis());
  public static final Location ColumbiaUniversityLowLib = new Location(null, null, null, 40.808053, -73.962020, null, System.currentTimeMillis());
  public static final Location ColumbiaUniversityButlerLib = new Location(null, null, null, 40.806453, -73.963211, null, System.currentTimeMillis());
  public static final Location ColumbiaUniversityEnggSchool = new Location(null, null, null, 40.809425, -73.960287, null, System.currentTimeMillis());

  public static final Location[] locations = new Location[]{
      ColumbusCircle,
      TimesSquare,
      MacysNYC,
      NYPublicLibrary,
      BryantPark,
  };

  public static final Location TimesSquare_halfBlock = new Location(null, null, null, 40.758597, -73.985076, null, System.currentTimeMillis());
  public static final Location TimesSquare_OneBlock = new Location(null, null, null, 40.759792, -73.984229, null, System.currentTimeMillis());
  public static final Location TimesSquare_OneLongBlock = new Location(null, null, null, 40.757419, -73.982276, null, System.currentTimeMillis());

  public static final Location TimesSquare_5Block = new Location(null, null, null, 40.762579, -73.982909, null, System.currentTimeMillis());
  public static final Location TimesSquare_4LongBlock = new Location(null, null, null, 40.763376, -73.996460, null, System.currentTimeMillis());
  public static final Location TimesSquare_15Block = new Location(null, null, null, 40.748491, -73.992479, null, System.currentTimeMillis());
  public static final Location TimesSquare_20Block = new Location(null, null, null, 40.747759, -74.004195, null, System.currentTimeMillis());
  public static final Location TimesSquare_25Block = new Location(null, null, null, 40.733306, -73.987179, null, System.currentTimeMillis());
  public static final Location TimesSquare_40Block = new Location(null, null, null, 40.788306, -73.976407, null, System.currentTimeMillis());

  public static final Location MacysNYC_MensDept = new Location(null, null, null, 40.750712, -73.988587, null, System.currentTimeMillis());
  public static final Location MacysNYC_KidsDept = new Location(null, null, null, 40.750709, -73.988581, null, System.currentTimeMillis());
  public static final Location MacysNYC_WomensDept = new Location(null, null, null, 40.750715, -73.988589, null, System.currentTimeMillis());
  public static final Location MacysNYC_HouseDept = new Location(null, null, null, 40.750716, -73.988578, null, System.currentTimeMillis());

  public static final Location[] BEACON_LOCATIONS = new Location[]{
      MacysNYC_HouseDept,
      MacysNYC_KidsDept,
      MacysNYC_MensDept,
      MacysNYC_WomensDept,
  };

  public static final String TEST_UUID = "99707B13-94FF-480F-8A22-48BD67018F5E";
}
