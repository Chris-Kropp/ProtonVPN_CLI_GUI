import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class RightMenu {
    boolean isConnected = false;
    public Pane makeDisconnectedMenu(BorderPane bp, Stage primaryStage) {
        Pane rightPane = new Pane();

        Button settingsTab = new Button("⚙");
        Tooltip settingsTooltip = new Tooltip("Change program settings");
        settingsTab.setTooltip(settingsTooltip);
        settingsTooltip.setShowDelay(Duration.millis(500));
        settingsTab.setScaleX(3);
        settingsTab.setScaleY(3);
        settingsTab.getStyleClass().set(0, "tabButton");
        settingsTab.setPadding(new Insets(0,2,-2,2));
        settingsTab.setTranslateX(170);
        settingsTab.setTranslateY(10);
        settingsTab.setOnMouseEntered(e -> {
            settingsTab.getStyleClass().set(0, "tabButtonOver");
        });
        settingsTab.setOnMouseExited(e -> {
            settingsTab.getStyleClass().set(0, "tabButton");
        });
        settingsTab.setOnMousePressed(e -> {
            settingsTab.getStyleClass().set(0, "tabButtonPreSelect");
            System.out.println("pressed");
        });
        settingsTab.setOnMouseReleased(e -> {
            settingsTab.getStyleClass().set(0, "tabButtonOver");
            try {
                launchOptions();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        Button fastestButton = new Button("Fastest");
        Tooltip fastestTooltip = new Tooltip("Connect to a fastest server");
        fastestButton.setTooltip(fastestTooltip);
        fastestTooltip.setShowDelay(Duration.millis(500));
        fastestButton.setScaleX(2);
        fastestButton.setScaleY(2);
//        if(isConnected){
            fastestButton.getStyleClass().set(0, "acceptButton");
//        }
//        else{
//            fastestButton.getStyleClass().set(0, "disabledButton");
//            fastestTooltip.setText("Cannot connect to a server");
//        }
        fastestButton.setPadding(new Insets(0,10,0,10));
        fastestButton.setTranslateY(50);
        fastestButton.translateXProperty().bind(rightPane.widthProperty().divide(2).subtract(40));
        fastestButton.setOnMouseEntered(e -> {
//            if(isConnected) {
                fastestButton.getStyleClass().set(0, "acceptButtonOver");
//            }
//            else{
//                fastestButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        fastestButton.setOnMouseExited(e -> {
//            if(isConnected) {
                fastestButton.getStyleClass().set(0, "acceptButton");
//            }
//            else{
//                fastestButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        fastestButton.setOnMousePressed(e -> {
//            if(isConnected) {
                fastestButton.getStyleClass().set(0, "acceptButtonPreSelect");
                System.out.println("pressed");
//            }
//            else{
//                fastestButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        fastestButton.setOnMouseReleased(e -> {
//            if(isConnected) {
                fastestButton.getStyleClass().set(0, "acceptButtonOver");
                System.out.println("Released");
                try {
                    Process fa = Runtime.getRuntime().exec("protonvpn f");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
//            }
//            else{
//                fastestButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        fastestButton.setAlignment(Pos.CENTER);



        Button randomButton = new Button("Random");
        Tooltip randomTooltip = new Tooltip("Connect to a random server");
        randomButton.setTooltip(randomTooltip);
        randomTooltip.setShowDelay(Duration.millis(500));
        randomButton.setScaleX(2);
        randomButton.setScaleY(2);
//        if(isConnected){
            randomButton.getStyleClass().set(0, "acceptButton");
//        }
//        else{
//            randomButton.getStyleClass().set(0, "disabledButton");
//            randomTooltip.setText("Cannot connect to a server");
//        }
        randomButton.setPadding(new Insets(0,10,0,10));
        randomButton.setTranslateY(100);
        randomButton.translateXProperty().bind(rightPane.widthProperty().divide(2).subtract(40));
        randomButton.setOnMouseEntered(e -> {
//            if(isConnected) {
                randomButton.getStyleClass().set(0, "acceptButtonOver");
//            }
//            else{
//                randomButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        randomButton.setOnMouseExited(e -> {
//            if(isConnected) {
                randomButton.getStyleClass().set(0, "acceptButton");
//            }
//            else{
//                randomButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        randomButton.setOnMousePressed(e -> {
//            if(isConnected) {
                randomButton.getStyleClass().set(0, "acceptButtonPreSelect");
                System.out.println("pressed");
//            }
//            else{
//                randomButton.getStyleClass().set(0, "disabledButton");
//            }
        });
        randomButton.setOnMouseReleased(e -> {
//            if(isConnected) {
                randomButton.getStyleClass().set(0, "acceptButtonOver");
                System.out.println("Released");
                try {
                    Process fa = Runtime.getRuntime().exec("protonvpn r");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
//            }
//            else{
//                randomButton.getStyleClass().set(0, "disabledButton");
//            }
        });


        Button disconnectButton = new Button("Disconnect");
        Tooltip disconnectTooltip = new Tooltip("Disconnect from the current server");
        disconnectButton.setTooltip(disconnectTooltip);
        disconnectTooltip.setShowDelay(Duration.millis(500));
        disconnectButton.setScaleX(2);
        disconnectButton.setScaleY(2);
        if(isConnected){
            disconnectButton.getStyleClass().set(0, "cancelButton");
        }
        else{
            disconnectButton.getStyleClass().set(0, "disabledButton");
            disconnectTooltip.setText("You are not currently connected to a server");
        }
        disconnectButton.setPadding(new Insets(0,10,0,10));
        disconnectButton.translateYProperty().bind(rightPane.heightProperty().subtract(50));
        disconnectButton.translateXProperty().bind(rightPane.widthProperty().divide(2).subtract(40));
        disconnectButton.setOnMouseEntered(e -> {
            if(isConnected) {
                disconnectButton.getStyleClass().set(0, "cancelButtonOver");
            }
            else{
                disconnectButton.getStyleClass().set(0, "disabledButton");
            }
        });
        disconnectButton.setOnMouseExited(e -> {
            if(isConnected) {
                disconnectButton.getStyleClass().set(0, "cancelButton");
            }
            else{
                disconnectButton.getStyleClass().set(0, "disabledButton");
            }
        });
        disconnectButton.setOnMousePressed(e -> {
            if(isConnected) {
                disconnectButton.getStyleClass().set(0, "cancelButtonPreSelect");
                System.out.println("pressed");
            }
            else{
                disconnectButton.getStyleClass().set(0, "disabledButton");
            }
        });
        disconnectButton.setOnMouseReleased(e -> {
            if(isConnected) {
                disconnectButton.getStyleClass().set(0, "cancelButtonOver");
                System.out.println("Released");
                try {
                    Process fa = Runtime.getRuntime().exec("protonvpn d");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else{
                disconnectButton.getStyleClass().set(0, "disabledButton");
            }
        });


        Line sideLine = new Line(0, -30, 0, 0);
        sideLine.setStrokeWidth(2);
        sideLine.setFill(Color.rgb(184, 184, 184));
        sideLine.setStroke(Color.rgb(184, 184, 184));
        sideLine.endYProperty().bind(rightPane.heightProperty().add(20));


        rightPane.getChildren().addAll(settingsTab, fastestButton, randomButton, disconnectButton, sideLine);
        rightPane.getStylesheets().add("Styles.css");
        rightPane.setStyle("-fx-background-color: #2b2b2b");
        rightPane.setMinWidth(200);

        return rightPane;
    }

    void launchOptions() throws IOException {
        new SettingsPage().makeSettings();
    }
}
