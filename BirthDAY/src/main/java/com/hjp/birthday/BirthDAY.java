package com.hjp.birthday;

/**
 *
 * @author Henry
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthDAY {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate timeNow = LocalDate.now();
        int currentYear = timeNow.getYear();
        
        System.out.println("[] BIRTHDAY CALCULATOR []");
        
        System.out.println("What's your birthday? (MM/DD/YYYY) ");
        
        LocalDate bDay = LocalDate.parse( in.nextLine(), formatter );
        
        System.out.println("You were born on a " + bDay.getDayOfWeek() + "!");
        
        System.out.println("This year it falls on a " + bDay.withYear(currentYear).getDayOfWeek() );
        
        System.out.print("Today is "+timeNow.format(formatter));
        
        int comparison = timeNow.compareTo( bDay.withYear(currentYear) );
        if( comparison == 0 ){
            //today is birthday
            System.out.println(" so happy birthday!!!! ");
        }
        else if( comparison > 0 ){
            //birthday this year has passed, find days until next year
            System.out.println(" so there is "+timeNow.until(bDay.withYear(currentYear+1), ChronoUnit.DAYS)+" days until your birthday!");
        }
        else{
            System.out.println(" so there is "+timeNow.until(bDay, ChronoUnit.DAYS)+" days until your birthday!");
        }
         
        System.out.println(" I bet you're excited to turn " + (bDay.until(timeNow, ChronoUnit.YEARS)+1) );
    }
}
