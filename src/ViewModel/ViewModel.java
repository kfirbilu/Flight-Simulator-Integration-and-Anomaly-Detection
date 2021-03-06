package ViewModel;

import Server.Circle;
import Model.Model;
import Server.Line;
import Server.Point;
import javafx.beans.property.*;
import java.util.ArrayList;
import java.util.Observable;

public class ViewModel extends AllViewModels {

    private ArrayList<String> colsNames;

    private ArrayList<Float> algorithmColValues;
    private ArrayList<Float> algorithmCoralatedColValues;
    private ArrayList<Float> anomalyAlgorithmColValues;
    private ArrayList<Float> anomalyAlgorithmCoralatedColValues;
    private ArrayList<Float> ZScoreline;

    private ArrayList<Point> pointsForCircle;

    private String className="";

    private Line algorithmLine;
    private Circle algorithmCircle;

    private int minColValue;
    private int maxColValue;

    private IntegerProperty flightLong;
    private IntegerProperty numofrow;
    private IntegerProperty report;

    private StringProperty loadXMLResult;
    private StringProperty resultLoadAlgorithm;
    private StringProperty openCSVResult;
    private StringProperty chosenXMLFilePath;
    private StringProperty chosenCSVFilePath;
    private StringProperty time;

    private DoubleProperty minRudder;
    private DoubleProperty maxRudder;
    private DoubleProperty minThrottle;
    private DoubleProperty maxThrottle;
    private DoubleProperty maxTimeSlider;

    private FloatProperty rudderstep;
    private FloatProperty throttlestep;
    private FloatProperty altimeterstep;
    private FloatProperty airspeedstep;
    private FloatProperty directionstep;
    private FloatProperty pitchstep;
    private FloatProperty rollstep;
    private FloatProperty yawstep;
    private FloatProperty aileronstep;
    private FloatProperty elevatorstep;

    public ArrayList<String> getColsNames() {
        return colsNames;
    }

    public ArrayList<Float> getAlgorithmColValues() {
        return algorithmColValues;
    }

    public ArrayList<Float> getAlgorithmCoralatedColValues() {
        return algorithmCoralatedColValues;
    }

    public ArrayList<Float> getAnomalyAlgorithmColValues()
    {
        return anomalyAlgorithmColValues;
    }

    public ArrayList<Float> getAnomalyAlgorithmCoralatedColValues()
    {
        return anomalyAlgorithmCoralatedColValues;
    }

    public ArrayList<Point> getPointsForCircle() { return  pointsForCircle; }

    public ArrayList<Float> getZScoreline()
    {
        return ZScoreline;
    }

    public Line getAlgorithmLine() {
        return algorithmLine;
    }

    public Circle getAlgorithmCircle()
    {
        return algorithmCircle;
    }

    public String getClassName()
    {
        return className;
    }

    public int getMinColValue()
    {
        return minColValue;
    }

    public int getMaxColValue()
    {
        return maxColValue;
    }

    public IntegerProperty getFlightLong() {
        return flightLong;
    }

    public IntegerProperty getNumofrow()
    {
        return numofrow;
    }

    public IntegerProperty getReport()
    {
        return report;
    }

    public StringProperty getChosenXMLFilePath() {
        return chosenXMLFilePath;
    }

    public StringProperty getChosenCSVFilePath() {
        return chosenCSVFilePath;
    }

    public StringProperty getTime() {
        return time;
    }

    public StringProperty getLoadXMLResult() {
        return loadXMLResult;
    }

    public StringProperty getOpenCSVResult() {
        return openCSVResult;
    }

    public StringProperty getResultLoadAlgorithm()
    {
        return resultLoadAlgorithm;
    }

    public DoubleProperty getMinRudder() {
        return minRudder;
    }

    public DoubleProperty getMaxRudder() {
        return maxRudder;
    }

    public DoubleProperty getMinThrottle() {
        return minThrottle;
    }

    public DoubleProperty getMaxThrottle() {
        return maxThrottle;
    }

    public DoubleProperty getMaxTimeSlider() {
        return maxTimeSlider;
    }

    public FloatProperty getRudderstep() {
        return rudderstep;
    }

    public FloatProperty getThrottlestep() {
        return throttlestep;
    }

    public FloatProperty getAltimeterstep() {
        return altimeterstep;
    }

    public FloatProperty getAirspeedstep() {
        return airspeedstep;
    }

    public FloatProperty getDirectionstep() {
        return directionstep;
    }

    public FloatProperty getPitchstep() {
        return pitchstep;
    }

    public FloatProperty getRollstep() {
        return rollstep;
    }

    public FloatProperty getYawstep() {
        return yawstep;
    }

    public FloatProperty getAileronstep() {
        return aileronstep;
    }

    public FloatProperty getElevatorstep() {
        return elevatorstep;
    }

    public ViewModel(Model model) {
        this.model = model;

        colsNames = new ArrayList<>();
        algorithmColValues = new ArrayList<>();
        algorithmCoralatedColValues = new ArrayList<>();
        ZScoreline = new ArrayList<>();
        pointsForCircle = new ArrayList<>();

        loadXMLResult = new SimpleStringProperty();
        openCSVResult = new SimpleStringProperty();
        resultLoadAlgorithm = new SimpleStringProperty();
        chosenXMLFilePath = new SimpleStringProperty();
        chosenCSVFilePath = new SimpleStringProperty();
        time = new SimpleStringProperty();

        minRudder = new SimpleDoubleProperty();
        maxRudder = new SimpleDoubleProperty();
        minThrottle = new SimpleDoubleProperty();
        maxThrottle = new SimpleDoubleProperty();
        maxTimeSlider = new SimpleDoubleProperty();

        rudderstep = new SimpleFloatProperty();
        throttlestep = new SimpleFloatProperty();
        altimeterstep = new SimpleFloatProperty();
        airspeedstep = new SimpleFloatProperty();
        directionstep = new SimpleFloatProperty();
        pitchstep = new SimpleFloatProperty();
        rollstep = new SimpleFloatProperty();
        yawstep = new SimpleFloatProperty();
        aileronstep = new SimpleFloatProperty();
        elevatorstep = new SimpleFloatProperty();

        flightLong = new SimpleIntegerProperty();
        numofrow = new SimpleIntegerProperty();
        report = new SimpleIntegerProperty();
        report.set(0);

    }

    @Override
    public void update(Observable o, Object arg) {
        String p = (String) arg;

        if (p.intern() == "resultLoadXML") {
            if (model.getResultLoadXML().intern() == "WrongFormatAlert")
                loadXMLResult.set("WrongFormatAlert");
            if (model.getResultLoadXML().intern() == "MissingArgumentAlert")
                loadXMLResult.set("MissingArgumentAlert");
            if (model.getResultLoadXML().intern() == "SuccessAlert")
                loadXMLResult.set("SuccessAlert");
        }
        if (p.intern() == "resultOpenCSV") {
            if (model.getResultOpenCSV().intern() == "Missing Arguments")
                openCSVResult.set("Missing Arguments");
            if (model.getResultOpenCSV().intern() == "Incompatibility with XML file")
                openCSVResult.set("Incompatibility with XML file");
            if (model.getResultOpenCSV().intern() == "OK") {
                openCSVResult.set("OK");
                for (String name : model.getColsNames()) {
                    colsNames.add(name);
                }
            }
        }
        if (p.intern() == "time")
            time.set(model.gettime());
        if (p.intern() == "rudder")
            rudderstep.set(model.getRudderstep());
        if (p.intern() == "throttle")
            throttlestep.set(model.getThrottlestep());
        if (p.intern() == "altimeter")
            altimeterstep.set(model.getAltimeterstep());
        if (p.intern() == "airspeed")
            airspeedstep.set(model.getAirspeedstep());
        if (p.intern() == "direction")
            directionstep.set(model.getDirectionstep());
        if (p.intern() == "pitch")
            pitchstep.set(model.getPitchstep());
        if (p.intern() == "roll")
            rollstep.set(model.getRollstep());
        if (p.intern() == "yaw")
            yawstep.set(model.getYawstep());
        if (p.intern() == "aileron")
            aileronstep.set(model.getAileronstep());
        if (p.intern() == "elevator")
            elevatorstep.set(model.getElevatorstep());
        if (p.intern() == "numofrow")
            numofrow.set(model.getNumofrow());
        if (p.intern() == "report")
            report.set(1);
        if (p.intern() == "reportDone")
            report.set(0);
        if (p.intern() == "resultLoadAlgorithm")
        {
            if (model.getResultLoadAlgorithm().intern() == "failed")
                resultLoadAlgorithm.set("failed");
            else
                resultLoadAlgorithm.set("success");
        }
    }

    @Override
    public void VMLoadXML() {
        model.ModelLoadXML(chosenXMLFilePath.getValue());
    }

    @Override
    public void VMOpenCSV() {
        model.ModelOpenCSV(chosenCSVFilePath.getValue());
        flightLong.set(model.getFlightLong());
    }

    @Override
    public void VMplay() {
        model.modelPlay();
    }

    @Override
    public void VMGetChoice(String speed) {
        model.modelGetChoice(speed);
    }

    @Override
    public void VMpause() {
        model.modelpause();
    }

    @Override
    public void VMplus15() {
        model.modelPlus15();
    }

    @Override
    public void VMminus15() {
        model.modelMinus15();
    }

    @Override
    public void VMminus30() {
        model.modelMinus30();
    }

    @Override
    public void VMplus30() {
        model.modelPlus30();
    }

    public void VMsetMinRudder() {
        minRudder.setValue(model.modelSetMinRudder());
    }

    public void VMsetMaxRudder() {
        maxRudder.setValue(model.modelSetMaxRudder());
    }

    public void VMsetMinThrottle() {
        minThrottle.setValue(model.modelSetMinThrottle());
    }

    public void VMsetMaxThrottle() {
        maxThrottle.setValue(model.modelSetMaxThrottle());
    }

    public void setMaxTimeSlider() {
        maxTimeSlider.setValue(model.modelSetMaxTimeSlider());
    }

    public void VMtimeslider(double second) {
        model.modelTimeSlider(second);
    }

    @Override
    public void VMstop() {
        model.modelStop();
    }

    @Override
    public void VMsetLeftLineChart(String colName)
    {
        model.modelSetLeftLineChart(colName);
    }

    @Override
    public void VMsetRightLineChart(String colName)
    {
        model.modelSetRightLineChart(colName);
    }

    @Override
    public void VMsetAlgorithmLineChart(String colName)
    {
        if (colName==null)  // default colname in case the user didnt pick one
            colName = "ailron";

        model.modelSetAlgorithmLineChart(colName);
        className = model.getClassName();
        algorithmColValues = model.getAlgorithmColValues();
        algorithmCoralatedColValues = model.getAlgorithmCoralatedColValues();

        if (className.intern() == "class Algorithms.LinearRegression") // was Model.LinearRegression kfir
        {
            anomalyAlgorithmColValues = model.getAnomalyAlgorithmColValues();
            anomalyAlgorithmCoralatedColValues = model.getAnomalyAlgorithmCoralatedColValues();
            algorithmLine = model.getAlgorithmLine();
            maxColValue = model.getMaxColValue();
            minColValue = model.getMinColValue();
        }

        if (className.intern() == "class Algorithms.ZScore") // kfir
        {
            ZScoreline = model.getZScoreLine();
        }

        if (className.intern() == "class Algorithms.Hybrid")
        {
            anomalyAlgorithmColValues = model.getAnomalyAlgorithmColValues();
            anomalyAlgorithmCoralatedColValues = model.getAnomalyAlgorithmCoralatedColValues();
            algorithmCircle = model.getAlgorithmCircle();
            pointsForCircle = model.getPointsForCircle();
        }
    }

    @Override
    public void VMLoadAlgorithm(String resultClassDirectory, String resultClassName)
    {
        model.modelLoadAlgorithm(resultClassDirectory, resultClassName);
    }
}
