package com.poluhin.render.engine;

import com.poluhin.render.engine.node.Node;
import com.poluhin.render.engine.node.Point;

import java.util.stream.Collectors;

public class Engine {

    public static Node get2DProjection(Node node, double distanceToCamera, double cameraX, double cameraY) {
        return new Node(node
                .getPoints()
                .stream()
                .map(point -> {
                    var f = distanceToCamera / (double) point.getZ();
                            return new Point(point.getX() + cameraX, point.getY() + cameraY, point.getZ());
                        }
                )
                .collect(Collectors.toSet()), node.getRotationCenter(), node.getDepth());
    }

}
