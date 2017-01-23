package io.robusta.people;

/**
 * Created by Robusta Code
 */
public class Admin extends User {

    private String directory;

    public Admin(String name) {
        this.directory = "/home/"+this.name;
    }

    public String getDirectory() {
        return directory;
    }
}
