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
//        VBox root = new VBox();
//        root.getChildren().addAll(new Button("button1"), new Button("button2"), new Button("button3"));
//        root.setSpacing(10);
//        root.setPadding(new Insets(10));
//        ScrollPane sp = new ScrollPane();
//        sp.setContent(root);
//        sp.setPannable(true); // it means that the user should be able to pan the viewport by using the mouse.
//        Scene scene = new Scene(sp, 100, 100);
//        stage.setScene(scene);
//        stage.show();


        bp.setCenter(new GridPane());
        bp.setTop(new TopBar().makeTopBar());

//        Button random = new Button("Connect to random server");
//        random.setOnAction(e -> {
//            try {
//                Process ra = Runtime.getRuntime().exec("protonvpn c -r");
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//        rightPane.getChildren().add(random);
//        Button fastest = new Button("Connect to fastest server");
//        fastest.setOnAction(e -> {
//            try {
//                Process fa = Runtime.getRuntime().exec("protonvpn c -f");
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//        rightPane.getChildren().add(fastest);

        final File folder = new File("./ServerConfigs");
        ArrayList<String> str = listFilesForFolder(folder);
        for (String s: str) {
            System.out.println(s);
            String s2 = s.split("\\.")[0];
            s2 = s2.toUpperCase().replace("-0", "#");
            System.out.println(s2);
        }

//
//        Pane rp = new Pane();
//
//
//        HBox hb = new HBox();
//        StackPane sp = new StackPane();
//
//        on = false;
//        Text text = new Text("Kill Switch:  ");
//        Text endText = new Text(" ");
//
//        Circle statusCircle = new Circle(9,Color.INDIANRED);
//        statusCircle.setTranslateX(-10);
//        statusCircle.setTranslateY(-.25);
//
//        Rectangle controller = new Rectangle(40, 20, Color.TRANSPARENT);
//
//        Line pathToOn = new Line(0,0,20,0);
//        pathToOn.setFill(Color.TRANSPARENT);
//        pathToOn.setOpacity(0);
//        pathToOn.setTranslateX(-20);
//        pathToOn.setTranslateY(-10.25);
//        Line pathToOff = new Line(20,0,0,0);
//        pathToOff.setFill(Color.TRANSPARENT);
//        pathToOff.setOpacity(0);
//        pathToOff.setTranslateX(-20);
//        pathToOff.setTranslateY(-10.25);
//
//        Rectangle killSwitchRect_Wide = new Rectangle(40, 20, Color.GREY);
//        controller.setOnMouseClicked(e -> {
//            if(!on){
//                this.on = true;
//                PathTransition pt = new PathTransition();
//                pt.setDuration(Duration.millis(25));
//                pt.setPath(pathToOn);
//                pt.setNode(statusCircle);
//                pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//                pt.setCycleCount(1);
//                pt.setAutoReverse(true);
//                pt.play(); // Start animation
//                statusCircle.setFill(Color.FORESTGREEN);
//                System.out.println("on");
//            }
//            else{
//                this.on = false;
//                PathTransition pt = new PathTransition();
//                pt.setDuration(Duration.millis(25));
//                pt.setPath(pathToOff);
//                pt.setNode(statusCircle);
//                pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//                pt.setCycleCount(1);
//                pt.setAutoReverse(true);
//                pt.play(); // Start animation
//                statusCircle.setFill(Color.INDIANRED);
//            }
//        });
//        Rectangle killSwitchRectInt_Wide = new Rectangle(35, 15, Color.LIGHTGREY);
//        killSwitchRectInt_Wide.setTranslateY(-.5);
//        killSwitchRectInt_Wide.setTranslateX(-.5);
//        killSwitchRect_Wide.setArcWidth(20);
//        killSwitchRectInt_Wide.setArcWidth(17);
//        killSwitchRect_Wide.setArcHeight(20);
//        killSwitchRectInt_Wide.setArcHeight(20);
//
//        sp.getChildren().addAll(killSwitchRect_Wide, pathToOff, pathToOn, killSwitchRectInt_Wide, statusCircle, controller);
//        hb.getChildren().addAll(text, sp, endText);
//        bp.getCenter().setStyle("-fx-background-color: #2b2b2b");
//
//        hb.setScaleX(4);
//        hb.setScaleY(4);
//
//        hb.setTranslateX(-400);
//        hb.setTranslateY(100);
//        rp.getChildren().add(hb);
//
//
//
//
//
//        HBox hb2 = new HBox();
//
//        Text text2 = new Text("Kill Switch:  ");
//        Text endText2 = new Text(" ");
//
//        StackPane sp2 = new StackPane();
//
//        Rectangle controller2 = new Rectangle(20, 20, Color.TRANSPARENT);
//        Rectangle outerBox = new Rectangle(20,20, Color.rgb(240,240,240));
//        outerBox.setArcWidth(5);
//        outerBox.setArcHeight(5);
//        Rectangle innerBox = new Rectangle(15,15, Color.rgb(43, 43, 43));
//        innerBox.setArcWidth(5);
//        innerBox.setArcHeight(5);
//        innerBox.setTranslateY(-.5);
//        innerBox.setTranslateX(-.5);
//        Rectangle indicatorBox = new Rectangle(12,12, Color.TRANSPARENT);
//        indicatorBox.setArcWidth(5);
//        indicatorBox.setArcHeight(5);
//
//        controller2.setOnMouseClicked(e -> {
//            if(!on){
//                this.on = true;
//                indicatorBox.setFill(Color.rgb(240, 240, 240));
//            }
//            else{
//                this.on = false;
//                indicatorBox.setFill(Color.TRANSPARENT);
//            }
//        });
//
//        sp2.getChildren().addAll(outerBox, innerBox, indicatorBox, controller2);
//        hb2.getChildren().addAll(text2, sp2, endText2);
//        hb2.setTranslateX(-400);
//        hb2.setTranslateY(200);
//        hb2.setScaleX(4);
//        hb2.setScaleY(4);
//
//        rp.getChildren().add(hb2);
//
//        bp.setRight(rp);

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
