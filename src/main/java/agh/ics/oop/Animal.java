package agh.ics.oop;

public class Animal {

    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Animal(){
        this.position = new Vector2d(2,2);
        this.map = new RectangularMap(5, 5);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d temp = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(temp)) this.position = temp;

            }
            case BACKWARD -> {
                Vector2d temp = this.position.subtract(this.orientation.toUnitVector());
                if (map.canMoveTo(temp)) this.position = temp;
            }
        }
    }

    // vector is constant so whatever
    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!position.equals(animal.position)) return false;
        return orientation == animal.orientation;
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + orientation.hashCode();
        return result;
    }



    @Override
    public String toString() {
        return switch (this.orientation) {
            case SOUTH -> "v";
            case NORTH -> "^";
            case WEST -> "<";
            case EAST -> ">";
        };
    }

}
