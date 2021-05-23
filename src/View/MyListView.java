package View;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends Pane {

MyListView myListView;

Button open;

public List<Node> set(){

    List<Node> returnedValue = new ArrayList<>();

    myListView = new MyListView();

    myListView.setPrefSize(163,362);

    myListView.setLayoutX(25);

    myListView.setLayoutY(43);

    returnedValue.add(myListView);

    open = new Button("Open");

    open.setLayoutX(25);

    open.setLayoutY(410);

    open.setPrefSize(163,42);

    returnedValue.add(open);

    return returnedValue;

    }

}
