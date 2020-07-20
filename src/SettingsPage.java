import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class SettingsPage {

    private Text note = new Text("For security reasons, to change your password or update your plan, please visit the ProtonVPN website, then use the terminal to update");
    private ToggleGroup protocol = new ToggleGroup();
    private RadioButton tcp = new RadioButton("TCP");
    private RadioButton udp = new RadioButton("UDP");
    private CheckBox dnsToggle = new CheckBox("Enable DNS Management");
    private RadioButton protonDNS = new RadioButton("Use ProtonVPN DNS (DNS Leak Protection)");
    private RadioButton customDNS = new RadioButton("Use Custom DNS:");
    private TextField dnsEntry = new TextField();
    private ToggleGroup dnsGroup = new ToggleGroup();
    private CheckBox killSwitch = new CheckBox("Enable Kill Switch");
    private CheckBox lanAccess = new CheckBox("Allow Access To/From LAN");
    private CheckBox splitTunneling = new CheckBox("Enable Split Tunneling");
    private Button acceptSettings = new Button("Accept");
    private Button cancelSettings = new Button("Cancel");

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

        note.setFontSmoothingType(FontSmoothingType.LCD);
        note.setFill(Color.rgb(184, 184, 184));
        note.setWrappingWidth(360);
        note.setLayoutX(9);
        note.setLayoutY(27);


        tcp.setToggleGroup(protocol);
        tcp.setLayoutX(36);
        tcp.setLayoutY(96);
        tcp.setTextFill(Color.rgb(184, 184, 184));
        udp.setToggleGroup(protocol);
        udp.setLayoutX(86);
        udp.setLayoutY(96);
        udp.setTextFill(Color.rgb(184, 184, 184));


        dnsToggle.setLayoutX(36);
        dnsToggle.setLayoutY(119);
        dnsToggle.setTextFill(Color.rgb(184, 184, 184));
        protonDNS.setToggleGroup(dnsGroup);
        protonDNS.setLayoutX(56);
        protonDNS.setLayoutY(136);
        protonDNS.setTextFill(Color.rgb(184, 184, 184));
        customDNS.setToggleGroup(dnsGroup);
        customDNS.setLayoutX(56);
        customDNS.setLayoutY(158);
        customDNS.setTextFill(Color.rgb(184, 184, 184));
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


        killSwitch.setLayoutX(36);
        killSwitch.setLayoutY(179);
        killSwitch.setTextFill(Color.rgb(184, 184, 184));
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


        splitTunneling.setLayoutX(36);
        splitTunneling.setLayoutY(213);
        splitTunneling.setTextFill(Color.rgb(184, 184, 184));


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
            try {
                acceptSettings();
                settingsStage.close();
            }
            catch(Exception exception){
                Stage alertStage = new Stage();
                Pane alertPane = new Pane();
                Scene alertScene = new Scene(alertPane);
                alertPane.setStyle("-fx-background-color: #2b2b2b");

                Text alertNote = new Text("No valid settings detected, please set them up in order to continue.");
                alertNote.setFontSmoothingType(FontSmoothingType.LCD);
                alertNote.setFill(Color.rgb(184, 184, 184));
                alertNote.setWrappingWidth(300);
                alertNote.setLayoutX(9);
                alertNote.setLayoutY(27);

                Button alertOK = new Button("Okay");
                alertOK.setLayoutX(250);
                alertOK.setLayoutY(50);
                alertOK.setPadding(new Insets(0,10, 10,10));
                alertOK.getStyleClass().set(0, "flatButton");
                alertOK.setOnMouseEntered(e2 -> {
                    alertOK.getStyleClass().set(0, "flatButtonOver");
                });
                alertOK.setOnMouseExited(e2 -> {
                    alertOK.getStyleClass().set(0, "flatButton");
                });
                alertOK.setOnMousePressed(e2 -> {
                    alertOK.getStyleClass().set(0, "flatButtonPreSelect");
                });
                alertOK.setOnMouseReleased(e2 -> {
                    alertOK.getStyleClass().set(0, "flatButtonOver");
                    alertStage.close();
                });

                alertPane.getStylesheets().add("Styles.css");
                alertPane.getChildren().addAll(alertNote, alertOK);
                alertStage.setScene(alertScene);
                alertStage.show();
            }
        });

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


        try {
            getSettings();
            pane.getChildren().addAll(note, tcp, udp, dnsToggle, protonDNS, customDNS, dnsEntry, killSwitch, lanAccess, splitTunneling, acceptSettings, cancelSettings);
            pane.getStylesheets().add("Styles.css");
            Scene scene = new Scene(pane, 378, 312);
            settingsStage.setTitle("Settings");
            settingsStage.setScene(scene);
            settingsStage.initModality(Modality.APPLICATION_MODAL);
            settingsStage.show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();    //show error window, move to settings, make recursive attempts, have counter to check
            pane.getChildren().addAll(note, tcp, udp, dnsToggle, protonDNS, customDNS, dnsEntry, killSwitch, lanAccess, splitTunneling, acceptSettings);
            settingsStage.initStyle(StageStyle.UNDECORATED);
            pane.getStylesheets().add("Styles.css");
            Scene scene = new Scene(pane, 378, 312);
            settingsStage.setTitle("Settings");
            settingsStage.setScene(scene);
            settingsStage.initModality(Modality.APPLICATION_MODAL);
            protonDNS.setDisable(true);
            customDNS.setDisable(true);
            dnsEntry.setDisable(true);
            lanAccess.setDisable(true);

            settingsStage.show();

            Stage alertStage = new Stage();
            Pane alertPane = new Pane();
            Scene alertScene = new Scene(alertPane);
            alertPane.setStyle("-fx-background-color: #2b2b2b");

            Text alertNote = new Text("No valid settings detected, please set them up in order to continue.");
            alertNote.setFontSmoothingType(FontSmoothingType.LCD);
            alertNote.setFill(Color.rgb(184, 184, 184));
            alertNote.setWrappingWidth(300);
            alertNote.setLayoutX(9);
            alertNote.setLayoutY(27);

            Button alertOK = new Button("Okay");
            alertOK.setLayoutX(250);
            alertOK.setLayoutY(50);
            alertOK.setPadding(new Insets(0,10, 10,10));
            alertOK.getStyleClass().set(0, "flatButton");
            alertOK.setOnMouseEntered(e2 -> {
                alertOK.getStyleClass().set(0, "flatButtonOver");
            });
            alertOK.setOnMouseExited(e2 -> {
                alertOK.getStyleClass().set(0, "flatButton");
            });
            alertOK.setOnMousePressed(e2 -> {
                alertOK.getStyleClass().set(0, "flatButtonPreSelect");
            });
            alertOK.setOnMouseReleased(e2 -> {
                alertOK.getStyleClass().set(0, "flatButtonOver");
                alertStage.close();
            });

            alertPane.getStylesheets().add("Styles.css");
            alertPane.getChildren().addAll(alertNote, alertOK);
            alertStage.setScene(alertScene);
            alertStage.show();
        }
    }

    void getSettings() throws FileNotFoundException {
        File settings = new File("settings.conf");
        Scanner settingsScanner = new Scanner(settings);
        if(settings.exists()){
            while(settingsScanner.hasNextLine()){
                String line = settingsScanner.nextLine();
                String[] lineData = line.split("=");
                switch (lineData[0]){
                    case "protocol":
                        switch (lineData[1]){
                            case "tcp":
                                udp.setSelected(true);
                                break;
                            case "udp":
                                udp.setSelected(true);
                                break;
                        }
                    case "dnsmanagement":
                        switch (lineData[1]){
                            case "true":
                                dnsToggle.setSelected(true);
                                break;
                            case "false":
                                dnsToggle.setSelected(false);
                                protonDNS.setDisable(true);
                                customDNS.setDisable(true);
                                dnsEntry.setDisable(true);
                                break;
                        }
                    case "dnstype":
                        switch (lineData[1]){
                            case "proton":
                                protonDNS.setSelected(true);
                                break;
                            case "custom":
                                customDNS.setSelected(true);
                                break;
                        }
                    case "customdns":
                        dnsEntry.setText(lineData[1]);
                        break;
                    case "killswitch":
                        switch (lineData[1]){
                            case "true":
                                killSwitch.setSelected(true);
                                break;
                            case "false":
                                killSwitch.setSelected(false);
                                lanAccess.setDisable(true);
                                break;
                        }
                    case "lanaccess":
                        switch (lineData[1]){
                            case "true":
                                lanAccess.setSelected(true);
                                break;
                            case "false":
                                lanAccess.setSelected(false);
                                break;
                        }
                    case "splittunneling":
                        switch (lineData[1]){
                            case "true":
                                splitTunneling.setSelected(true);
                                break;
                            case "false":
                                splitTunneling.setSelected(false);
                                break;
                        }
                }
            }
        }
    }

    void acceptSettings() throws Exception{
        try {
            File myObj = new File("settings.conf");
            if (myObj.createNewFile()) {
                String[] toWrite = new String[]{"protocol", "dnsmanagement", "dnstype", "customdns", "killswitch", "lanaccess", "splittunneling"};
                FileWriter settingsWriter = new FileWriter("settings.conf");
                for (int i = 0; i < 7; i++) {
                    switch (i){
                        case 0:
                            RadioButton selectedRadioButton = (RadioButton) protocol.getSelectedToggle();
                            String protocolValue = selectedRadioButton.getText();
                            System.out.println(protocolValue);
                            settingsWriter.write(toWrite[i] + "=");
                            break;
                    }
                }
                settingsWriter.close();
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
