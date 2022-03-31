package com.hjp.simplecalculator;

public interface UserIO {

    void print(String message);
    
    void print(double number);

    int readInt(String prompt);

    double readDouble(String prompt);

}