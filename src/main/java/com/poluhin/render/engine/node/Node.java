package com.poluhin.render.engine.node;

import java.util.HashSet;
import java.util.Objects;
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
            var x = points.stream().map(Point::getX).mapToDouble(Double::new).sum() / points.size();
            var y = points.stream().map(Point::getY).mapToDouble(Double::new).sum() / points.size();
            var z = points.stream().map(Point::getZ).mapToDouble(Double::new).sum() / points.size();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Double.compare(node.depth, depth) == 0 &&
                Objects.equals(points, node.points) &&
                Objects.equals(rotationCenter, node.rotationCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, rotationCenter, depth);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
