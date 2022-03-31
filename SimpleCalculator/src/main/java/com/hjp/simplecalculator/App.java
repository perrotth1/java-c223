package com.hjp.simplecalculator;

/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new KBApp();
        
        int choice;
        double x, y;
        
        while(true) {
            io.print("\n\n  CALCULATOR");
            
            choice = io.readInt("   1) Add\n   2) Subtract\n   3) Multiply\n   4) Divide\n   0) Exit");
            
            if(choice < 1 || choice > 4) {
                io.print("Exiting. Thank you.");
                return;
                
            }
            
            x = io.readDouble("Enter first operand: ");
            y = io.readDouble("Enter second operand: ");
        
            io.print("\n============\nRESULT: ");
            switch(choice) {
                case 1:
                    io.print( SimpleCalc.add(x, y) );
                    break;
                case 2:
                    io.print( SimpleCalc.sub(x, y) );
                    break;
                case 3:
                    io.print( SimpleCalc.mult(x, y) );
                    break;
                case 4:
                    io.print( SimpleCalc.div(x, y) );
                    break;
                default:
                    io.print("Exiting");
                    return;
            }
        }
    }
}
