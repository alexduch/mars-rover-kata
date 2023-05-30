package io.github.alexduch.marsroverkata;

record Location(int x, int y) {

  Location(int x, int y) {
    this.x = MarsMap.wrapOnEastWestAxis(x);
    this.y = MarsMap.wrapOnNorthSouthAxis(y);
  }

  Location forward(Direction direction) {
    return switch (direction) {
      case N -> new Location(x, y + 1);
      case E -> new Location(x + 1, y);
      case S -> new Location(x, y - 1);
      case W -> new Location(x - 1, y);
    };
  }

  Location backward(Direction direction) {
    return forward(direction.opposite());
  }
}
