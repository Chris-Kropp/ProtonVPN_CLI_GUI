import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class TopBar {

    boolean serverSelected = true;
    double x, y;

    public Pane makeMenu(BorderPane bp, Stage primaryStage) {
        Pane topPane = new Pane();

        Button settingsTab = new Button("Settings");
        Button serverTab = new Button("Servers");
        Tooltip serverTooltip = new Tooltip("Connect to a server server");
        serverTab.setTooltip(serverTooltip);
        serverTooltip.setShowDelay(Duration.millis(500));
        serverTab.setScaleX(1.5);
        serverTab.setScaleY(1.5);
        if(serverSelected){
            serverTab.getStyleClass().set(0, "tabButtonSelected");
        }
        else{
            serverTab.getStyleClass().set(0, "tabButton");
        }
        serverTab.setPadding(new Insets(0,10,0,10));
        serverTab.setTranslateX(15);
        serverTab.setTranslateY(5);
        serverTab.setOnMouseEntered(e -> {
            if(!serverSelected) {
                serverTab.getStyleClass().set(0, "tabButtonOver");
            }
            else{
                serverTab.getStyleClass().set(0, "tabButtonOverSelected");
            }
        });
        serverTab.setOnMouseExited(e -> {
            if(!serverSelected){
                serverTab.getStyleClass().set(0, "tabButton");
            }
            else{
                serverTab.getStyleClass().set(0, "tabButtonSelected");
            }
        });
        serverTab.setOnMousePressed(e -> {
            serverTab.getStyleClass().set(0, "tabButtonPreSelect");
            System.out.println("pressed");
        });
        serverTab.setOnMouseReleased(e -> {
            if(!serverSelected) {
                serverTab.getStyleClass().set(0, "tabButtonOverSelected");
                System.out.println("Released");
                try {
                    Process fa = Runtime.getRuntime().exec("protonvpn r");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                serverSelected = true;
                settingsTab.getStyleClass().set(0, "tabButton");
            }
        });



        Tooltip settingsTooltip = new Tooltip("Connect to a settings server");
        settingsTab.setTooltip(settingsTooltip);
        settingsTooltip.setShowDelay(Duration.millis(500));
        settingsTab.setScaleX(1.5);
        settingsTab.setScaleY(1.5);
        if(serverSelected){
            settingsTab.getStyleClass().set(0, "tabButton");
        }
        else{
            settingsTab.getStyleClass().set(0, "tabButtonSelected");
        }
        settingsTab.setPadding(new Insets(0,10,0,10));
        settingsTab.setTranslateX(107);
        settingsTab.setTranslateY(5);
        settingsTab.setOnMouseEntered(e -> {
            if(serverSelected) {
                settingsTab.getStyleClass().set(0, "tabButtonOver");
            }
            else{
                settingsTab.getStyleClass().set(0, "tabButtonOverSelected");
            }
        });
        settingsTab.setOnMouseExited(e -> {
            if(serverSelected){
                settingsTab.getStyleClass().set(0, "tabButton");
            }
            else{
                settingsTab.getStyleClass().set(0, "tabButtonSelected");
            }
        });
        settingsTab.setOnMousePressed(e -> {
            settingsTab.getStyleClass().set(0, "tabButtonPreSelect");
            System.out.println("pressed");
        });
        settingsTab.setOnMouseReleased(e -> {
            if(serverSelected) {
                settingsTab.getStyleClass().set(0, "tabButtonOverSelected");
                System.out.println("Released");
                try {
                    Process fa = Runtime.getRuntime().exec("protonvpn r");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                serverSelected = false;
                serverTab.getStyleClass().set(0, "tabButton");
            }
        });

        Line bottomLine = new Line(0, 28, 0, 28);
        bottomLine.setStrokeWidth(2);
        bottomLine.setFill(Color.rgb(184, 184, 184));
        bottomLine.setStroke(Color.rgb(184, 184, 184));
        bottomLine.endXProperty().bind(topPane.widthProperty().subtract(200));
        topPane.getStylesheets().add("Styles.css");
        topPane.setStyle("-fx-background-color: #2b2b2b");
        topPane.setMinHeight(30);


//        Rectangle dragBox = new Rectangle(30, 30, Color.RED);
//        dragBox.setTranslateX(300);
//        dragBox.setOnMouseClicked(this::dragClicked);
//
//        dragBox.setOnMouseDragged(e -> {
//            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//            stage.setX(e.getScreenX()-x);
//            stage.setY(e.getScreenY()-y);
//        });
//
//
        topPane.getChildren().addAll(serverTab, settingsTab, bottomLine);
        return topPane;
    }

//    void dragClicked(MouseEvent event){
//        x = event.getSceneX();
//        y = event.getSceneY();
//    }
}
