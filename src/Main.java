import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
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
        Button disconnect = new Button("Disconnect");
        disconnect.setOnAction(e -> {
            try {
                Process di = Runtime.getRuntime().exec("protonvpn c -f");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        vb.getChildren().add(disconnect);
        bp.setCenter(vb);
        Scene scn = new Scene(bp);
        primaryStage.setScene(scn);
        primaryStage.show();
    }
}
