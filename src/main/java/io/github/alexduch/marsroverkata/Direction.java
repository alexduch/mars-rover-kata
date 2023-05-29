package io.github.alexduch.marsroverkata;

enum Direction {
  N,
  E {
    @Override
    Direction opposite() {
      return W;
    }
  },
  S,
  W;

  Direction opposite() {
    return S;
  }
}
