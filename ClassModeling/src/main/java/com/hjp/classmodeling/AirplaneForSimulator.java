package com.hjp.classmodeling;

/**
 *
 * @author Henry Perrottet
 */
public class AirplaneForSimulator {
    private double altitude, speed, fuelLevel;
    
    public AirplaneForSimulator(){
        fuelLevel = 100;
        speed = 0;
        altitude = 0;
    }
    
    public void initiateTakeoff(){
        //start takeoff
    }
    
    public void crashAndBurn(){
        //plane explodes
    }
}
