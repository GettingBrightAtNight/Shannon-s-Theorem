package network;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ShannonsTextPanel extends JPanel implements Observer, ActionListener {

	private static final String BANDWIDTH_TEXTBOX_NAME = "Bandwidth";
	private static final String STN_TEXTBOX_NAME = "Signal to Noise";
	private static final String bandwidthLabelText = "Bandwidth (hertz)";
	private ShannonsController controller;
	private JTextField maxDataRateJTextField;
	private JTextField bandwidthTextField;
	private JTextField signalToNoiseJTextField;

	
	public ShannonsTextPanel(ShannonsController controller) {

		this.controller = controller;
		this.maxDataRateJTextField = new JTextField();
		this.bandwidthTextField = new JTextField();
		this.signalToNoiseJTextField = new JTextField();
		this.assembleUserInterface();
		this.configureEvents();

	}

	/**
	 * This method updates the the text fields 
	 */
	@Override
	public void update(Observable o, Object arg) {

		ShannonsTheorem shannonsTheorem = (ShannonsTheorem) this.controller;
		
		String band = String.valueOf(shannonsTheorem.getBandWidth());
		this.bandwidthTextField.setText(band);
		
		String sigToNoise = String.valueOf(shannonsTheorem.getSignalToNoise());
		this.signalToNoiseJTextField.setText(sigToNoise);
		
		String max = SingleDecimal.INSTANCE.format(shannonsTheorem.getMaximumDataRate());
		this.maxDataRateJTextField.setText(max);

	}

	/**
	 * this method sets up all the textfields of the GUI
	 */
	private void assembleUserInterface() {

		// setsup grid layout columns and rows to 3 rows, 2 columns
		this.setLayout(new GridLayout(3, 2));

		// bandwidth row
		this.add(new JLabel(bandwidthLabelText)); // different way to use label
													// text
		// setup bandwidth textfield
		this.bandwidthTextField.setName(BANDWIDTH_TEXTBOX_NAME);
		this.add(this.bandwidthTextField);

		this.add(new JLabel("Signal to Noise (db)"));
		this.signalToNoiseJTextField.setName(STN_TEXTBOX_NAME);
		this.add(this.signalToNoiseJTextField);

		this.add(new JLabel("Maximum Data Rate (bps)"));
		// setup maxDataRate textfield
		this.maxDataRateJTextField.setEditable(false);

		this.add(this.maxDataRateJTextField);

		this.setVisible(true);

	}

	/**
	 *  this method uses the actionListener interface to process an action event
	 *  It also does error checking via a try/catch to ensure only numbers are entered
	 *  by the usre
	 */
	private void configureEvents() {

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField textField = (JTextField) e.getSource();

				try {

					double value = Double.parseDouble(textField.getText());

					if (textField.getName().equals(BANDWIDTH_TEXTBOX_NAME)) {
						ShannonsTextPanel.this.controller.setBandWidth(value);
					} else {
						ShannonsTextPanel.this.controller
								.setSignalToNoise(value);
					}

				} catch (NumberFormatException nfe) {

					JOptionPane.showMessageDialog(ShannonsTextPanel.this,
							"Enter only numbers for " + textField.getName());

				}
			}
		};

		this.bandwidthTextField.addActionListener(actionListener);
		this.signalToNoiseJTextField.addActionListener(actionListener);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField textField = (JTextField) e.getSource();

		{

		}

	}

}