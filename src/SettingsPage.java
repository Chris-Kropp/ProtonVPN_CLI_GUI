import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsPage {
    void makeSettings(){//BorderPane bp, Stage primaryStage) {
//password, say to do it over the cli or website
        //plan  same
        //3. protocol: tcp or udp
        //4. dns management: enable dns leapk protection( reccomended, always use protonvpns servers), configure custom servers(allow multiple) (disable dns management)
        //5. Kill switch(block access to/from lan, enable access to/from lan, disable kill switch)
        //6. split tunneling
        //7. reset

        Stage settingsStage = new Stage();

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #2b2b2b");

        Text note = new Text("For security reasons, to change your password or update your plan, please visit the ProtonVPN website, then use the terminal to update");
        note.setFontSmoothingType(FontSmoothingType.LCD);
        note.setFill(Color.rgb(184, 184, 184));
        note.setWrappingWidth(360);
        note.setLayoutX(9);
        note.setLayoutY(27);


        ToggleGroup protocol = new ToggleGroup();
        RadioButton tcp = new RadioButton("TCP");
        tcp.setToggleGroup(protocol);
        tcp.setLayoutX(36);
        tcp.setLayoutY(96);
        tcp.setTextFill(Color.rgb(184, 184, 184));
        RadioButton udp = new RadioButton("UDP");
        udp.setToggleGroup(protocol);
        udp.setLayoutX(86);
        udp.setLayoutY(96);
        udp.setTextFill(Color.rgb(184, 184, 184));


        CheckBox dnsToggle = new CheckBox("Enable DNS Management");
        dnsToggle.setLayoutX(36);
        dnsToggle.setLayoutY(119);
        dnsToggle.setTextFill(Color.rgb(184, 184, 184));
        ToggleGroup dnsGroup = new ToggleGroup();
        RadioButton protonDNS = new RadioButton("Use ProtonVPN DNS (DNS Leak Protection)");
        protonDNS.setToggleGroup(dnsGroup);
        protonDNS.setLayoutX(56);
        protonDNS.setLayoutY(136);
        protonDNS.setTextFill(Color.rgb(184, 184, 184));
        RadioButton customDNS = new RadioButton("Use Custom DNS:");
        customDNS.setToggleGroup(dnsGroup);
        customDNS.setLayoutX(56);
        customDNS.setLayoutY(158);
        customDNS.setTextFill(Color.rgb(184, 184, 184));
        TextField dnsEntry = new TextField();
        dnsEntry.setStyle("-fx-background-color: #dddddd");
        dnsEntry.setLayoutX(182);
        dnsEntry.setLayoutY(154);
        dnsToggle.selectedProperty().addListener(l ->{
            if(dnsToggle.isSelected()){
                protonDNS.setDisable(false);
                customDNS.setDisable(false);
                dnsEntry.setDisable(false);
            }
            else{
                protonDNS.setDisable(true);
                customDNS.setDisable(true);
                dnsEntry.setDisable(true);
            }
        });


        CheckBox killSwitch = new CheckBox("Enable Kill Switch");
        killSwitch.setLayoutX(36);
        killSwitch.setLayoutY(179);
        killSwitch.setTextFill(Color.rgb(184, 184, 184));
        CheckBox lanAccess = new CheckBox("Allow Access To/From LAN");
        lanAccess.setLayoutX(55);
        lanAccess.setLayoutY(196);
        lanAccess.setTextFill(Color.rgb(184, 184, 184));
        killSwitch.selectedProperty().addListener(l ->{
            if(killSwitch.isSelected()){
                lanAccess.setDisable(false);
            }
            else{
                lanAccess.setDisable(true);
            }
        });


        CheckBox splitTunneling = new CheckBox("Enable Split Tunneling");
        splitTunneling.setLayoutX(36);
        splitTunneling.setLayoutY(213);
        splitTunneling.setTextFill(Color.rgb(184, 184, 184));


        Button acceptSettings = new Button("Accept");
        acceptSettings.setLayoutX(240);
        acceptSettings.setLayoutY(277);
        acceptSettings.setPadding(new Insets(0,10, 0,10));
        acceptSettings.getStyleClass().set(0, "flatButton");
        acceptSettings.setOnMouseEntered(e -> {
            acceptSettings.getStyleClass().set(0, "flatButtonOver");
        });
        acceptSettings.setOnMouseExited(e -> {
            acceptSettings.getStyleClass().set(0, "flatButton");
        });
        acceptSettings.setOnMousePressed(e -> {
            acceptSettings.getStyleClass().set(0, "flatButtonPreSelect");
        });
        acceptSettings.setOnMouseReleased(e -> {
            acceptSettings.getStyleClass().set(0, "flatButtonOver");
        });
        Button cancelSettings = new Button("Cancel");
        cancelSettings.setLayoutX(300);
        cancelSettings.setLayoutY(277);
        cancelSettings.setPadding(new Insets(0,10, 0,10));
        cancelSettings.getStyleClass().set(0, "flatButton");
        cancelSettings.setOnMouseEntered(e -> {
            cancelSettings.getStyleClass().set(0, "flatButtonOver");
        });
        cancelSettings.setOnMouseExited(e -> {
            cancelSettings.getStyleClass().set(0, "flatButton");
        });
        cancelSettings.setOnMousePressed(e -> {
            cancelSettings.getStyleClass().set(0, "flatButtonPreSelect");
        });
        cancelSettings.setOnMouseReleased(e -> {
            cancelSettings.getStyleClass().set(0, "flatButtonOver");
            settingsStage.close();
        });


        pane.getStylesheets().add("Styles.css");
        pane.getChildren().addAll(note, tcp, udp, dnsToggle, protonDNS, customDNS, dnsEntry, killSwitch, lanAccess, splitTunneling, acceptSettings, cancelSettings);
        Scene scene = new Scene(pane, 378, 312);
        settingsStage.setTitle("Settings");
        settingsStage.setScene(scene);
        settingsStage.show();
    }
}
