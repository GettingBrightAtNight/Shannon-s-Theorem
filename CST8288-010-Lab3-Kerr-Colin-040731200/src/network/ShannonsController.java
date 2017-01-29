package network;

import java.util.Observer;

public interface ShannonsController {

	public void addObserver(Observer observer);
	
	public void setBandWidth(double bandwidth);
	
	public void setSignalToNoise(double signalToNoise);
	
}
