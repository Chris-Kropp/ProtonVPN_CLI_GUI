import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        bp.setCenter(vb);
        Button random = new Button("Connect to random server");
        random.setOnAction(e -> {
            System.out.println("");
        });
        vb.getChildren().add(random);
        Scene scn = new Scene(bp);
        primaryStage.setScene(scn);
        primaryStage.show();
    }
}
