package com.yao.chapter15_AbstractFactory.example;

/**
 * Created by shanyao on 2018/5/28.
 */
public class ShapeFactory extends AbstractFactory {
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
