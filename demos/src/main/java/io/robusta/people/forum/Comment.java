package io.robusta.people.forum;

import io.robusta.people.Admin;
import io.robusta.people.User;

/**
 * Created by Robusta Code
 */
public class Comment {

    String content;
    int score = 0;

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
    }

    public String html() {
        return "<span>" + this.content + "</span>";
    }

    public String html(User user) {
        return html() + "<span>" + user.name + "</span>";
    }

    public String html(Admin admin) {
        return html() + "<span>" + admin.getDirectory() + "</span>";
    }

}




