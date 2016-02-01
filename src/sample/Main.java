package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.BLACK);
        primaryStage.setTitle("Solar System");
        primaryStage.setScene(scene);
        Group circles = new Group();
        Circle aCircle = new Circle(300, 300, 50, Color.YELLOW);
        aCircle.setStroke(Color.web("yellow", 0.3));
        aCircle.setStrokeWidth(10);
        circles.getChildren().add(aCircle);
        for (int i = 0; i < 3; i++) {
            Circle circle = new Circle(10, Color.BLUE);
            circle.setStroke(Color.web("blue", 0.3));
            circle.setStrokeWidth(2);
            circles.getChildren().add(circle);
        }
        root.getChildren().add(circles);


        Timeline timeline = new Timeline();
        for (int i = 0; i < circles.getChildren().size() - 1; i++) {
            Node circle = circles.getChildren().get(i + 1);
            double r = (i + 2) * 50;
            timeline.rateProperty().set(10.0);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(circle.translateXProperty(), 300),
                            new KeyValue(circle.translateYProperty(), 300 - r)
                    )
            );
            for (int j = 0; j < 360; j++) {
                double degree = (double) j;
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(degree),
                                new KeyValue(circle.translateXProperty(), 300 - sin(degree / 180 * PI) * r),
                                new KeyValue(circle.translateYProperty(), 300 - cos(degree / 180 * PI) * r)
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
