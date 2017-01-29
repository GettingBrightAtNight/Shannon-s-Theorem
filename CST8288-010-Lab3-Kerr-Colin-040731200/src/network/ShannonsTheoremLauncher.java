package network;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.util.Observer;

public class ShannonsTheoremLauncher {
	
	public static void main(String[] args) {
		
		ShannonsTheorem controller = new ShannonsTheorem();
		
		ShannonsTextPanel textView = new ShannonsTextPanel(controller);
		ShannonsSliderPanel sliderView = new ShannonsSliderPanel(controller);
		ShannonsGraphicPanel graphicView = new ShannonsGraphicPanel(controller);
		controller.addObserver(textView);
		controller.addObserver(sliderView);
		controller.addObserver(graphicView);
		JFrame frame = new JFrame("Shanons Theorem");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 1));
		frame.getContentPane().add(textView);
		frame.getContentPane().add(sliderView);
		frame.getContentPane().add(graphicView);
		frame.setVisible(true);

	}

}
