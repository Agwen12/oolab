package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public MapDirection next() {
        MapDirection[] directions = MapDirection.values();
        return directions[(this.ordinal() + 1) % directions.length];
    }

    public MapDirection previous() {
        MapDirection[] directions = MapDirection.values();
        return directions[(this.ordinal() - 1 + directions.length) % directions.length];
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
            default -> {
                return new Vector2d(0, -1);
            }
        }

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
            default -> {
                return "Południe";
            }
        }
    }
}
