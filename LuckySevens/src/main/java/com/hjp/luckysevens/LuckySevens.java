package com.hjp.luckysevens;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Henry Perrottet
 */
public class LuckySevens {
    private int betMoney;
    Random rg = new Random();
    
    public LuckySevens(int _betMoney){
        this.betMoney = _betMoney;
    }
    
    public void play() {
        int rolls = 0, maxMoney, maxRoll = 0;
                
        maxMoney = betMoney;
        
        while(betMoney > 0) {
            roll();
            
            rolls++;
            
            if(betMoney > maxMoney) {
                maxMoney = betMoney;
                maxRoll = rolls;
            }
            
        }
        printResults(rolls, maxRoll, maxMoney);
    }
    
    public void roll(){
        if(2 + rg.nextInt(6) + rg.nextInt(6) == 7) {
            betMoney += 4;
        }
        else {
            betMoney--;
        }
    }
    
    public void printResults(int _rolls, int _maxRoll, int _maxMoney){
        System.out.println("You are broke after " + _rolls + " rolls...");
        System.out.println("You should have quit after " + _maxRoll + " rolls when you had $ " + _maxMoney);
    }
    
   
}
