package io.github.alexduch.marsroverkata;

final class MarsMap {

  static final int NORTH_EDGE = 10;
  static final int EAST_EDGE = 10;
  static final int SOUTH_EDGE = 0;
  static final int WEST_EDGE = 0;

  private MarsMap() {}

  static int wrapOnNorthSouthAxis(int y) {
    if (y > NORTH_EDGE) {
      return wrapOnNorthEdge(y);
    } else if (y < SOUTH_EDGE) {
      return wrapOnSouthEdge(y);
    }
    return y;
  }

  static int wrapOnEastWestAxis(int x) {
    while (x > EAST_EDGE) {
      x = x - (EAST_EDGE - WEST_EDGE + 1);
    }
    while (x < WEST_EDGE) {
      x = x + (EAST_EDGE - WEST_EDGE + 1);
    }
    return x;
  }

  private static int wrapOnNorthEdge(int y) {
    while (y > NORTH_EDGE) {
      y = y - (NORTH_EDGE - SOUTH_EDGE + 1);
    }
    return y;
  }

  private static int wrapOnSouthEdge(int y) {
    while (y < SOUTH_EDGE) {
      y = y + (NORTH_EDGE - SOUTH_EDGE + 1);
    }
    return y;
  }
}
