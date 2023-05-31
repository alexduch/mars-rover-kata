package io.github.alexduch.marsroverkata;

import static java.lang.System.Logger.Level.ERROR;

import java.lang.System.Logger;
import java.util.Arrays;

class MarsRover {

  private static final Logger LOGGER = System.getLogger(MarsRover.class.getName());

  private final ObstacleDetector obstacleDetector;

  private Position currentPosition;

  MarsRover(Position initialPosition) {
    this.currentPosition = initialPosition;
    this.obstacleDetector = location -> false;
  }

  public MarsRover(Position initialPosition, ObstacleDetector obstacleDetector) {
    this.currentPosition = initialPosition;
    this.obstacleDetector = obstacleDetector;
  }

  Position go(Command[] commands) {
    if (commands == null || commands.length == 0) {
      return currentPosition;
    }
    try {
      Arrays.stream(commands).forEach(this::move);
    } catch (ObstacleAheadException e) {
      LOGGER.log(ERROR, "Sequence aborted: " + e.getMessage(), e);
    }
    return currentPosition;
  }

  private void move(Command command) {
    Position nextPosition =
        switch (command) {
          case F -> currentPosition.forward();
          case B -> currentPosition.backward();
          case L -> currentPosition.left();
          case R -> currentPosition.right();
        };
    if (obstacleDetector.hasObstacle(nextPosition.location())) {
      throw new ObstacleAheadException(nextPosition.location());
    }
    currentPosition = nextPosition;
  }
}
