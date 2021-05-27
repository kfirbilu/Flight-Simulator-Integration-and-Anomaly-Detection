package View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class MyMenu extends Pane {

    Menu menu;

    MenuItem loadXML;
    MenuItem loadAlgorithm;
    MenuItem exit;

    MenuBar menuBar;

    public MenuBar set() {
        menu = new Menu("File");
        loadXML = new MenuItem("Load XML file");
        loadAlgorithm = new MenuItem("Load Algorithm class");
        exit = new MenuItem("Exit");
        menu.getItems().addAll(loadXML,loadAlgorithm,exit);
        menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        menuBar.setPrefHeight(25);
        menuBar.setPrefWidth(797);
        return menuBar;
    }
}
