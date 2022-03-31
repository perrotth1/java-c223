package com.hjp.interestcalculator;

import java.util.Scanner;
/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args) {
        double principal, interestRate, years;
        int compound;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter amount to invest: ");
        principal = Double.parseDouble( sc.nextLine() );
        System.out.println("Enter annual interest rate: ");
        interestRate = Double.parseDouble( sc.nextLine() );
        System.out.println("Enter time in years you are investing: ");
        years = Integer.parseInt( sc.nextLine() );
        System.out.println("Select compound period by entering number selection from 1-3: ");
        System.out.println("1) Quarterly \n2)Monthly \n3) Daily");
        compound = Integer.parseInt( sc.nextLine() );
        
        InterestCalculator pc = new InterestCalculator(interestRate, principal, years);
        
        pc.calculate(years, compound);
        
    }
}
