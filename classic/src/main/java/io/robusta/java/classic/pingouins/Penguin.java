package io.robusta.java.classic.pingouins;

/**
 * Created by Nicolas on 22/11/2016.
 */
public class Penguin implements Comparable<Penguin>{

    String name;
    int speed = 10;

    Penguin friend;

    public Penguin(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Penguin o) {
        return 0;
    }


    public void setFriend(Penguin friend) {
        this.friend = friend;
    }

    public Penguin getFriend() {
        return friend;
    }


    public String getName() {
        return name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
