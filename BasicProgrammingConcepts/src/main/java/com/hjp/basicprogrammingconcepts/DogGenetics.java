package com.hjp.basicprogrammingconcepts;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Henry Perrottet
 */
public class DogGenetics {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Random rg = new Random();
        String[] breeds = {"Corgy", "Dog-Man", "Pigdog", "Wolf", "Big red dog"};
        int total = 100; 
        
        System.out.println("Enter the name of your dog: ");
        String name = sc.nextLine();
        
        System.out.println("Here is your dog's genetics: ");
        for(int i = 0; i < 4; i++){
            int percent = rg.nextInt(total+1);
            System.out.println(breeds[i] + " - " + percent + "%");
            total -= percent;
        }
        System.out.println(breeds[4] + " - " + total + "%" );
        System.out.println("nice dog!");
    }
}
