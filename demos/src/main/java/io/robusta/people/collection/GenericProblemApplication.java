package io.robusta.people.collection;

import io.robusta.people.forum.Comment;

import java.util.ArrayList;

/**
 * Created by Robusta Code
 */
public class GenericProblemApplication {

    public static void main(String[] args) {

        ArrayList<Object> liste = new ArrayList<>();
        Comment c1 = new Comment("Toto");

        //Adding comment and strings
        liste.add(c1);
        liste.add("Something");

        for (int i=0; i<liste.size();i++){
            Comment c = (Comment) liste.get(i);
            System.out.println(c.html());

            // try instanceof
        }

    }
}
