package io.github.alexduch.marsroverkata;

import static io.github.alexduch.marsroverkata.MarsMap.*;
import static java.util.stream.IntStream.rangeClosed;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MarsMapTest {

  @Test
  void wrapOnNorthEdge() {
    assertAll(
        () -> assertThat(wrapOnNorthSouthAxis(12)).isEqualTo(1),
        () -> assertThat(wrapOnNorthSouthAxis(24)).isEqualTo(2),
        () -> assertThat(wrapOnNorthSouthAxis(55)).isZero());
  }

  @Test
  void noWrapNeeded() {
    assertAll(
        rangeClosed(SOUTH_EDGE, NORTH_EDGE)
            .mapToObj(i -> () -> assertThat(wrapOnNorthSouthAxis(i)).isEqualTo(i)));
  }
}
