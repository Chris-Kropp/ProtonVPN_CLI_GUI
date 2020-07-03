import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class TopBar {
    public Pane makeMenu(BorderPane bp, Stage primaryStage) {
        Pane topPane = new Pane();
        Button serverTab = new Button("Servers");
        Tooltip serverTooltip = new Tooltip("Connect to a server server");
        serverTab.setTooltip(serverTooltip);
        serverTooltip.setShowDelay(Duration.millis(500));
        serverTab.setScaleX(2);
        serverTab.setScaleY(2);
//        if(isConnected){
        serverTab.getStyleClass().set(0, "acceptButton");
//        }
//        else{
//            serverTab.getStyleClass().set(0, "disabledTab");
//            serverTooltip.setText("Cannot connect to a server");
//        }
        serverTab.setPadding(new Insets(0,10,0,10));
        serverTab.setTranslateY(30);
//        serverTab.translateXProperty().bind(rightPane.widthProperty().divide(2).subtract(40));
        serverTab.setOnMouseEntered(e -> {
//            if(isConnected) {
            serverTab.getStyleClass().set(0, "tabButtonOver");
//            }
//            else{
//                serverTab.getStyleClass().set(0, "disabledTab");
//            }
        });
        serverTab.setOnMouseExited(e -> {
//            if(isConnected) {
            serverTab.getStyleClass().set(0, "tabButton");
//            }
//            else{
//                serverTab.getStyleClass().set(0, "disabledTab");
//            }
        });
        serverTab.setOnMousePressed(e -> {
//            if(isConnected) {
            serverTab.getStyleClass().set(0, "tabButtonPreSelect");
            System.out.println("pressed");
//            }
//            else{
//                serverTab.getStyleClass().set(0, "disabledTab");
//            }
        });
        serverTab.setOnMouseReleased(e -> {
//            if(isConnected) {
            serverTab.getStyleClass().set(0, "tabButtonOver");
            System.out.println("Released");
            try {
                Process fa = Runtime.getRuntime().exec("protonvpn r");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            }
//            else{
//                serverTab.getStyleClass().set(0, "disabledTab");
//            }
        });


        Button settingsTab = new Button("Settings");
        Tooltip settingsTooltip = new Tooltip("Connect to a settings server");
        settingsTab.setTooltip(settingsTooltip);
        settingsTooltip.setShowDelay(Duration.millis(500));
        settingsTab.setScaleX(2);
        settingsTab.setScaleY(2);
//        if(isConnected){
        settingsTab.getStyleClass().set(0, "acceptButton");
//        }
//        else{
//            settingsTab.getStyleClass().set(0, "disabledTab");
//            settingsTooltip.setText("Cannot connect to a server");
//        }
        settingsTab.setPadding(new Insets(0,10,0,10));
        settingsTab.setTranslateY(30);
//        settingsTab.translateXProperty().bind(rightPane.widthProperty().divide(2).subtract(40));
        settingsTab.setOnMouseEntered(e -> {
//            if(isConnected) {
            settingsTab.getStyleClass().set(0, "tabButtonOver");
//            }
//            else{
//                settingsTab.getStyleClass().set(0, "disabledTab");
//            }
        });
        settingsTab.setOnMouseExited(e -> {
//            if(isConnected) {
            settingsTab.getStyleClass().set(0, "tabButton");
//            }
//            else{
//                settingsTab.getStyleClass().set(0, "disabledTab");
//            }
        });
        settingsTab.setOnMousePressed(e -> {
//            if(isConnected) {
            settingsTab.getStyleClass().set(0, "tabButtonPreSelect");
            System.out.println("pressed");
//            }
//            else{
//                settingsTab.getStyleClass().set(0, "disabledTab");
//            }
        });
        settingsTab.setOnMouseReleased(e -> {
//            if(isConnected) {
            settingsTab.getStyleClass().set(0, "tabButtonOver");
            System.out.println("Released");
            try {
                Process fa = Runtime.getRuntime().exec("protonvpn r");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            }
//            else{
//                settingsTab.getStyleClass().set(0, "disabledTab");
//            }
        });

//        serverTab.setTranslateX(20);
//        settingsTab.setTranslateX(120);


        topPane.getChildren().addAll(serverTab);
        topPane.getStylesheets().add("Styles.css");
        topPane.setStyle("-fx-background-color: #2b2b2b");
        topPane.setMinHeight(50);

        return topPane;
    }
}
