package com.hjp.statecapitals3;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Henry Perrottet
 */
public class StateCapitalsApp {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Capital> stateCapitals = loadData();
        Scanner in = new Scanner(System.in);
        System.out.println("[*] " + stateCapitals.size() + " state/capital pairs loaded!\n");
        
        for(String state : stateCapitals.keySet() ){
            Capital current = stateCapitals.get(state);
            printInfo(state, current);
        }
        
        System.out.println("\n[*] Please enter the lower limit for capital city population: ");
        
        long popLimit = Long.parseLong( in.nextLine() );
        System.out.println("[*] Showing all state capitals with population over "+popLimit);
        for(String state : stateCapitals.keySet() ){
            Capital current = stateCapitals.get(state);
            if(current.getPopulation() > popLimit){
                printInfo(state, current);
            }
        }
        
        System.out.println("\n[*] Please enter the upper limit for capital square mileage: ");
        
        double areaLimit = Double.parseDouble( in.nextLine() );
        System.out.println("[*] Showing all state capitals with area under "+areaLimit+" sq miles");
        for(String state : stateCapitals.keySet() ){
            Capital current = stateCapitals.get(state);
            if(current.getSqMileage() < areaLimit){
                printInfo(state, current);
            }
        }
    }
    
    public static Map<String, Capital> loadData() throws FileNotFoundException{
        Scanner in = new Scanner( new BufferedReader( new FileReader( "data.txt" ) ) );
        Map<String, Capital> stateCapitals = new HashMap<>();
        String buffer;
        
        while(in.hasNextLine()){
            buffer = in.nextLine();
            stateCapitals.put( buffer.split("::")[0] , unmarshal(buffer));
        }
        
        return stateCapitals;
    }
    
    public static Capital unmarshal(String _line){
        String[] tokens = _line.split("::");
        Capital capital = new Capital( tokens[1], Long.parseLong(tokens[2]), Double.parseDouble(tokens[3]) );
        return capital;
    }
    
    public static void printInfo(String _state, Capital _capital){
        System.out.println(_state+" - "+_capital.getName()
                               +" | Pop: "+_capital.getPopulation()
                               +" | Area: "+_capital.getSqMileage());
    }
}
