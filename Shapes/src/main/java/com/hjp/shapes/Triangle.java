package com.hjp.shapes;

/**
 *
 * @author Henry Perrottet
 */
public class Triangle extends Shape{
    private double area, perimeter;
    
    public Triangle(double _baseLength, double _height){
        this.area = (_baseLength/2)*_height;
        
        double hypotenuse = Math.sqrt( Math.pow((_baseLength/2), 2) + Math.pow(_height, 2) );
        this.perimeter = 2*hypotenuse + _baseLength;
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
