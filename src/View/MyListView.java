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
        listView.setPrefSize(175, 330);
        listView.setLayoutY(43);
        listView.setLayoutX(10);
        ret.add(listView);


        openXML = new Button("1. Open XML");
        openXML.setLayoutX(10);
        openXML.setLayoutY(380);
        openXML.setPrefSize(175, 25);
        ret.add(openXML);

        openAlgo = new Button("2. Open Algorithm");
        openAlgo.setLayoutX(10);
        openAlgo.setLayoutY(410);
        openAlgo.setPrefSize(175, 25);
        ret.add(openAlgo);

        openCSV = new Button("3. Open CSV");
        openCSV.setLayoutX(10);
        openCSV.setLayoutY(440);
        openCSV.setPrefSize(175, 25);
        ret.add(openCSV);



        return ret;
    }
}
