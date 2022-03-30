package com.hjp.basicprogrammingconcepts;

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
/**
 *
 * @author Henry Perrottet
 */
public class RockPaperScissors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rg = new Random();
        HashMap<Integer, Integer> rules = new HashMap<>();  //which beats which. key is winning move 
        rules.put(1, 3);
        rules.put(2, 1);
        rules.put(3, 2);
        
        int rounds, wins, losses, ties;
        boolean keepGoing = true;
        
        
        while(keepGoing){
            wins = losses = ties = 0;
            
            System.out.println("How many rounds would you like to play (range of 1-10)?");
            rounds = sc.nextInt();

            if(rounds > 10 || rounds < 1){
                System.out.println("Error: Must choose from 1 to 10 rounds. Exiting");
                break;
            }
            
            int count = 1;
            while(count <= rounds){
                System.out.println("=== ROUND "+count+" === \nRock, Paper, or Scissors?");
                System.out.println(" 1) Rock\n 2) Paper\n 3) Scissors");
                int compMove = rg.nextInt(3) + 1;
                int move = sc.nextInt();

                if( rules.get(move) == compMove ){
                    System.out.println("WIN!\n");
                    wins++;
                }
                else if( rules.get(compMove) == move ){
                    System.out.println("LOSE!\n");
                    losses++;
                }
                else{
                    System.out.println("TIE!\n");
                    ties++;
                }
                
                count++;
            }
            
            System.out.println("WINS: " + wins);
            System.out.println("LOSSES: " + losses);
            System.out.println("TIES: " + ties);
        
            if(wins > losses) { System.out.println("YOU WIN!\n"); }
            else if(wins < losses) { System.out.println("YOU LOSE!\n"); }
            else{ System.out.println("IT'S A TIE!\n"); }
            
            System.out.println("Enter the number 1 to play again! ");

            if( sc.nextInt() != 1 ){
                keepGoing = false;
            }
        }
        
        System.out.println("Goodbye!");
    }
}
