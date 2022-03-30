package com.hjp.basicprogrammingconcepts;

import java.util.Scanner;
/**
 *
 * @author Henry Perrottet
 */
public class HealthyHearts {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        
        if(age > 220) {
            System.out.println("You are over 220 years old. There is no healthy heart rate for you." );
            return;
        }
        
        double max = 220 - age;
        System.out.println("Your maximum heart rate should be " + (int)max + " bpm");
        double targetLow = max / 2;
        double targetHigh = (max / 100) * 85;
        System.out.println("Your target HR range is "+Math.round(targetLow)+" - "+Math.round(targetHigh)+" bpm");
    }
}
