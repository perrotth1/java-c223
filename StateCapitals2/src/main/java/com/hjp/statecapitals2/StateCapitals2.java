package com.hjp.statecapitals2;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Henry Perrottet
 */
public class StateCapitals2 {

    public static void main(String[] args) {
       Map<String, String> stateCapitals = loadData();
       Random rg = new Random();
       Scanner userIn = new Scanner(System.in);
       int score = 0, rounds;
       
       System.out.println("[*] There are " + stateCapitals.size() + " State/Capital pairs loaded" );
       
       System.out.println("=== STATES ===");
       int count = 0;
       for( String state : stateCapitals.keySet() ){
            System.out.print( state );
            if(count != stateCapitals.size() - 1){
                System.out.print(", ");
            }
            if(count >= 10 && count % 10 == 0){
                System.out.println();
            }
            count++;
       }
       
       System.out.println("\n=== QUIZ GAME ===");
       System.out.println("[*] How many state capitals would you like to be tested on?");
       rounds = Integer.parseInt( userIn.nextLine() );
       if(rounds > 50){
            System.out.println("[!] Maximum rounds is 50 since there are 50 states. Rounds set to 50");
            rounds = 50;
       }
       
       //this arraylist will hold the states that have yet to be quizzed on
       ArrayList<String> statesForQuiz = new ArrayList<>( stateCapitals.keySet() );
       
       while(rounds > 0){
           
           //Choose a random state from statesForQuiz
           String askingState = statesForQuiz.get( rg.nextInt( statesForQuiz.size() ) );
           
           System.out.println("[*] What is the capital of " + askingState + " ?");
           String answer = userIn.nextLine();
           
           if( answer.equalsIgnoreCase( stateCapitals.get(askingState) ) ) {
                System.out.println("[*] CORRECT! +1 point! " );
                score++;
           }
           else{
                System.out.println("[*] INCORRECT! -1 point! The answer was: " + stateCapitals.get(askingState));
                score--;
           }
           
           //remove that state from the question pool so we don't ask user duplicate questions
           statesForQuiz.remove(askingState);
           rounds--;
       }
       System.out.println("=============\nFinal Score: " + score);
    }
    
    public static Map<String, String> loadData(){
        Map<String, String> stateCapitals = new HashMap<>();
        Scanner reader;
        try{
            reader = new Scanner( new BufferedReader( new FileReader( "data.txt" ) ) );
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                if(line.length() > 0){
                    String[] tokens = unmarshal(line, "::");
                    stateCapitals.put( tokens[0], tokens[1] );
                }
            }
        }
        catch(Exception e){
            System.out.println( "Error reading file: " + e.getMessage());
        }
        
        return stateCapitals;
    }
    
    public static String[] unmarshal(String _line, String _delimiter){
        return _line.split(_delimiter);
    }
    
}
