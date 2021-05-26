package View;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends Pane {

    ListView listView;

    Button openCsv;
   Button openXML;
     Button openAlgo;

    public List<Node> set() {
        List<Node> ret = new ArrayList<>();

        listView = new ListView();
        listView.setPrefSize(175, 362); //was 163,362
        listView.setLayoutY(43); //was 43
        listView.setLayoutX(10); //was 25
        ret.add(listView);

        openCsv = new Button("Open CSV");
        openCsv.setLayoutX(10);
        openCsv.setLayoutY(410);
        openCsv.setPrefSize(85, 25);
        ret.add(openCsv);



        openXML = new Button("Open XML");
        openXML.setLayoutX(100);
        openXML.setLayoutY(410);
        openXML.setPrefSize(85, 25);
        ret.add(openXML);

        openAlgo = new Button("Open Algorithm");
        openAlgo.setLayoutX(10);
        openAlgo.setLayoutY(440);
        openAlgo.setPrefSize(175, 25);
        ret.add(openAlgo);





        return ret;
    }
}
