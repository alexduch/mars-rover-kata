package io.github.alexduch.marsroverkata;

final class MarsMap {

  static final int NORTH_EDGE = 10;
  static final int SOUTH_EDGE = 0;

  private MarsMap() {}

  static int wrapOnNorthSouthAxis(int y) {
    int wrapped = y;
    while (wrapped > NORTH_EDGE) {
      wrapped = wrapped - (NORTH_EDGE - SOUTH_EDGE + 1);
    }
    return wrapped;
  }
}
