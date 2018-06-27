package io.robusta.java.classic;

public class Vector {

    int x;
    int y;

    public Vector() {
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object vector) {
        if (! (vector instanceof Vector)){
            return false;
        }

        Vector other = (Vector) vector;

        return this.x == other.x && this.y == other.y;
    }

}
