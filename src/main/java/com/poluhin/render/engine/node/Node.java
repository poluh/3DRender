package com.poluhin.render.engine.node;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private Set<Point> points;
    private Point rotationCenter;
    private double depth;

    public Node() {
        points = new HashSet<>();
    }

    public Node(Set<Point> points) {
        this.points = points;
        depth = 0;
        rotationCenter = getRotationCenter();
    }

    public Node(Set<Point> points, double depth) {
        this.points = points;
        this.depth = depth;
        rotationCenter = getRotationCenter();
    }

    public Node(Set<Point> points, Point rotationCenter, double depth) {
        this.points = points;
        this.rotationCenter = rotationCenter;
        this.depth = depth;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Point getRotationCenter() {
        if (rotationCenter == null) {
            var x = points.stream().map(Point::getX).mapToInt(Integer::new).sum() / points.size();
            var y = points.stream().map(Point::getY).mapToInt(Integer::new).sum() / points.size();
            var z = points.stream().map(Point::getZ).mapToInt(Integer::new).sum() / points.size();
            return new Point(x, y, z);
        }
        return rotationCenter;
    }

    public void setRotationCenter(Point rotationCenter) {
        this.rotationCenter = rotationCenter;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
