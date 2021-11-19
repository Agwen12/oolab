package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {


    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width - 1;
        this.height = height - 1;
        this.upperRight = new Vector2d(this.width, this.height);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.precedes(new Vector2d(width, height)) &&
                position.follows(new Vector2d(0, 0))) &&
                super.canMoveTo(position);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
