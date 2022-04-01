package com.hjp.shapes;

/**
 *
 * @author Henry Perrottet
 */
public class Square extends Shape{
    private double area, perimeter;
    
    public Square(double _sideLength){
        this.area = _sideLength*_sideLength;
        this.perimeter = 4*_sideLength;
    }
    
    @Override
    public double getArea(){
        return this.area;
    }
    
    @Override
    public double getPerimeter(){
        return this.perimeter;
    }
}
