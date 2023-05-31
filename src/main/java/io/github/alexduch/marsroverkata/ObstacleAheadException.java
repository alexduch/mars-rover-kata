package io.github.alexduch.marsroverkata;

public class ObstacleAheadException extends RuntimeException {
  public ObstacleAheadException(Location obstacleLocation) {
    super("An obstacle has been detected at " + obstacleLocation);
  }
}
