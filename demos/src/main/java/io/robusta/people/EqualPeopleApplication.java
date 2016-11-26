package io.robusta.people;

/**
 * Created by Robusta Code
 */
public class EqualPeopleApplication {

    public static void main(String[] args) {

        System.out.println("2 == 2 :"+ (2==2));

        People john = new People("John");
        People johndoe = new People("John");
        People jack = new People("John");

        System.out.println("jack == john :"+ (jack==john));
        System.out.println("john == john :"+ (john==john));

        // john == johndoe ?
    }
}
