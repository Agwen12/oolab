package agh.ics.oop;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private final double range;
    private final MapBoundary mapBoundary = new MapBoundary();



    public GrassField(int grassPatchNumber) {
        this.mapVisualizer = new MapVisualizer(this);
        this.range = Math.sqrt(grassPatchNumber * 10);
        placeGrass(grassPatchNumber);
    }

    private void placeGrass(int quantity) {
        int grassCounter = 0;
        while (grassCounter < quantity) {
            Vector2d pos = new Vector2d((int) (Math.random() * this.range), (int) (Math.random() * this.range));
            Object obj = objectAt(pos);
            if (obj == null) {
                Grass grass = new Grass(pos);
                elementMap.put(pos, grass);
                mapBoundary.addElement(pos); //TODO check if it's working correctly
                grassCounter++;
            }
        }
    }

    public void updateSize() {
        this.upperRight = mapBoundary.getUpperRight();
        this.lowerLeft = mapBoundary.getLowerLeft();
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        mapBoundary.addElement(animal.getPosition());
        animal.addObserver(mapBoundary);
        return super.place(animal);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Grass) {
            elementMap.remove(((Grass) object).position, object);
            mapBoundary.removeElement(position);
            placeGrass(1);
        }
        return super.canMoveTo(position);
    }


    @Override
    public String toString() {
        updateSize();
        return super.toString();
    }

    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement element = (AbstractWorldMapElement) objectAt(oldPosition);
        if (!(oldPosition.equals(newPosition))) {
            if (element instanceof Animal) {
                elementMap.remove(oldPosition, element);
                elementMap.put(newPosition, element);
                return true;
            }
        }
        return false;
    }
}
