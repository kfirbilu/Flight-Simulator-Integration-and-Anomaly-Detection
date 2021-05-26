package Server;

import java.beans.XMLEncoder;
import java.io.Serializable;

public class UserSettings implements Serializable {

    private String colName;

    private String realColName;

    private int max = 999999;

    private int min = -999999;


    public UserSettings() {
    }  // default CTOR

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getRealColName() {
        return realColName;
    }

    public void setRealColName(String realColName) {
        this.realColName = realColName;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }




}
