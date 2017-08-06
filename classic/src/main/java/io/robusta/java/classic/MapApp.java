package io.robusta.java.classic;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 *  Map :
 *  We add entry with map.put(key, val)
 *  We read value with map.get(key)
 *  We read keys with map.keySet()
 *  We read values with map.values()
 *  We read entries with map.entrySet()
 *
 *
 */
public class MapApp {

    Map<Integer, String> buildMap(int key1, String val1, int key2, String val2){
        return null;
    }


    Map<Integer, String> buildMap(int[] keys, String[] values){
        return null;
    }

    Set<Integer> getKeys(Map<Integer, String> map){
        return null;
    }

    List<Integer> getKeysAsList(Map<Integer, String> map){
        return null;
    }
    
     Set<Entry<Integer, String>> getEntries(Map<Integer, String> map){
        return null;
    }
    
    List<String> getValues(Map<Integer, String> map){
        return null;
    }

    

    String[]  getValuesFromMap(Map<Integer, String> map, int key1,  int key2){
        return null;
    }


    List<Integer>  getKeysHavingValue(Map<Integer, String> map, String value){
        return null;
    }

    List<Integer>  getKeysHavingValueAnyValue(Map<Integer, String> map, String... values){
        return null;
    }

    //TODO: move up
    String displayMap(Map<Integer, String> map){
        // Use map.entrySet()to have nice display
        for (Entry<Integer, String> entry: map.entrySet()){
            System.out.println( "Entry:"+entry.getKey());
            System.out.println( "Value:"+entry.getValue());
        }

        return null;
    }

    List<Card> getCards(Map<Integer, Character> map){
        return null;
    }




   




}
