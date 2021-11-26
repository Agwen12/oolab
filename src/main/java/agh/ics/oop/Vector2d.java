package agh.ics.oop;

import java.util.Objects;

public class Vector2d {

    final public int x;
    final public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(other.x, this.x), Math.max(other.y, this.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(other.x, this.x), Math.min(other.y, this.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x &&
                y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

//    @Override
//    public int compareTo(Object o) {
//        if (!(o instanceof Vector2d)) return 0;
//        Vector2d vec = (Vector2d) o;
//        if (this.x < vec.x || this.y < vec.y) return -1;
//        else if (this.x > vec.x || this.y > vec.y) return 1;
//        else return 0;
//    }
}
