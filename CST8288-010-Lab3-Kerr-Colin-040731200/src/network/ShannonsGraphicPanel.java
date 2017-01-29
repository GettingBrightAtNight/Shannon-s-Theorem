package network;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

public class ShannonsGraphicPanel extends JPanel implements Observer {
	/**
	 * instance variables  
	 */
	private static final String BANDWIDTH_TEXT = "bw (hertz): ";
	private static final String SNR_TEXT = "snr (db): ";
	private static final String MDR_TEXT = "mdr (bps): ";
	private static final double MAX_DATA_RATE_MAX = 299901.68;
	private static int rectangleHeight = 0;

	private ShannonsController controller;
	private boolean isFirstTime;

	public ShannonsGraphicPanel(ShannonsController controller) {

		this.controller = controller;
		
		isFirstTime = true;
	}

	/**
	 * This method sets up the the bars that correspond to the data enter into the text
	 * boxes or when using the sliders
	 */
	public void paintComponent(Graphics g) {
		
		if(!isFirstTime){
		ShannonsTheorem shannonsTheorem = (ShannonsTheorem) this.controller;
		Font font = new Font("SansSerif", Font.PLAIN, 10);
		Graphics2D g2 = (Graphics2D) g;
		FontMetrics metrics = g2.getFontMetrics();
		int labelWidth = 0;
		int bandwidthWidth = 0;
		int snrWidth = 0;
		int mdrWidth = 0;
		
		/*setup background color after you enter data or move slider*/
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		/*calculate width of "label section"*/
		String maxDataRateMax = SingleDecimal.INSTANCE.format(MAX_DATA_RATE_MAX);
		labelWidth = metrics.stringWidth(maxDataRateMax);
		labelWidth += metrics.stringWidth(BANDWIDTH_TEXT);
		int maxBarWidth = this.getWidth() - labelWidth;
		
		
		String bandwidth = SingleDecimal.INSTANCE.format(shannonsTheorem.getBandWidth());
		String snr = SingleDecimal.INSTANCE.format(shannonsTheorem.getSignalToNoise());
		String mdr = SingleDecimal.INSTANCE.format(shannonsTheorem.getMaximumDataRate());
		
		bandwidthWidth = (int) (shannonsTheorem.getBandWidth() / 3000 * maxBarWidth);	
		snrWidth = (int) (shannonsTheorem.getSignalToNoise() / 30 * maxBarWidth);
		mdrWidth = (int) (shannonsTheorem.getMaximumDataRate() / 29901 * maxBarWidth);
		
		
		g2.drawString(BANDWIDTH_TEXT + bandwidth, 0, metrics.getHeight());
		g2.setPaint(Color.blue);
		g2.drawRect(labelWidth, 0, bandwidthWidth, rectangleHeight);
		g2.fillRect(labelWidth, 0, bandwidthWidth, rectangleHeight);
		
		g2.setPaint(Color.black);
		g2.drawString(SNR_TEXT + snr, 0, metrics.getHeight() * 2);
		g2.setPaint(Color.red);
		g2.drawRect(labelWidth, rectangleHeight, snrWidth, rectangleHeight);
		g2.fillRect(labelWidth, rectangleHeight, snrWidth, rectangleHeight);
		
		g2.setPaint(Color.black);
		g2.drawString(MDR_TEXT + mdr, 0, metrics.getHeight() * 3);
		g2.setPaint(Color.green);
		g2.drawRect(labelWidth, rectangleHeight*2, mdrWidth, rectangleHeight);
		g2.fillRect(labelWidth, rectangleHeight*2, mdrWidth, rectangleHeight);
				
		}else{
			
			this.isFirstTime = false;
			rectangleHeight = this.getHeight()/3;
			
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {

		this.repaint();

	}

}