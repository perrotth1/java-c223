package com.hjp.simplecalculator;

import java.util.Scanner;
/**
 *
 * @author Henry Perrottet
 */
public class KBApp implements UserIO {
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public void print(double number){
        System.out.println(number);
    }
    
    @Override
    public int readInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return( Integer.parseInt( sc.nextLine() ) );
    }

    @Override
    public double readDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return( Double.parseDouble( sc.nextLine() ) );
    }

}
