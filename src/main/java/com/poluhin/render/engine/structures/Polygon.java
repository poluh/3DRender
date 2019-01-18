package com.poluhin.render.engine.structures;

public class Polygon {

    private Point first;
    private Point second;
    private Point third;
    private Color color;

    public Polygon(Point first, Point second, Point third, Color color) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.color = color;
    }

    public Polygon(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.color = Color.WHITE;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getThird() {
        return third;
    }

    public void setThird(Point third) {
        this.third = third;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
