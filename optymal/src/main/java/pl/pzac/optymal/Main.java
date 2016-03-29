import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;

public class ChartOne extends JPanel {
 
	private static final long serialVersionUID = 1L;
	private XYSeries pierwsza, druga, trzecia, czwarta, piata ;
	private XYSeriesCollection dataset ;
	

	public ChartOne() {
		super();
		
		//XYDataset dataset = DatasetUtilities.sampleFunction2D(new X1(), -4.0, 4.0, 40, "f(x)");
		//XYDataset dataset1 = DatasetUtilities.sampleFunction2D(new X2(), -4.0, 4.0, 40, "f(x)");

		init();

		// pierwsza.
		JFreeChart chart = ChartFactory.createXYLineChart("Metoda graficzna", "X1", "X2", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot xyplot = chart.getXYPlot(); 
		xyplot.setDataset(dataset);
		
		//xyplot.setDataset(1, dataset1);

		//XYLineAndShapeRenderer rr = new XYLineAndShapeRenderer(); 
		
	//	rr.setSeriesLinesVisible(2, true); 
	//	rr.setSeriesShapesVisible(2, true); 
		//rr.setPaint(Color.red); 
		//chart.getXYPlot().setRenderer(0,rr); 

		//XYLineAndShapeRenderer rr1 = new XYLineAndShapeRenderer(); 
//		rr1.setSeriesLinesVisible(2, true); 
//		rr1.setSeriesShapesVisible(2, true); 
//		rr1.setPaint(Color.blue); 
	//	chart.getXYPlot().setRenderer(1,rr1); 
		
		//chart.setBorderVisible(true);

		// draw a horizontal line across the chart at y == 0
		// plot.addRangeMarker(new Marker(0, Color.red, new BasicStroke(1),
		// Color.red, 1f));

		ChartPanel chartPanel = new ChartPanel(chart);

		add(chartPanel);
	}

	private void init () {
		pierwsza = new XYSeries("Pierwsza");
		for (int i = 0; i < 15; i++) {
			float newI = i;
			pierwsza.add(newI, newI / 5 + (2 / 5));
		}

		druga = new XYSeries("Druga");
		for (int i = 0; i < 15; i++) {
			float newI = i;
			druga.add(newI, newI * (3 / 2) + 1);
		}

	    trzecia = new XYSeries("Trzecia");
		for (int i = 0; i < 15; i++) {
			float newI = i;
			trzecia.add(newI, newI * (2 / 5) * (-1) + (43 / 5));
		}

		czwarta = new XYSeries("Czwarta");
		for (int i = 0; i < 15; i++) {
			float newI = i;
			czwarta.add(newI, newI * 3 - 22);
		}

		piata = new XYSeries("Piąta");
		for (int i = 0; i < 15; i++) {
			float newI = i;
			piata.add(newI, newI * (-3) + 10);
		}
		
		dataset = new XYSeriesCollection();
		
		dataset.addSeries(pierwsza);
		dataset.addSeries(druga);
		dataset.addSeries(trzecia);
		dataset.addSeries(czwarta);
		dataset.addSeries(piata);
		
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Chart One");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new ChartOne(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
