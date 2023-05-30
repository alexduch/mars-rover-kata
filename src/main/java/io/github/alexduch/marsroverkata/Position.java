package io.github.alexduch.marsroverkata;

record Position(Location location, Direction direction) {

  Position forward() {
    return new Position(location.forward(direction), direction);
  }

  Position backward() {
    return new Position(location.backward(direction), direction);
  }
}
