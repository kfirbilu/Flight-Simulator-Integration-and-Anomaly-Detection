package View;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class MyButtons extends Pane {
    ChoiceBox playSpeedDropDown;

    Label timer;

    Button play;
    Button pause;
    Button stop;
    Button plus15;
    Button minus15;
    Button minus30;
    Button plus30;
    Slider slider;

    public List<Node> set() {
        List<Node> ret = new ArrayList<>();

        play = new Button("Play");
        play.setLayoutX(25);
        play.setLayoutY(475);
        play.setPrefSize(74, 42);
        ret.add(play);

        pause = new Button("Pause");
        pause.setLayoutX(105);
        pause.setLayoutY(475);
        pause.setPrefSize(74, 42);
        ret.add(pause);

        stop = new Button("Stop");
        stop.setLayoutX(185);
        stop.setLayoutY(475);
        stop.setPrefSize(74, 42);
        ret.add(stop);

        minus30 = new Button("<<<");
        minus30.setLayoutX(265);
        minus30.setLayoutY(475);
        minus30.setPrefSize(74, 42);
        ret.add(minus30);

        plus30 = new Button(">>>");
        plus30.setLayoutX(505);
        plus30.setLayoutY(475);
        plus30.setPrefSize(74, 42);
        ret.add(plus30);

        minus15 = new Button("<<");
        minus15.setLayoutX(345);
        minus15.setLayoutY(475);
        minus15.setPrefSize(74, 42);
        ret.add(minus15);

        plus15 = new Button(">>");
        plus15.setLayoutX(425);
        plus15.setLayoutY(475);
        plus15.setPrefSize(74, 42);
        ret.add(plus15);

        Label playSpeed = new Label("Play Speed");
        playSpeed.setFont(new Font(20));
        playSpeed.setLayoutX(588);
        playSpeed.setLayoutY(475);
        playSpeed.setPrefSize(105, 36);
        ret.add(playSpeed);



        playSpeedDropDown = new ChoiceBox();
        playSpeedDropDown.getItems().addAll("x0.5", "x1.0", "x1.5", "x2.0");
        playSpeedDropDown.setLayoutX(695);
        playSpeedDropDown.setLayoutY(475);
        playSpeedDropDown.setPrefSize(67, 42);
        ret.add(playSpeedDropDown);

        slider = new Slider();
        slider.setLayoutX(25);
        slider.setLayoutY(520);
        slider.setPrefSize(560, 42);
        ret.add(slider);

        timer = new Label();
        timer.setFont(new Font(15));
        timer.setLayoutY(525);
        timer.setLayoutX(610);
        ret.add(timer);


        Label selectedFeature = new Label("Selected Feature");
        selectedFeature.setFont(new Font(10));
        selectedFeature.setLayoutX(260);
        selectedFeature.setLayoutY(25);
        selectedFeature.setPrefSize(100, 20);
        ret.add(selectedFeature);


        Label correlatedFeature = new Label("Correlated Feature");
        correlatedFeature.setFont(new Font(10));
        correlatedFeature.setLayoutX(460);
        correlatedFeature.setLayoutY(25);
        correlatedFeature.setPrefSize(100, 20);
        ret.add(correlatedFeature);

        Label algorithmGraph = new Label("Algorithm Graph");
        algorithmGraph.setFont(new Font(10));
        algorithmGraph.setLayoutX(360);
        algorithmGraph.setLayoutY(204);
        algorithmGraph.setPrefSize(100, 20);
        ret.add(algorithmGraph);



        return ret;
    }
}
