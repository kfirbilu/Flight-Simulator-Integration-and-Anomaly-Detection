package Algorithms;

import Server.AnomalyReport;
import Server.StatLib;
import Server.TimeSeries;
import Server.TimeSeriesAnomalyDetector;

import java.util.ArrayList;
import java.util.List;

public class ZScore implements TimeSeriesAnomalyDetector {

    public float[] thresholdArray;

    public ZScore(TimeSeries timeSeries1) {

            thresholdArray = new float[timeSeries1.getCols().length];
    }

    @Override
    public void learnNormal(TimeSeries ts) {


        for (int i = 0; i < ts.getCols().length; i++) {

            float max = -999;

            for (int j = 2; j < ts.getCols()[i].getfeatures().size(); j++) {

                float avg = StatLib.avg(StatLib.listToArr(ts.getCols()[i].getfeatures().subList(0, j)));

                float standardDeviation = (float) Math.sqrt(StatLib.var(StatLib.listToArr(ts.getCols()[i].getfeatures().subList(0, j))));

                for (int k = 0; k < j; k++) {
                    float zScore;

                    if (standardDeviation == 0)
                        zScore = 0;

                    else
                        zScore = Math.abs(ts.getCols()[i].getfeatures().get(k) - avg) / standardDeviation;

                    if (zScore > max)
                        max = zScore;

                }

            }

            thresholdArray[i]=max;

        }

    }



    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {

        List<AnomalyReport> detected = new ArrayList<>();

        for (int i = 0; i < ts.getCols().length; i++) {

            float max = -999;

            for (int j = 2; j < ts.getCols()[i].getfeatures().size(); j++) {

                float avg = StatLib.avg(StatLib.listToArr(ts.getCols()[i].getfeatures().subList(0, j)));

                float standardDeviation = (float) Math.sqrt(StatLib.var(StatLib.listToArr(ts.getCols()[i].getfeatures().subList(0, j))));

                if (standardDeviation != 0)
                    for (int k = 0; k < j; k++) {
                        float zScore = Math.abs(ts.getCols()[i].getfeatures().get(k) - avg) / standardDeviation;

                        if (zScore > thresholdArray[i]) {
                            AnomalyReport anomalyReport = new AnomalyReport(ts.getCols()[i].getName(), k + 1);

                            if (!detected.contains(anomalyReport))
                                detected.add(anomalyReport);

                        }

                    }
            }
        }
        return detected;
    }


}
