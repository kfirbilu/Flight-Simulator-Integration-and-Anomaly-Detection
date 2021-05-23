package Server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector
{
	private ArrayList<CorrelatedFeatures> correlatedFeaturesArr;

	public SimpleAnomalyDetector() {
		this.correlatedFeaturesArr = new ArrayList<>();
	}


	@Override
	public void learnNormal(TimeSeries ts)
	{
		String[] colsNames = new String[ts.getCols().length];
		
		
		for (int i = 0; i < ts.getCols().length; i++)
			colsNames[i] = ts.getCols()[i].getName();
		
		float max_pearson = -2;
		
		float calculatedPearson;
		
		int index = 0;
		
		for (int i = 0; i < colsNames.length; i++)
		{
			ArrayList<Float> temp = ts.getCols()[i].getFloats();
			
			float[] arrtemp = ts.ArrListToArr(temp);
			
			for (int j = i + 1; j < colsNames.length; j++)
			{
				
				if (colsNames[i] != colsNames[j])
				{
					ArrayList<Float> temp2 = ts.getCols()[j].getFloats();
				
					float[] arrtemp2 = ts.ArrListToArr(temp2);

					calculatedPearson = Math.abs(StatLib.pearson(arrtemp, arrtemp2));
				
					if (max_pearson < calculatedPearson && calculatedPearson > 0.9)
					{
						max_pearson = calculatedPearson;
					
						index = j;
					}
				}
				
			}
			
			if (max_pearson > 0)
			{
			
				Point[] pointsArr = ts.ArrToPoint(arrtemp, ts.ArrListToArr(ts.getCols()[index].getFloats()));
			
				Line l = StatLib.linear_reg(pointsArr);
			
				float max_th = 0;
			
				for (int j = 0; j < pointsArr.length; j++)
					if (max_th < StatLib.dev(pointsArr[j], l))
						max_th = StatLib.dev(pointsArr[j], l);
			
				correlatedFeaturesArr.add(new CorrelatedFeatures(colsNames[i], colsNames[index], max_pearson, l, max_th + (float) 0.0389));
			}

			max_pearson = -2;
			
			index = 0;
			
		}
	}


	@Override
	public List<AnomalyReport> detect(TimeSeries ts)
	{
			
		List<AnomalyReport> anomalyReportList = new ArrayList<AnomalyReport>();
		
		
		for (int i = 0; i < correlatedFeaturesArr.size(); i++)
		{
			String feature1 =  correlatedFeaturesArr.get(i).feature1;
			
			String feature2 =  correlatedFeaturesArr.get(i).feature2;
			
			ArrayList<Float> featuresList1 = new ArrayList<>();
			
			ArrayList<Float> featuresList2 = new ArrayList<>();
			
			for (int j = 0; j < ts.getCols().length; j++)
			{
				if(ts.getCols()[j].getName().equals(feature1))
					featuresList1 = ts.getCols()[j].getFloats();
				
				if(ts.getCols()[j].getName().equals(feature2))
					featuresList2 = ts.getCols()[j].getFloats();
			}
			
			
			float[] featuresArr1 = ts.ArrListToArr(featuresList1);
			
			float[] featuresArr2 = ts.ArrListToArr(featuresList2);
			
			Point[] pointsArr = ts.ArrToPoint(featuresArr1,featuresArr2);
			
			for (int j = 0; j < pointsArr.length; j++)
				if (StatLib.dev(pointsArr[j], correlatedFeaturesArr.get(i).lin_reg) > correlatedFeaturesArr.get(i).threshold)
				{
					AnomalyReport anomalyReport = new AnomalyReport(feature1 + "-" + feature2, j + 1);

					anomalyReportList.add(anomalyReport);
				}
			
		}
		
		return anomalyReportList;
	}
	
	public List<CorrelatedFeatures> getNormalModel()
	{
		return correlatedFeaturesArr;
	}
}
