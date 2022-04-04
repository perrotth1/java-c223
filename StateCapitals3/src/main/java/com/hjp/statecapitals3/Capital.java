package com.hjp.statecapitals3;

/**
 *
 * @author Henry Perrottet
 */
public class Capital {
    private String name;
    private long population;
    private double sqMileage;
    
    public Capital(String _name, long _population, double _sqMileage){
        this.name = _name;
        this.population = _population;
        this.sqMileage = _sqMileage;
    }
    
    public String getName(){
        return this.name;
    }
    public long getPopulation(){
        return this.population;
    }
    public double getSqMileage(){
        return this.sqMileage;
    }
}
