package io.robusta.people;

import java.util.Random;

/**
 * Created by Robusta Code
 */
public class People {
    String name;
    int age;

    public People(String name) {
        this(name ,new Random().nextInt(100));
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        return name != null ? name.equals(people.name) : people.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
