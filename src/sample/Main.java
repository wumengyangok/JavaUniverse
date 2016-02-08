package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.*;

public class Main extends Application {
    private ExampleStar sun;
    @Override
    public void start(Stage primaryStage) throws Exception{

        sun = new ExampleStar("Sun", 50, 64, 0.0, 0);
        sun.addMoon(new ExampleStar("Earth", 10, 64, 365, 100));
        sun.addMoon(new ExampleStar("Mars", 5, 64, 450, 150));

        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.BLACK);
        primaryStage.setTitle("Solar System");
        primaryStage.setScene(scene);
        Group circles = new Group();

        Circle aCircle = new Circle(300, 300, sun.getRadius(), Color.YELLOW);
        aCircle.setStroke(Color.web("yellow", 0.3));
        aCircle.setStrokeWidth(10);
        circles.getChildren().add(aCircle);

        for (int i = 0; i < sun.getMoons().size(); i++) {
            Circle circle = new Circle(10, Color.BLUE);
            circle.setStroke(Color.web("blue", 0.3));
            circle.setStrokeWidth(2);
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
            for (int j = 0; j < 360; j++) {
                double degree = (double) j;
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(sun.getMoons().get(i).getLengthOfYear() / 360 * degree),
                                new KeyValue(circle.translateXProperty(), center.getCenterX() - sin(degree / 180 * PI) * r),
                                new KeyValue(circle.translateYProperty(), center.getCenterY() - cos(degree / 180 * PI) * r)
                        )
                );
            }
        }
        timeline.play();

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
