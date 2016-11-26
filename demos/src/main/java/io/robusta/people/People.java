package io.robusta.people;

/**
 * Created by Nicolas Zozol on 25/11/2016.
 */
public class People {
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    int getCount(){
        int count =12;
        return count;
    }

    int increaseCount(){
        int count =2;
        return count+1;
    }
}
