package io.pivotal.bling.core;

/**
* @author sgupta
* @since 2/16/15.
*/
public enum Radius {
  NANO(0),
  MICRO(1),
  SMALL(3),
  MEDIUM(7),
  LARGE(15),
  ;
  private final int range;

  Radius(int range) {
    this.range = range;
  }

  public int getRange() {
    return range;
  }
}
