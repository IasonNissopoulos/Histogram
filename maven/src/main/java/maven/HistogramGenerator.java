package maven;

import java.io.BufferedReader;
import java.io.FileReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {
	public static void main(String[] args) {
		HistogramGenerator demo = new HistogramGenerator();
		//create a 2-d array
		int[][] disp = new int[11][2];
		String path = args[0];
		System.out.println(path);
		disp = demo.returnArray(path);
		//create a 1-d array
		int[] dataValues = new int[11];
		int i = 0;
		//implement the sums from the 2-d array into the 1-d array
		while(i <11){
			// the input values
			dataValues[i] = disp[i][1];
			i++;
		}
		// generate the Chart
		demo.generateChart(dataValues);
	}
		
		/***
		 * Receives a single dimension Integer array. From this array the dataset
		 * that will be used for the visualization is generated. Finally, The chart
		 * is generated with the use of the aforementioned dataset and then
		 * presented in the screen.
		 * 
		 * @param dataValues Single dimension integer array
		 */
		public void generateChart(int[] dataValues) {
			/*
			 * The XYSeriesCollection object is a set XYSeries series (dataset) that
			 * can be visualized in the same chart
			 */
			XYSeriesCollection dataset = new XYSeriesCollection();
			/*
			 * The XYSeries that are loaded in the dataset. There might be many
			 * series in one dataset.
			 */
			XYSeries data = new XYSeries("random values");

			/*
			 * Populating the XYSeries data object from the input Integer array
			 * values.
			 */
			for (int i = 0; i < dataValues.length; i++) {
				data.add(i, dataValues[i]);
			}

			// add the series to the dataset
			dataset.addSeries(data);

			boolean legend = false; // do not visualize a legend
			boolean tooltips = false; // do not visualize tooltips
			boolean urls = false; // do not visualize urls

			// Declare and initialize a createXYLineChart JFreeChart
			JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
					PlotOrientation.VERTICAL, legend, tooltips, urls);

			/*
			 * Initialize a frame for visualizing the chart and attach the
			 * previously created chart.
			 */
			ChartFrame frame = new ChartFrame("First", chart);
			frame.pack();
			// makes the previously created frame visible
			frame.setVisible(true);
		}

		
	public int[][] returnArray(String gradePath) {
		// create the 2-d array
		int[][] frequencyArray = new int[11][2];
		String thisLine = null;
		try {
			//read the file in the gradePath destination
			BufferedReader br = new BufferedReader(new FileReader(gradePath));//gradePath
			int line;

			int i = 0;
			//initialiazie the array
			while (i < 11) {
				frequencyArray[i][0] = i;
				i++;
			}
			//read each Line 
			while ((thisLine = br.readLine()) != null) {
				line = Integer.parseInt(thisLine);
				//append the grades into the array
				if (line == 0) {
					//System.out.println("Got into 0" + line);
					frequencyArray[0][1]++;
					//System.out.println("frequencyArray[0][1]"+frequencyArray[0][1]);
				}
				if (line == 1) {
					frequencyArray[1][1]++;
				}
				if (line == 2) {
					frequencyArray[2][1]++;
				}
				if (line == 3) {
					frequencyArray[3][1]++;
				}
				if (line == 4) {
					frequencyArray[4][1]++;
				}
				if (line == 5) {
					frequencyArray[5][1]++;
				}
				if (line == 6) {
					frequencyArray[6][1]++;
				}
				if (line == 7) {
					frequencyArray[7][1]++;
				}
				if (line == 8) {
					frequencyArray[8][1]++;
				}
				if (line == 9) {
					frequencyArray[9][1]++;
				}
				if (line == 10) {
					frequencyArray[10][1]++;
				}
			}

		br.close();
		}catch (Exception e) {
		          /* This is a generic Exception handler which means it can handle
		           * all the exceptions. This will execute if the exception is not
		           * handled by previous catch blocks.
		           */
        System.out.println("Exception occurred");
		}
		return frequencyArray;
	}

}
