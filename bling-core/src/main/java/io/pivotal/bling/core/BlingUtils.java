package io.pivotal.bling.core;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author sgupta
 * @since 2/5/15.
 */
public final class BlingUtils {

  private static final Random RANDOM = new SecureRandom();
  private static final char[] ID_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
  private static final long OFFSET = 1000000L;
  private static final long SCALE = 1000L;
  private static final long LAT_MAX = 180L * SCALE;
  private static final long LON_MAX = 360L * SCALE;

  public static Long calculateBucket(Double lat, Double lon) {
    lat += 90.0D;
    lon += 180.0D;

    lat *= SCALE;
    lon *= SCALE;

    long latBucket = lat.longValue() * OFFSET;
    long lonBucket = lon.longValue();

    return latBucket + lonBucket;
  }

  public static Long[] getSurroundingBuckets(Double lat, Double lon, Radius radius) {
    return getSurroundingBuckets(calculateBucket(lat, lon), radius);
  }

  public static Long[] getSurroundingBuckets(Long bucket, Radius radius) {
    long latBucket = bucket / OFFSET;
    long lonBucket = bucket % OFFSET;

    ArrayList<Long> buckets = new ArrayList<Long>();

    switch (radius) {
      case NANO:
        buckets.add(bucket);
        break;

      default:{
        long startLat = latBucket - radius.getRange();
        if(startLat < 0) {
          startLat = 0;
        }
        if(latBucket + radius.getRange() > LAT_MAX) {
          startLat = LAT_MAX - (2*radius.getRange() + 1);
        }
        long startLon = lonBucket - radius.getRange();
        final int length = 2*radius.getRange() + 1;
        for (int latIdx = 0; latIdx < length; latIdx++) {
          long currLat = startLat + latIdx;
          for (int lonIdx = 0; lonIdx < length; lonIdx++) {
            long currLon = startLon + lonIdx;
            currLon = currLon < 0 ? (LON_MAX + currLon) : (currLon > LON_MAX ? LON_MAX - currLon : currLon);
            buckets.add((currLat * OFFSET) + currLon);
          }
        }
        break;
      }
    }

    return buckets.toArray(new Long[buckets.size()]);
  }

  public static String createTimeBasedUid() {
    char[] chars = new char[8];
    for (int i = 0; i < chars.length; i++) {
      chars[i] = ID_CHARS[RANDOM.nextInt(ID_CHARS.length)];
    }
    return Long.toString(System.currentTimeMillis(), 36) + new String(chars);
  }
}
