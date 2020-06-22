import javafx.scene.Cursor;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;

public class TopBar {
    Pane makeTopBar() {
        Pane hb = new Pane();

        StackPane servers = new StackPane();
        Rectangle serversSelectBG = new Rectangle(50, 20, Color.rgb(45, 45, 45));
        Rectangle serversSelect = new Rectangle(50, 20, Color.TRANSPARENT);
        Text serverText = new Text("Servers");
        serverText.setFill(Color.SLATEGREY);
        serversSelect.setOnMouseEntered(e -> {
//            if(isConnected){
                serversSelectBG.setFill(Color.rgb(75, 75, 75));
//                primaryStage.getScene().setCursor(Cursor.HAND);
//            }
        });
        serversSelect.setOnMouseExited(e -> {
//            if(isConnected) {
                serversSelectBG.setFill(Color.rgb(45, 45, 45));
//                primaryStage.getScene().setCursor(Cursor.DEFAULT);
//            }
        });
        serversSelect.setOnMousePressed(e -> {
//            if(isConnected) {
                serversSelectBG.setFill(Color.rgb(100, 100, 100));
//            }
        });
        serversSelect.setOnMouseReleased(e -> {
//            if(isConnected) {
//                try {
            System.out.println("mouse released");
            serverText.setFill(Color.WHITE);
//                    Process fa = Runtime.getRuntime().exec("protonvpn d");
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
        });




        StackPane settings = new StackPane();


        servers.getChildren().addAll(serversSelectBG, serverText, serversSelect);
        servers.setScaleX(2);
        servers.setScaleY(2);
        servers.setTranslateX(25);
        servers.setTranslateY(10);

        Rectangle divider = new Rectangle(1, 40, Color.rgb(45, 45, 45));
        hb.getChildren().addAll(servers, divider);
        hb.setStyle("-fx-background-color: #2b2b2b");
//        hb.setScaleX(2);
//        hb.setScaleY(2);
        return hb;
    }
}
