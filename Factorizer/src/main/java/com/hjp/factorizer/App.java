package com.hjp.factorizer;
import java.util.Scanner;
/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number to factor: ");
        int input = sc.nextInt();
        Factorizer.factorize(input);
    }
}
