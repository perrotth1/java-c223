package com.hjp.mathoperators;

import java.util.Scanner;
/**
 *
 * @author Henry
 */
public class App {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter first operand:");
        int op1 = Integer.parseInt( in.nextLine() );
        
        System.out.println("Enter second operand:");
        int op2 = Integer.parseInt( in.nextLine() );
        
        for(Operator op : Operator.values()){
            System.out.println(op1 +" "+op+" "+op2+" = "+calculate(op, op1, op2) );
        }
    }
    
    public static int calculate(Operator op, int operand1, int operand2) 
            throws UnsupportedOperationException{
        switch(op){
            case PLUS:
                return operand1+operand2;
            case MINUS:
                return operand1-operand2;
            case MULTIPLY:
                return operand1*operand2;
            case DIVIDE:
                return operand1/operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
