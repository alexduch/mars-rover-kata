package io.github.alexduch.marsroverkata;

enum Direction {
  N {
    @Override
    Direction opposite() {
      return S;
    }
  },
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
  W {
    @Override
    Direction opposite() {
      return E;
    }
  };

  abstract Direction opposite();
}
