package com.hjp.cubetower;

import java.util.Arrays;

/**
 *
 * @author Henry Perrottet
 */
public class CubeTower {
    
    public static void main(String[] args){
        
        System.out.println("3 blocks each, height 10: ");
        System.out.println("Max volume difference: " + difference(10, 3) );
        
        System.out.println("10 blocks each, height 10: ");
        System.out.println("Max volume difference: " + difference(10, 10) );
        
        System.out.println("2 blocks each, height 5: ");
        System.out.println("Max volume difference: " + difference(5, 2) );
        
        System.out.println("2 blocks each, height 4: ");
        System.out.println("Max volume difference: " + difference(4, 2) );
        
        System.out.println("16 blocks each, height 17: ");
        System.out.println("Max volume difference: " + difference(17, 16) );
        
        System.out.println("3 blocks each, height 9: ");
        System.out.println("Max volume difference: " + difference(9, 3) );
    }
    
    /**
     * This method solves the cube tower problem detailed at https://community.topcoder.com/stat?c=problem_statement&pm=16971
     * It determines that the maximum volume tower is the tower where the block sizes are least evenly 
     * distributed (where one block has the highest possible side length and the rest have a side length of 1),
     * and the minimum volume tower is the tower where block sizes are most evenly distributed (each block is
     * as equally sized as possible). I discovered this when I realized that block volume increases exponentially
     * as side length increases, so to maximize tower volume you just have to have to maximize the size of one
     * of the blocks in that tower. 
     * @param _h height of tower
     * @param _n number of blocks per tower
     * @return the difference between the maximum and minimum volume towers
     */
    public static long difference(int _h, int _n){
        
        //calculate the maximum side length of a block, which is the max side length where
        //if one block had this side length and the rest of the blocks were size 1, they would
        //total the height of the tower.
        int maxSide = _h - (_n - 1);
        
        //calculate max volume of this described tower
        long maxVol = (long)Math.pow(maxSide, 3) + (_n - 1);
        
        //make an array of block side lengths such that they are as evenly sized as possible
        int[] evenDistro = new int[_n];
        int mostEvenSide = (int) Math.floor( _h / _n );
        Arrays.fill(evenDistro, mostEvenSide);
        
        //evenly distribute the remainder of height over the block sizes array
        int rem = _h % _n;
        for(int i = 0; i < rem; i++){
            evenDistro[i]++;
        }
        
        //calculate the total volume of the minimum 
        long minVol = 0;
        for(int i = 0; i < evenDistro.length; i++){
            minVol += (long) Math.pow( evenDistro[i] , 3);
        }
        
        return maxVol-minVol;
    }
}
