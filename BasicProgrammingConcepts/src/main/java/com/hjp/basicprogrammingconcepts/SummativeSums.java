package com.hjp.basicprogrammingconcepts;

/**
 *
 * @author Henry Perrottet
 */
public class SummativeSums {
    public static void main(String[] args){
        int sum1 = addInts( new int[] { 1, 90, -33, -55, 67, -16, 28, -55, 15 } );
        System.out.println("#1 Array Sum: " + sum1);
        int sum2 = addInts( new int[] { 999, -60, -77, 14, 160, 301  } );
        System.out.println("#2 Array Sum: " + sum2);
        int sum3 = addInts( new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
                                        140, 150, 160, 170, 180, 190, 200, -99  } );
        System.out.println("#3 Array Sum: " + sum3);
    }
    public static int addInts(int[] a) {
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
