package io.github.alexduch.marsroverkata;

class MarsRover {

  private final Position currentPosition;

   MarsRover(Position initialPosition) {
    this.currentPosition = initialPosition;
  }

   Position go(Command[] commands) {
    if (commands == null || commands.length == 0) {
      return currentPosition;
    }
    return new Position(new Location(currentPosition.location().x(), currentPosition.location().y() + 1), currentPosition.direction());
  }
}
