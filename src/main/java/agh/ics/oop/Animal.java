package agh.ics.oop;

public class Animal {

    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;

    public Animal() {
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d temp = this.position.add(this.orientation.toUnitVector());
                if (temp.precedes(new Vector2d(4, 4)) &&  temp.follows(new Vector2d(0, 0))) {
                    this.position = temp;
                }
            }
            case BACKWARD -> {
                Vector2d temp = this.position.subtract(this.orientation.toUnitVector());
                if (temp.precedes(new Vector2d(4, 4)) && temp.follows(new Vector2d(0, 0))) {
                    this.position = temp;
                }
            }
        }
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
        return position + " " + orientation;
    }

}
