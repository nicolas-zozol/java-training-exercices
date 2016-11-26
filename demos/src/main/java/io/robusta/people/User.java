package io.robusta.people;

/**
 * Created by Robusta Code
 */
public class User /* extends Object */{

    public String name;
    String email;
    int age;
    Address adress;

    @Override // override Object.toString()
    public String toString() {
        return this.name+" is "+age+" years old";
    }

}
