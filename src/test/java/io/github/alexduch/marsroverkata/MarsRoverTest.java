package io.github.alexduch.marsroverkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
