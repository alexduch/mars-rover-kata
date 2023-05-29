package io.github.alexduch.marsroverkata;

class MarsRover {

    private final Position currentPosition;

    MarsRover(Position initialPosition) {
    this.currentPosition = initialPosition;
  }

    Position go(Command[] commands) {
        return currentPosition;
    }
}
