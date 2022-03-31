package com.hjp.interestcalculator;

import java.util.Scanner;
/**
 *
 * @author Henry Perrottet
 */
public class InterestCalculator {
    double interestRate, principal, initial;
    
    public InterestCalculator(double interestRate, double principal, double initial) {
        this.interestRate = interestRate;
        this.principal = principal;
        this.initial = initial;
    }
    
    public int getCompoundFromChoice(int _choice){
        switch( _choice ) {
            case 1:
                return 4;
            case 2: 
                return 12;
            case 3:
                return 365;
            default:
                return 4;
        }
    }
    
    public double calculate(double years, int compoundChoice) {
        
        int compound = getCompoundFromChoice(compoundChoice);
        
        System.out.println();
        
        for(int i = 1; i <= years; i++) {
            initial = principal;
            System.out.println("Year " + i + ": ");
            System.out.println("Began with: $" + principal);

            calculatePrincipalForYear(compound);
            
            System.out.println("Earned: $" + roundMoney(principal-initial));
            System.out.println("Ended with: $" + principal + "\n");
        }
        
        return principal; 
    }
    
    public double roundMoney(double a) {
        return (double) Math.round(a*100) / 100;
    }
    
    public void calculatePrincipalForYear(int _compound){
        principal = principal * Math.pow( 1 + (interestRate/100/_compound), _compound ); 
        principal = roundMoney(principal);
    }
}
