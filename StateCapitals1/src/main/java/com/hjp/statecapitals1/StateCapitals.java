package com.hjp.statecapitals1;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 *
 * @author Henry Perrottet
 */
public class StateCapitals {
    public static void main(String[] args){
        Map<String, String> stateCapitals = new HashMap<>( Map.of("New York", "Albany",
                                                                  "Massechusettes","Boston",
                                                                  "Arizona","Phoenix",
                                                                  "Arkansas","Little Rock",
                                                                  "Texas", "Austin",
                                                                  "Florida", "Tallahassee",
                                                                  "Pennsylvania","Harrisburg",
                                                                  "Ohio", "Columbus",
                                                                  "California","Sacramento"));
        
        System.out.println("STATES:\n==========");
        for( String s : stateCapitals.keySet() ){
            System.out.println( s );
        }
        System.out.println("CAPITALS:\n===========");
        for( String s : stateCapitals.values() ){
            System.out.println( s );
        }
        
        String[] sortedKeys = stateCapitals.keySet().toArray(new String[0]);
        Arrays.sort( sortedKeys );
        System.out.println("STATE - CAPITAL (ALPHABETICAL):\n============");
        for( String s : sortedKeys ){
            System.out.println( s + " - - " + stateCapitals.get(s) );
        }
    }
}
