package io.github.alexduch.marsroverkata;

import static io.github.alexduch.marsroverkata.Command.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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

  @Test
  void goingForwardWhenFacingNorth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);
    Command[] commands = {F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 1), Direction.N));
  }

  @Test
  void goingFurtherWhenFacingNorth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);
    Command[] commands = {F, F, F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 3), Direction.N));
  }

  @Test
  void goingForwardWhenFacingEast() {
    Position initialPosition = new Position(new Location(0, 0), Direction.E);
    Command[] commands = {F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(1, 0), Direction.E));
  }

  @Test
  void goingForwardWhenFacingSouth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.S);
    Command[] commands = {F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, -1), Direction.S));
  }

  @Test
  void goingForwardWhenFacingWest() {
    Position initialPosition = new Position(new Location(0, 0), Direction.W);
    Command[] commands = {F};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(-1, 0), Direction.W));
  }

  @Test
  void goingBackwardWhenFacingNorth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);
    Command[] commands = {B};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, -1), Direction.N));
  }

  @Test
  void goingBackwardWhenFacingEast() {
    Position initialPosition = new Position(new Location(0, 0), Direction.E);
    Command[] commands = {B};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(-1, 0), Direction.E));
  }

  @Test
  void goingBackwardWhenFacingSouth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.S);
    Command[] commands = {B};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 1), Direction.S));
  }

  @Test
  void goingBackwardWhenFacingWest() {
    Position initialPosition = new Position(new Location(0, 0), Direction.W);
    Command[] commands = {B};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(1, 0), Direction.W));
  }

  @Test
  void turningLeftWhenFacingNorth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);
    Command[] commands = {L};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), Direction.W));
  }

  @Test
  void turningLeftWhenFacingEast() {
    Position initialPosition = new Position(new Location(0, 0), Direction.E);
    Command[] commands = {L};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), Direction.N));
  }

  @Test
  void turningLeftWhenFacingSouth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.S);
    Command[] commands = {L};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), Direction.E));
  }

  @Test
  void turningLeftWhenFacingWest() {
    Position initialPosition = new Position(new Location(0, 0), Direction.W);
    Command[] commands = {L};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), Direction.S));
  }

  @Test
  void turningRightWhenFacingNorth() {
    Position initialPosition = new Position(new Location(0, 0), Direction.N);
    Command[] commands = {R};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), Direction.E));
  }

  @Test
  void turningRightWhenFacingEast() {
    Position initialPosition = new Position(new Location(0, 0), Direction.E);
    Command[] commands = {R};

    Position newPosition = new MarsRover(initialPosition).go(commands);

    assertThat(newPosition).isEqualTo(new Position(new Location(0, 0), Direction.S));
  }
}
