package com.hjp.dvdlibrary.ui;

import java.util.Scanner;
/**
 *
 * @author Henry Perrottet
 */
public class UserIOConsoleImpl implements UserIO {
    private Scanner sc = new Scanner(System.in); 
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return( sc.nextLine().trim() );
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return( Integer.parseInt( sc.nextLine() ) );
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input;
        while(true) {
            System.out.println(prompt);
            input = Integer.parseInt( sc.nextLine() ) ;
            if(input >= min && input <= max ) {
                return input;
            }
        }
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return( Double.parseDouble( sc.nextLine() ) );
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double input;
        while(true) {
            System.out.println(prompt);
            input = Double.parseDouble( sc.nextLine() ) ;
            if(input >= min && input <= max ) {
                return input;
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return( Float.parseFloat( sc.nextLine() ) );
    
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float input;
        while(true) {
            System.out.println(prompt);
            input = Float.parseFloat( sc.nextLine() ) ;
            if(input >= min && input <= max ) {
                return input;
            }
        }
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return( Long.parseLong( sc.nextLine() ) );
    
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long input;
        while(true) {
            System.out.println(prompt);
            input = Long.parseLong( sc.nextLine() ) ;
            if(input >= min && input <= max ) {
                return input;
            }
        }
    }
}
