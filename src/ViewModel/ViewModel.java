package ViewModel;

import Model.Model;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;



public class ViewModel extends Observable implements Observer {

    Model model;

    StringProperty loadXMLResult;

    StringProperty openCSVResult;

    DoubleProperty minAileron;

    DoubleProperty maxAileron;

    DoubleProperty minElevator;

    DoubleProperty maxElevator;

    StringProperty XMLFilePath;

    StringProperty CSVFilePath;

    public ArrayList<String> colsNames;

    public String time;

    public float aileronstep;

    public float elevatorstep;

    public StringProperty getXMLFilePathProperty() {
        return XMLFilePath;
    }
    public StringProperty getCSVFilePathProperty() {
        return CSVFilePath;
    }
    public DoubleProperty getMinAileron() {
        return minAileron;
    }
    public DoubleProperty getMaxAileron() {
        return maxAileron;
    }

    public DoubleProperty getMinElevator() {
        return minElevator;
    }
    public DoubleProperty getMaxElevator() {
        return maxElevator;
    }

    public StringProperty loadXMLProperty() {
        return loadXMLResult;
    }


    public StringProperty OpenCSVProperty() {
        return openCSVResult;
    }

    public void VMLoadXML()
    {
        model.ModelLoadXML(XMLFilePath.getValue());
    }

    public void VMOpenCSV()
    {
        model.ModelOpenCSV(CSVFilePath.getValue());
    }

    public ViewModel(Model model)  {   // CTOR
        this.model = model;
        loadXMLResult = new SimpleStringProperty();
        openCSVResult = new SimpleStringProperty();
        XMLFilePath = new SimpleStringProperty();
        CSVFilePath = new SimpleStringProperty();
        minAileron = new SimpleDoubleProperty();
        maxAileron = new SimpleDoubleProperty();
        minElevator = new SimpleDoubleProperty();
        maxElevator = new SimpleDoubleProperty();
        colsNames = new ArrayList<>();
    }





    @Override
    public void update(java.util.Observable o, Object arg) {

        String p = (String)arg;
        if (p.intern() == "resultLoadXML")
        {
            if (model.getResultLoadXML().intern() == "WrongFormatAlert")
                loadXMLResult.set("WrongFormatAlert");
            if (model.getResultLoadXML().intern() == "MissingArgumentAlert")
                loadXMLResult.set("MissingArgumentAlert");
            if (model.getResultLoadXML().intern() == "SuccessAlert")
                loadXMLResult.set("SuccessAlert");
        }
        if (p.intern() == "resultOpenCSV")
        {
            if (model.getResultOpenCSV().intern() == "Missing Arguments")
                openCSVResult.set("Missing Arguments");
            if (model.getResultOpenCSV().intern() == "Incompatibility with XML file")
                openCSVResult.set("Incompatibility with XML file");
            if (model.getResultOpenCSV().intern() == "OK")
            {
                openCSVResult.set("OK");
                for (String name : model.getColsNames())
                {
                    colsNames.add(name);
                }
                setChanged();
                notifyObservers("colNames");
            }
        }
        if (p.intern() == "time")
        {
            time = model.gettime();
            setChanged();
            notifyObservers("time");
        }
        if (p.intern() == "aileron")
        {
            aileronstep = model.getAileronstep();
            setChanged();
            notifyObservers("aileron");
        }
        if (p.intern() == "elevator")
        {
            elevatorstep = model.getElevatorstep();
            setChanged();
            notifyObservers("elevator");
        }

    }


    public void ViewModelPlay()
    {
        model.modelPlay();
    }

    public void ViewModelGetChoice(String speed)
    {
        model.modelGetChoice(speed);
    }

    public void ViewModelPause()
    {
        model.modelpause();
    }

    public void ViewModelPlus15Sec()
    {
        model.modelPlus15();
    }

    public void ViewModelMinus15Sec()
    {
        model.modelMinus15();
    }

    public void ViewModelMinus30Sec()
    {
        model.modelMinus30();
    }

    public void ViewModelPlus30Sec()
    {
        model.modelPlus30();
    }

    public void ViewModelSetMinAileron()
    {
        minAileron.setValue(model.modelSetMinAileron());
    }

    public void ViewModelSetMaxAileron()
    {
        maxAileron.setValue(model.modelSetMaxAileron());
    }

    public void ViewModelSetMinElevator()
    {
        minElevator.setValue(model.modelSetMinElevator());
    }

    public void ViewModelSetMaxElevator()
    {
        maxElevator.setValue(model.modelSetMaxElevator());
    }


}
