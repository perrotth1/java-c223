package com.hjp.marriageandcharging;

/**
 *
 * @author Henry Perrottet
 */
public class MarriageAndCharging {
    public static void main(String[] args){
        
    }
    
    public static int solve(int _forumLength, int[] _relatives, int[] _greetings){
        int startingCount = 0, charge, position;
        
        for(int i = 0; i < _relatives.length; i++){
            charge = 0;
            position = i;
            while(true){
                charge += _greetings[position];
            }
        }
    }
}
