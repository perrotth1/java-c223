package com.hjp.luckysevens;

import java.util.Scanner;

/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How mch money would you like to bet?");
        int betMoney = Integer.parseInt( sc.nextLine() );
        
        LuckySevens gameObj = new LuckySevens(betMoney);
        
        gameObj.play();
        
        
    }
}
