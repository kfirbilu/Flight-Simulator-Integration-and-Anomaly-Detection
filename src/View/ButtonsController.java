package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ButtonsController implements Initializable {

    @FXML private ChoiceBox playSpeed;

    @FXML private Pane PaneID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TO DO
    }

    public void openXMLFile(javafx.event.ActionEvent actionEvent) throws IOException {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open XML/SCV/Class file");

        Stage stage= (Stage) PaneID.getScene().getWindow();

        fileChooser.getExtensionFilters().addAll((new FileChooser.ExtensionFilter("XML File","*.xml")));

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV File","*.CSV"));


        File xmlFile = fileChooser.showOpenDialog(stage);

        if (xmlFile!=null)  // what to do if the file opened successfully
        {
            //Desktop desktop = Desktop.getDesktop();  //opens the file

            //desktop.open(xmlFile);  //opens the file

            successAlert();
        }



    }

    void successAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Success");

        alert.setHeaderText("File uploaded successfully");

        alert.setContentText(null);

        alert.showAndWait();
    }

    void failAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Failed");

        alert.setHeaderText("File upload failed, please choose a valid XML file");

        alert.setContentText(null);

        alert.showAndWait();

    }




}
