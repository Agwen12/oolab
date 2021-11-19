package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private final double range;


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
                elementList.add(new Grass(pos));
                grassCounter++;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object != null && object.getClass() == Grass.class) {
            elementList.remove(object);
            placeGrass(1);
        }
        return super.canMoveTo(position);
    }


    @Override
    public String toString() {
        for (AbstractWorldMapElement element : elementList) {
            this.upperRight = element.getPosition().upperRight(this.upperRight);
            this.lowerLeft = element.getPosition().lowerLeft(this.lowerLeft);
        }
        return super.toString();
    }
}
