package com.hjp.shapes;

/**
 *
 * @author Henry Perrottet
 */
public class Rectangle extends Shape{
    private double area, perimeter;
    
    public Rectangle(double _length, double _width){
        this.area = _length*_width;
        this.perimeter = 2*_length + 2*_width;
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
