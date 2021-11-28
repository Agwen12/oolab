package agh.ics.oop;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private final double range;
//    private final SortedSet<Integer> keySetX = new TreeSet<>();
//    private final SortedSet<Integer> keySetY = new TreeSet<>();


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
                elementMap.put(pos, new Grass(pos));
//                keySetX.add(pos.x);
//                keySetY.add(pos.y);
                grassCounter++;
            }
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Grass) {
            elementMap.remove(((Grass) object).position, object);
            placeGrass(1);
        }
        return super.canMoveTo(position);
    }


    @Override
    public String toString() {
        for (AbstractWorldMapElement element : elementMap.values().stream().toList()) {
            this.upperRight = element.getPosition().upperRight(this.upperRight);
            this.lowerLeft = element.getPosition().lowerLeft(this.lowerLeft);
        }
//        this.upperRight = new Vector2d(keySetX.last(), keySetY.last());
//        this.lowerLeft = new Vector2d(keySetX.first(), keySetY.first());
        return super.toString();
    }

    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (!(oldPosition.equals(newPosition))) {
            AbstractWorldMapElement element = (AbstractWorldMapElement) objectAt(oldPosition);
            if (element instanceof Animal) {
                elementMap.remove(oldPosition, element);
                elementMap.put(newPosition, element);
                return true;
            }
        }
        return false;
    }
}
