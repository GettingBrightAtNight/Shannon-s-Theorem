package network;

import java.util.Observable;

public class ShannonsModel extends Observable {

	private double bandwidth;
	private double signalToNoise;

	/* ACCESSORS ----------------------------------------------------- */
	/**
	 * Returns the bandwidth
	 */

	public ShannonsModel() {
		this.bandwidth = 0;
		this.signalToNoise = 0;
	}

	public double getBandWidth() {
		return this.bandwidth;

	}// returns signaltonoise

	public double getSignalToNoise() {
		return this.signalToNoise;
	}

	public void setBandWidth(double h) {
		this.bandwidth = h;
		this.setChanged();
		this.notifyObservers();
		
	}

	public void setSignalToNoise(double snr) {
		this.signalToNoise = snr;
		this.setChanged();
		this.notifyObservers();
	}
	

	private double getMaximumDataRate(double hertz, double signalToNoise) {
		return (hertz * (Math.log(1 + Math.pow(10, signalToNoise / 10)) / Math
				.log(2))); // perform mathematical formula
	}

	public double getMaximumDataRate() {
		return (this.bandwidth * (Math.log(1 + Math.pow(10,
				this.signalToNoise / 10)) / Math.log(2)));

	}
	@Override
	public String toString(){
		return "B = " + bandwidth + " S/N = " + signalToNoise + " Max D/R = " + getMaximumDataRate();
		
		
	}
	
}