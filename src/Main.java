import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        ScrollPane list = new ScrollPane();
        VBox vb = new VBox();
        Button random = new Button("Connect to random server");
        random.setOnAction(e -> {
            try {
                Process ra = Runtime.getRuntime().exec("protonvpn c -r");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        vb.getChildren().add(random);
        Button fastest = new Button("Connect to fastest server");
        fastest.setOnAction(e -> {
            try {
                Process fa = Runtime.getRuntime().exec("protonvpn c -f");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        vb.getChildren().add(fastest);




        StackPane sp = new StackPane();
        Rectangle borderBox = new Rectangle(200, 50, Color.RED);
        Rectangle mainBox = new Rectangle(195, 45, Color.rgb(255, 0, 0, 0));
        Rectangle mainBoxBG = new Rectangle(195, 45, Color.rgb(69,69,69));
        Text text = new Text("Disconnect");
        text.setFill(Color.RED);
        text.setScaleX(2);
        text.setScaleY(2);
        Rectangle eventRectangle = new Rectangle(200, 50, Color.TRANSPARENT);
        eventRectangle.setOnMouseExited(e -> {
            mainBox.setFill(Color.rgb(255, 0, 0, 0));
            text.setFill(Color.RED);
        });;
        eventRectangle.setOnMouseEntered(e -> {
            mainBox.setFill(Color.rgb(255, 0, 0, 0.75));
            text.setFill(Color.WHITE);
        });
        eventRectangle.setOnMousePressed(e -> mainBox.setFill(Color.rgb(255, 0, 0, 0.85)));
        eventRectangle.setOnMouseReleased(e -> {
            try {
                Process fa = Runtime.getRuntime().exec("protonvpn d");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        sp.getChildren().addAll(borderBox, mainBoxBG, mainBox, text, eventRectangle);
        sp.setStyle("-fx-background-color: #454545");
        vb.getChildren().add(sp);
        vb.setStyle("-fx-background-color: #454545");
        bp.setRight(vb);

        bp.setCenter(list);
        Scene scn = new Scene(bp);
        primaryStage.setScene(scn);
        primaryStage.show();
    }
}
