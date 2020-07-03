import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Main extends Application {

    boolean isConnected = false;
    boolean on;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        bp.setPrefHeight(675);
        bp.setPrefWidth(1200);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);

        ScrollPane list = new ScrollPane();
        list.setStyle("-fx-background-color: #2b2b2b");

        StackPane c = new StackPane();
        c.setStyle("-fx-background-color: #2b2b2b");
        list.setContent(c);
        list.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val){
                System.out.print("");
            }
        });
        list.setPrefSize(115, 150);
        list.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


        bp.setCenter(new GridPane());
        bp.setTop(new TopBar().makeMenu(bp, primaryStage));

        final File folder = new File("./ServerConfigs");
        ArrayList<String> str = listFilesForFolder(folder);
        for (String s: str) {
            System.out.println(s);
            String s2 = s.split("\\.")[0];
            s2 = s2.toUpperCase().replace("-0", "#");
            System.out.println(s2);
        }

        bp.setRight(new RightMenu().makeMenu(bp, primaryStage));

        Scene scn = new Scene(bp);
        primaryStage.setScene(scn);
        primaryStage.show();
    }

    public ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> files = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            try {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry);
                }
                else {
                    files.add(fileEntry.getName());
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return files;
    }
}
