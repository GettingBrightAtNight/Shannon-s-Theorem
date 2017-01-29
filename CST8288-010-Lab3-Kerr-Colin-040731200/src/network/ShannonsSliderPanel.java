package network;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ShannonsSliderPanel extends JPanel implements Observer {
	/**
	 * static variables
	 * 
	 */

	private static final String BANDWIDTH_SLIDER_NAME = "Bandwidth";
	private static final String STN_SLIDER_NAME = "Signal to Noise";

	private static final int BANDWIDTH_MAX = 3000;
	private static final int BANDWIDTH_MIN = 0;
	private static final int SIGNAL_TO_NOISE_MAX = 30;
	private static final int SIGNAL_TO_NOISE_MIN = 0;
	private static final int MAXIMUM_DATA_RATE_MAX = 29901; // could not change
															// to double .68
	private static final int MAXIMUM_DATA_RATE_MIN = 0;

	/**
	 * instance variables
	 * 
	 */

	private ShannonsController controller;
	private JSlider maxDataRateJSlider;
	private JSlider bandwidthJSlider;
	private JSlider signalToNoiseJSLider;

	/**
	 * 
	 * @param controller
	 */
	public ShannonsSliderPanel(ShannonsController controller) {

		this.controller = controller;
		this.maxDataRateJSlider = new JSlider();
		this.bandwidthJSlider = new JSlider();
		this.signalToNoiseJSLider = new JSlider();
		this.assembleUserInterface();
		this.configureEvents();
	}
		/**
		 * this method adds and sets up the jsliders in the jframe and gives them values
		 * and also min and maximum values
		 */
	private void assembleUserInterface() {

		this.setLayout(new GridLayout(0, 2)); // using 0 rows gives infinite
		this.add(new JLabel("Bandwidth (hertz) "));
		this.bandwidthJSlider.setMinimum(BANDWIDTH_MIN);
		this.bandwidthJSlider.setMaximum(BANDWIDTH_MAX);
		this.bandwidthJSlider.setValue(0);
		this.bandwidthJSlider.setName(BANDWIDTH_SLIDER_NAME);
		this.add(this.bandwidthJSlider);

		this.add(new JLabel("Signal to Noise (db) "));
		this.signalToNoiseJSLider.setMinimum(SIGNAL_TO_NOISE_MIN);
		this.signalToNoiseJSLider.setMaximum(SIGNAL_TO_NOISE_MAX);
		this.signalToNoiseJSLider.setValue(0);
		this.signalToNoiseJSLider.setName(STN_SLIDER_NAME);
		this.add(this.signalToNoiseJSLider);

		this.add(new JLabel("Maximum Data Rate (bps) "));
		this.maxDataRateJSlider.setMinimum(MAXIMUM_DATA_RATE_MIN);
		this.maxDataRateJSlider.setMaximum(MAXIMUM_DATA_RATE_MAX);

		this.maxDataRateJSlider.setEnabled(false); // User cannot adjust this slider
		this.add(this.maxDataRateJSlider);

		this.setVisible(true);
	}

	/**
	 * this method connects the gui to the mathematical formula by using ChangeListner
	 */
	private void configureEvents() {

		ChangeListener changeListener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();

				double value = slider.getValue();

				if (slider.getName().equals(BANDWIDTH_SLIDER_NAME)) {
					ShannonsSliderPanel.this.controller.setBandWidth(value);
				} else {
					ShannonsSliderPanel.this.controller.setSignalToNoise(value);

				}

			}
		};

		this.bandwidthJSlider.addChangeListener(changeListener);
		this.signalToNoiseJSLider.addChangeListener(changeListener);

	}

	/**
	 *   this methods updates the jsliders to correspond to the data and sets the value entered
	 */
	@Override
	public void update(Observable o, Object arg) {

//		ShannonsModel model = (ShannonsModel) o;
		
		ShannonsTheorem shannonsTheorem = (ShannonsTheorem) this.controller;

		this.bandwidthJSlider.setValue((int)shannonsTheorem.getBandWidth());
		this.signalToNoiseJSLider.setValue((int)shannonsTheorem.getSignalToNoise());
		this.maxDataRateJSlider.setValue((int)shannonsTheorem.getMaximumDataRate());

	}

}