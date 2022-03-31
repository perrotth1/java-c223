package com.hjp.classexample;

/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args){
        MyClass class1 = new MyClass("Orange");
        
        class1.setColor("Blood Orange");
        
        System.out.println(class1.getColor());
    }
}
