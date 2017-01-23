package io.robusta.animals;

/**
 * Created by Nicolas on 22/11/2016.
 */
public class PingouinApplication {

    public static void main(String[] args) {

        new PingouinApplication().workOnPingouins();
    }

    void workOnPingouins(){
        Pingouin kowalsky = new Pingouin("Kowalsky");
        Pingouin ricoh = new Pingouin("Ricoh");
        Pingouin soldat = new Pingouin("Soldat");
        Pingouin commandant = new Pingouin("Commandant");


    }
}
