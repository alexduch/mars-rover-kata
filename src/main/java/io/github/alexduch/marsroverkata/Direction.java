package io.github.alexduch.marsroverkata;

enum Direction {
  N,
  E {
    @Override
    Direction opposite() {
      return W;
    }
  },
  S {
    @Override
    Direction opposite() {
      return N;
    }
  },
  W;

  Direction opposite() {
    return S;
  }
}
