package io.robusta.people;

import java.util.TreeSet;

/**
 * Created by Robusta Code
 */
public class EqualStringApplication {

    public static void main(String[] args) {

        String x1 = "x";
        String x2 = "x";

        System.out.println(x1==x1);

        TreeSet<String> set = new TreeSet<>();
        set.add(x1);
        set.contains(x1);
        set.contains(x2); // ???

    }

}
