package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        fileChooser.setTitle("Open XML file");

        Stage stage= (Stage) PaneID.getScene().getWindow();

        fileChooser.getExtensionFilters().addAll((new FileChooser.ExtensionFilter("Xml File","*.xml")));

        File xmlFile = fileChooser.showOpenDialog(stage);

        if (xmlFile!=null)  // what to do if the file opened successfully
        {
            Desktop desktop = Desktop.getDesktop();

            desktop.open(xmlFile);
        }


    }
}
