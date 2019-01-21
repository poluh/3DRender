package com.poluhin.render;

import com.poluhin.render.engine.Engine;
import com.poluhin.render.engine.node.Node;
import com.poluhin.render.parser.Parser;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Demo extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        var rectangle = Parser.parse("/home/sergey/Desktop/Deep2D/resources/woman");


        var group = new Group();
        var scene = new Scene(group, 1000, 1000);
        var canvas = new Canvas(1000, 1000);
        var gc = canvas.getGraphicsContext2D();

        group.getChildren().add(canvas);
        stage.setScene(scene);

        paint(Engine.get2DProjection(rectangle, 20, 0, 0), gc);


        canvas.setOnMouseDragged(mouseEvent -> {
            gc.clearRect(0, 0, 1000, 1000);
            paint(Engine.get2DProjection(rectangle, 10, mouseEvent.getX(), mouseEvent.getY()), gc);
        });



        stage.show();
    }

    private void paint(Node node, GraphicsContext gc) {

        node.getPoints().forEach(point -> {
            var v = 1 / (1 + Math.exp(-2 * point.getZ()));
            gc.setFill(new Color(0, 0, 0, v));
            gc.fillOval(point.getX(), point.getY(), 1, 1);
        });
    }

}
