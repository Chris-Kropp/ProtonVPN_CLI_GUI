import javafx.scene.Cursor;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RightMenu {
    boolean isConnected = false;
    public Pane makeMenu(BorderPane bp, Stage primaryStage) {
        Pane rightPane = new Pane();
        StackPane fastestButton = new StackPane();
        Rectangle fastestWidthController = new Rectangle(250, 50, Color.TRANSPARENT);
        Rectangle fastestBorderBox = new Rectangle(240, 50, Color.GREEN);
        fastestBorderBox.setArcHeight(100);
        fastestBorderBox.setArcWidth(50);
        Rectangle fastestMainBox = new Rectangle(235, 45, Color.TRANSPARENT);
        fastestMainBox.setArcHeight(100);
        fastestMainBox.setArcWidth(50);
        Rectangle fastestMainBoxBG = new Rectangle(235, 45, Color.rgb(43,43,43));
        fastestMainBoxBG.setArcHeight(100);
        fastestMainBoxBG.setArcWidth(50);
        Text fastestText = new Text("Random Connection");
        fastestText.setFill(Color.GREEN);
        fastestText.setScaleX(1.9);
        fastestText.setScaleY(1.9);
        Rectangle fastestEventRectangle = new Rectangle(200, 50, Color.TRANSPARENT);
        fastestEventRectangle.setArcHeight(100);
        fastestEventRectangle.setArcWidth(50);
        fastestEventRectangle.setOnMouseEntered(e -> {
            fastestMainBox.setFill(Color.rgb(0, 200, 0, 0.75));
            fastestText.setFill(Color.BLACK);
            primaryStage.getScene().setCursor(Cursor.HAND);
        });
        fastestEventRectangle.setOnMouseExited(e -> {
            fastestMainBox.setFill(Color.rgb(0, 200, 0, 0));
            fastestText.setFill(Color.GREEN);
            primaryStage.getScene().setCursor(Cursor.DEFAULT);
        });
        fastestEventRectangle.setOnMousePressed(e -> fastestMainBox.setFill(Color.rgb(0, 200, 0, 0.85)));
        fastestEventRectangle.setOnMouseReleased(e -> {
            try {
                Process fa = Runtime.getRuntime().exec("protonvpn d");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        fastestButton.getChildren().addAll(fastestWidthController, fastestBorderBox, fastestMainBoxBG, fastestMainBox, fastestText, fastestEventRectangle);
        fastestButton.setTranslateY(25);
        fastestButton.setStyle("-fx-background-color: #2b2b2b");


        StackPane disconnectButton = new StackPane();
        Rectangle disconnectWidthController = new Rectangle(250, 50, Color.TRANSPARENT);
        Rectangle disconnectBorderBox = new Rectangle(200, 50, Color.DIMGREY);
        disconnectBorderBox.setArcHeight(100);
        disconnectBorderBox.setArcWidth(50);
        Rectangle disconnectMainBox = new Rectangle(195, 45, Color.TRANSPARENT);
        disconnectMainBox.setArcHeight(100);
        disconnectMainBox.setArcWidth(50);
        Rectangle disconnectMainBoxBG = new Rectangle(195, 45, Color.rgb(43,43,43));
        disconnectMainBoxBG.setArcHeight(100);
        disconnectMainBoxBG.setArcWidth(50);
        Text disconnectText = new Text("Disconnect");
        disconnectText.setFill(Color.DIMGREY);
        disconnectText.setScaleX(2);
        disconnectText.setScaleY(2);
        Rectangle disconnectEventRectangle = new Rectangle(200, 50, Color.TRANSPARENT);
        disconnectEventRectangle.setArcHeight(100);
        disconnectEventRectangle.setArcWidth(50);
        disconnectEventRectangle.setOnMouseEntered(e -> {
            if(isConnected){
                disconnectMainBox.setFill(Color.rgb(255, 0, 0, 0.75));
                disconnectText.setFill(Color.WHITE);
                primaryStage.getScene().setCursor(Cursor.HAND);
            }
        });
        disconnectEventRectangle.setOnMouseExited(e -> {
            if(isConnected) {
                disconnectMainBox.setFill(Color.rgb(255, 0, 0, 0));
                disconnectText.setFill(Color.RED);
                primaryStage.getScene().setCursor(Cursor.DEFAULT);
            }
        });
        disconnectEventRectangle.setOnMousePressed(e -> {
            if(isConnected) {
                disconnectMainBox.setFill(Color.rgb(255, 0, 0, 0.85));
            }
        });
        disconnectEventRectangle.setOnMouseReleased(e -> {
            if(isConnected) {
                try {
                    Process fa = Runtime.getRuntime().exec("protonvpn d");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        disconnectButton.getChildren().addAll(disconnectWidthController, disconnectBorderBox, disconnectMainBoxBG, disconnectMainBox, disconnectText, disconnectEventRectangle);
        disconnectButton.translateYProperty().bind(bp.heightProperty().subtract(75));
        disconnectButton.setStyle("-fx-background-color: #2b2b2b");


        rightPane.getChildren().addAll(fastestButton, disconnectButton);
        rightPane.setStyle("-fx-background-color: #2b2b2b");

        return rightPane;
    }
}
