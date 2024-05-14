package Lecture1;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @Test
    public void circleTest(){
        Circle circle = new Circle();
        Assert.assertEquals("314.16",String.format("%.2f",circle.area()));
        Assert.assertEquals("Circle with radius 10.0 has a area of 314.16", circle.getDescription());
    }

    @Test
    public void rectangleTest(){
        Rectangle rectangle = new Rectangle();
        Assert.assertEquals(50, rectangle.area(), 0.0);
        Assert.assertEquals("Rectangle with a length 5.0 and width 10.0 has a area of 50.0", rectangle.getDescription());
    }
}