package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public MapDirection next() {
        switch (this) {

            case WEST -> {
                return NORTH;
            }
            case NORTH -> {
                return EAST;
            }
            case EAST -> {
                return SOUTH;
            }
            case SOUTH -> {
                return WEST;
            }
        }
        return SOUTH;
    }

    public MapDirection previous() {
        switch (this) {

            case WEST -> {
                return SOUTH;
            }
            case NORTH -> {
                return WEST;
            }
            case EAST -> {
                return NORTH;
            }
            case SOUTH -> {
                return EAST;
            }
        }
        return SOUTH;
    }

    public Vector2d toUnitVector() {
        switch (this) {

            case WEST -> {
                return new Vector2d(-1, 0);
            }
            case NORTH -> {
                return new Vector2d(0, 1);
            }
            case EAST -> {
                return new Vector2d(1, 0);
            }
            case SOUTH -> {
                return new Vector2d(0, -1);
            }
        }
        return new Vector2d(0, 0);
    }

    @Override
    public String toString() {
        switch (this) {
            case EAST -> {
                return "Wschód";
            }
            case WEST -> {
                return "Zachód";
            }
            case NORTH -> {
                return "Północ";
            }
            case SOUTH -> {
                return "Południe";
            }
        }
        return "";
    }
}
