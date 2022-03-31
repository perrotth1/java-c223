package com.hjp.factorizer;

/**
 *
 * @author Henry Perrottet
 */
public class Factorizer {
    public static void factorize(int _num){
        int totalFactors = 1;
        int sum = 1;
        
        System.out.print(1 + " ");
        for(int i = 2; i <= _num/2; i++){
            if( isDivisible(_num, i) ){
                totalFactors++;
                sum += i;   
                System.out.print(i + " ");
            }
        }
        
        totalFactors++;     //number itself as a factor
        sum += _num;
        
        printResults(_num, totalFactors, sum);
    }
    
    public static boolean isDivisible(int _dividend, int _divisor){
        if(_dividend % _divisor == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void printResults(int _num, int _totalFactors, int _sum){
        System.out.println("Total number of factors: " + _totalFactors + "\n");
        if(_sum - _num == _num){
            System.out.println(_num + " is a perfect number");
        }
        else{
            System.out.println(_num + " is not a perfect number");
        }
        
        if(_totalFactors - 1 == 2){
            System.out.println(_num + " is a prime number");
        }
        else{
            System.out.println(_num + " is not a prime number");
        }
    }
}
