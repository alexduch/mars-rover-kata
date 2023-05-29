package io.github.alexduch.marsroverkata;

import java.util.Arrays;

class MarsRover {

  private Position currentPosition;

   MarsRover(Position initialPosition) {
    this.currentPosition = initialPosition;
  }

   Position go(Command[] commands) {
    if (commands == null || commands.length == 0) {
      return currentPosition;
    }
    Arrays.stream(commands).forEach(this::move);
    return currentPosition;
  }

  private void move(Command command) {
    Location newLocation = switch(currentPosition.direction()) {
      case E -> new Location(this.currentPosition.location().x() + 1, this.currentPosition.location().y());
      default -> new Location(this.currentPosition.location().x(), this.currentPosition.location().y() + 1);
    };
    currentPosition = new Position(newLocation, this.currentPosition.direction());
  }
}
