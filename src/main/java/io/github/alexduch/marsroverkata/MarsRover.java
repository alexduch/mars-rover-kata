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
    currentPosition =
        new Position(
            new Location(
                this.currentPosition.location().x(), this.currentPosition.location().y() + 1),
            this.currentPosition.direction());
  }
}
