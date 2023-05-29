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
    Location newLocation =
        switch (command) {
          case F -> currentPosition.location().forward(currentPosition.direction());
          case B -> currentPosition.location().backward(currentPosition.direction());
        };
    currentPosition = new Position(newLocation, this.currentPosition.direction());
  }
}
