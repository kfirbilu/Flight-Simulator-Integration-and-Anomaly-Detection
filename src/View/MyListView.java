package View;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends Pane {

    ListView listView;

    Button openCSV;
    Button openXML;
    Button openAlgo;

    public List<Node> set() {
        List<Node> ret = new ArrayList<>();

        listView = new ListView();
        listView.setPrefSize(175, 362);  // was 163,362
        listView.setLayoutY(43);
        listView.setLayoutX(10);  // was 25
        ret.add(listView);

        openCSV = new Button("1. Open CSV");
        openCSV.setLayoutX(10); //was 25
        openCSV.setLayoutY(410);
        openCSV.setPrefSize(85, 25); // was 163,42
        ret.add(openCSV);


        //////////////////////////////////////////////

        openXML = new Button("2. Open XML");
        openXML.setLayoutX(100);
        openXML.setLayoutY(410);
        openXML.setPrefSize(85, 25);
        ret.add(openXML);

        openAlgo = new Button("3. Open Algorithm");
        openAlgo.setLayoutX(10);
        openAlgo.setLayoutY(440);
        openAlgo.setPrefSize(175, 25);
        ret.add(openAlgo);


        //////////////////////////////////////////////


        return ret;
    }
}
