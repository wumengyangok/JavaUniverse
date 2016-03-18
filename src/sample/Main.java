package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.*;
/*
* Demo of a solar system */
public class Main extends Application {
    private ExampleStar sun;
    private Scene scene;
    private Group root;

    private void initializeSolarSystem() {
        //      Modify the following line of code, and feel free to add some planets to the system.
        sun = new ExampleStar("Sun", 50, 0.0, 0, "yellow");
        sun.addMoon(new ExampleStar("Mercury", 5, 88, 74, "gray"));
        sun.addMoon(new ExampleStar("Venus", 6, 225, 107, "orange"));
        sun.addMoon(new ExampleStar("Earth", 8, 365, 140, "blue"));
        sun.addMoon(new ExampleStar("Mars", 5, 687, 205, "red"));
    }

    private void draw() {
        initializeSolarSystem();
        root.getChildren().remove(0);
        Group circles = new Group();
        Circle aCircle = new Circle(300, 300, sun.getRadius(), Color.web(sun.getColor(), 1.0));
        aCircle.setStroke(Color.web(sun.getColor(), 0.3));
        aCircle.setStrokeWidth(10);
        circles.getChildren().add(aCircle);

        for (int i = 0; i < sun.getMoons().size(); i++) {
            Circle circle = new Circle(sun.getMoons().get(i).getRadius(), Color.web(sun.getMoons().get(i).getColor(), 1.0));
            circles.getChildren().add(circle);
        }
        root.getChildren().add(circles);

        Timeline timeline = new Timeline();
        for (int i = 0; i < circles.getChildren().size() - 1; i++) {
            Circle circle = (Circle) circles.getChildren().get(i + 1);
            Circle center = (Circle) circles.getChildren().get(0);
            double r = sun.getMoons().get(i).getOrbitRadius();
            timeline.rateProperty().set(10.0);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(circle.translateXProperty(), center.getCenterX()),
                            new KeyValue(circle.translateYProperty(), center.getCenterY() - r)
                    )
            );
            for (int j = 0; j < 1080; j++) {
                double degree = (double) j;
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(j),
                                new KeyValue(circle.translateXProperty(), center.getCenterX() - sin(degree / 180 * PI / sun.getMoons().get(i).getLengthOfYear() * 360.0) * r),
                                new KeyValue(circle.translateYProperty(), center.getCenterY() - cos(degree / 180 * PI / sun.getMoons().get(i).getLengthOfYear() * 360.0) * r)
                        )
                );
            }
        }
        timeline.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new Group();
        scene = new Scene(root, 600, 600, Color.BLACK);
        Button btn = new Button();
        btn.setText("See your solar system!");
        btn.setMinSize(100, 100);
        btn.setLayoutX(180);
        btn.setLayoutY(300);
        btn.setFont(Font.font ("Verdana", 20));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                draw();
            }
        });
        root.getChildren().add(btn);
        primaryStage.setTitle("Solar System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
