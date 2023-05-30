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
    if (x > EAST_EDGE) {
      return wrapOnEastEdge(x);
    } else if (x < WEST_EDGE) {
      return wrapOnWestEdge(x);
    }
    return x;
  }

  private static int wrapOnNorthEdge(int y) {
    return wrapOnHigherLimit(y, SOUTH_EDGE, NORTH_EDGE);
  }

  private static int wrapOnSouthEdge(int y) {
    return wrapOnLowerLimit(y, SOUTH_EDGE, NORTH_EDGE);
  }

  private static int wrapOnEastEdge(int x) {
    return wrapOnHigherLimit(x, WEST_EDGE, EAST_EDGE);
  }

  private static int wrapOnWestEdge(int x) {
    return wrapOnLowerLimit(x, WEST_EDGE, EAST_EDGE);
  }

  private static int wrapOnHigherLimit(int coordinate, int lowerLimit, int higherLimit) {
    int range = higherLimit - lowerLimit + 1;
    while (coordinate > higherLimit) {
      coordinate = coordinate - range;
    }
    return coordinate;
  }

  private static int wrapOnLowerLimit(int coordinate, int lowerLimit, int higherLimit) {
    int range = higherLimit - lowerLimit + 1;
    while (coordinate < lowerLimit) {
      coordinate = coordinate + range;
    }
    return coordinate;
  }
}
