package io.robusta.hand;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(3, "3s 3h 3d");
        map.put(6, "6s 6d");

        System.out.println(map);

        Map<String, String> players = new TreeMap<>();

        // put add entries in the map
        players.put("Platini", "France");
        players.put("Tigana", "France");
        players.put("Zico", "Brasil");
        players.put("Rossi", "Italy");
        System.out.println(players);

        // get will retrieve data
        System.out.println(players.get("Platini"));
        // no value => null
        System.out.println(players.get("Ronaldo"));

        // How to interate on a Map ? That is a difficult thing to do !!!!
        // Just remember this lines, you may need it

        for (Map.Entry<String, String> entry: players.entrySet() ){
            System.out.println("The player "+entry.getKey() + " comes from "+entry.getValue());
        }


        Map<Integer, List<String>> cards = new TreeMap<>();

        List<String> init = new ArrayList<>();
        init.add("3s");
        init.add("3d");
        init.add("3h");

        cards.put(3, init); // create a List<String> in java 8-
        cards.put(6, Arrays.asList("6s", "6d"));

        List<String> treys = cards.get(3);
        treys.add("3c");

        System.out.println(cards);


        Map<Integer, List<Card>> handMap = new TreeMap<>();
        // .... let's work


    }

}
