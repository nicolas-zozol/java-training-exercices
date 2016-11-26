package io.robusta.people;

import io.robusta.people.forum.Comment;

/**
 * Created by Robusta Code
 */
public class CommentApplication {

    public static void main(String[] args) {
        Admin joe = new Admin("Joe");
        User jack = new Admin("Jack");

        Comment cJoe = new Comment("Hello Jack");
        Comment cJack = new Comment("hello Joe");

        // will display Admin directory
        System.out.println(cJack.html(joe));

        // will display user name or admin directory ?
        System.out.println(cJack.html(jack));
    }
}

