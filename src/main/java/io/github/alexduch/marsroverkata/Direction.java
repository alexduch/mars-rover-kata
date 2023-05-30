package io.github.alexduch.marsroverkata;

enum Direction {
  N {
    @Override
    Direction opposite() {
      return S;
    }

    @Override
    Direction left() {
      return W;
    }
  },
  E {
    @Override
    Direction opposite() {
      return W;
    }

    @Override
    Direction left() {
      return N;
    }

    @Override
    Direction right() {
      return S;
    }
  },
  S {
    @Override
    Direction opposite() {
      return N;
    }

    @Override
    Direction left() {
      return E;
    }

    @Override
    Direction right() {
      return W;
    }
  },
  W {
    @Override
    Direction opposite() {
      return E;
    }

    @Override
    Direction left() {
      return S;
    }
  };

  abstract Direction opposite();

  abstract Direction left();

  Direction right() {
    return E;
  }
}
