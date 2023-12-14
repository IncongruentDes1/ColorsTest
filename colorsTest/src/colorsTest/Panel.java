package colorsTest;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Panel extends JFrame{
	// - Object set up
	ClickablePanel mainPanel = new ClickablePanel();
	
	
	public Panel(String name) {
		// - adding initial set up
		this.setTitle(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		

		
	}
}
