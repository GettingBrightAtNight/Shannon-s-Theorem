/*
 *  @(#)ShannonsTheorem.java   1.0 YY/MM/DD
 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 */

package network; /*	Package for class placement	*/

import java.text.DecimalFormat;
import java.util.Observer;

import javax.swing.JOptionPane;

/**
 * Takes user input and does calculation for Shannon's theorem and outputs the
 * answer.
 * 
 * @author Colin Kerr
 * @version 1.0.0 November 1st, 2015
 */

public class ShannonsTheorem implements ShannonsController {

	private ShannonsModel model;

	public ShannonsTheorem() {
		super();
		model = new ShannonsModel();
	}

	public double getBandWidth() {
		return model.getBandWidth();
	}

	public double getSignalToNoise() {
		return model.getSignalToNoise();
	}

	public void setBandWidth(double h) {
		model.setBandWidth(h);
	}

	public void setSignalToNoise(double snr) {
		model.setSignalToNoise(snr);
	}

	public double getMaximumDataRate(){
		return model.getMaximumDataRate();
	}
	
	public void start() {

		boolean hasError = false;
		do {
			double result = 0;
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			// first way for try catch
			try {
				model.setBandWidth(Double.parseDouble(JOptionPane
						.showInputDialog(null, "Enter the Bandwidth: ")));
				hasError = false;
			} catch (NumberFormatException nfex) {
				hasError = true;
				do {
					try {
						model.setBandWidth(Double.parseDouble(JOptionPane
								.showInputDialog(null,
										"Invalid.  Enter the bandwidth: ")));
						hasError = false;
					} catch (NumberFormatException nfex2) {
						hasError = true;
					}
				} while (hasError);
			}
			// Second way
			String message = "Enter the Signal to Noise Ratio: ";
			hasError = false;
			do {
				try {
					model.setSignalToNoise(Double.parseDouble(JOptionPane
							.showInputDialog(null, message)));
					hasError = false;
				} catch (NumberFormatException nfex) {
					if (!message.contains("Invalid! ")) {
						message = "Invalid! " + message;
					}
					hasError = true;
				}
			} while (hasError);
			result = model.getMaximumDataRate();
			JOptionPane.showMessageDialog(null, "Your result is "
					+ decimalFormat.format(result));
		} while (!JOptionPane.showInputDialog(null, "Enter N to exit")
				.toUpperCase().equals("N"));
	}

	public static void main(String args[]) {
		ShannonsTheorem app = new ShannonsTheorem();
		app.start();
	}

	@Override
	public void addObserver(Observer observer) {
		
		this.model.addObserver(observer);

	}

} /* End of CLASS: ShannonsTheorem.java */