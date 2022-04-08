package com.hjp.daysUntilFriday;

import java.util.Scanner;
/**
 *
 * @author Henry
 */
public class App {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a day of the week:");
        DaysOfWeek day = DaysOfWeek.valueOf( in.nextLine().toUpperCase().trim() );
        int daysLeft = 0;
        
        switch(day){
            case MONDAY: 
                daysLeft = 4;
                break;
            case TUESDAY:
                daysLeft = 3;
                break;
            case WEDNESDAY:
                daysLeft = 2;
                break;
            case THURSDAY:
                daysLeft = 1;
                break;
            case FRIDAY:
                daysLeft = 0;
                break;
            case SATURDAY:
                daysLeft = 6;
                break;
            case SUNDAY:
                daysLeft = 5;
                break;
        }
        System.out.println(daysLeft + " days until friday");
    }
}
