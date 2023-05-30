package io.github.alexduch.marsroverkata;

import static io.github.alexduch.marsroverkata.Command.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverTest {

  @Test
  void goingNoWhereWhenTheCommandArrayIsNull() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);

    Position newPosition = new MarsRover(initialPosition).go(null);

    assertThat(newPosition).isEqualTo(initialPosition);
  }

  @Test
  void goingNoWhereWhenTheCommandArrayIsEmpty() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);
    Command[] commands = {};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(initialPosition);
  }

  @ParameterizedTest(name = "Going forward in direction {0}")
  @CsvSource({"N,4,5", "E,5,4", "S,4,3", "W,3,4"})
  void goingForward(Direction direction, int expectedX, int expectedY) {
    Position initialPosition = new Position(new Location(4, 4), direction);
    Command[] commands = {F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(expectedX, expectedY), direction));
  }

  @ParameterizedTest(name = "Going further in direction {0}")
  @CsvSource({"N,4,7", "E,7,4", "S,4,1", "W,1,4"})
  void goingFurther(Direction direction, int expectedX, int expectedY) {
    Position initialPosition = new Position(new Location(4, 4), direction);
    Command[] commands = {F, F, F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(expectedX, expectedY), direction));
  }

  @ParameterizedTest(name = "Going backward in direction {0}")
  @CsvSource({"N,4,3", "E,3,4", "S,4,5", "W,5,4"})
  void goingBackward(Direction direction, int expectedX, int expectedY) {
    Position initialPosition = new Position(new Location(4, 4), direction);
    Command[] commands = {B};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(expectedX, expectedY), direction));
  }

  @ParameterizedTest(name = "Turning {0} when facing {1}")
  @CsvSource({"L,N,W", "L,E,N", "L,S,E", "L,W,S", "R,N,E", "R,E,S", "R,S,W", "R,W,N"})
  void turning(Command command, Direction initialDirection, Direction expectedDirection) {
    Position initialPosition = new Position(new Location(0, 0), initialDirection);
    Command[] commands = {command};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), expectedDirection));
  }
}
