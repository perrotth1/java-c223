package com.hjp.mathoperators;

/**
 *
 * @author Henry
 */
public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;
    
    @Override
    public String toString(){
        switch(this){
            case PLUS:
                return("+");
            case MINUS:
                return("-");
            case MULTIPLY:
                return("*");
            case DIVIDE:
                return("/");
            default:
                return("");
        }
    }
}
