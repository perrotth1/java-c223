package com.hjp.shapes;

/**
 *
 * @author Henry Perrottet
 */
public class Circle extends Shape{
    private final double area, perimeter;
    
    public Circle(double _radius){
        this.area = Math.PI * Math.pow(_radius, 2);
        this.perimeter = 2 * Math.PI * _radius;
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
