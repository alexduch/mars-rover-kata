package io.github.alexduch.marsroverkata;

import static io.github.alexduch.marsroverkata.Direction.W;

record Position(Location location, Direction direction) {

  Position forward() {
    return new Position(location.forward(direction), direction);
  }

  Position backward() {
    return new Position(location.backward(direction), direction);
  }

  Position left() {
    return new Position(location, W);
  }
}
