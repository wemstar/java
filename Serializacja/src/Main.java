import javax.swing.*;

import java.awt.*;
import java.awt.event.*;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				buildGui();
			}
		});
			
		

	}
	private static void buildGui()
	{
		final GameContoler controler=new GameContoler();
		JFrame frame=new JFrame();
		JPanel buttonPanel=controler.loadPanel();
		frame.add(buttonPanel);
		frame.setSize(400,400);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt) {
				
				controler.save();
				
				    System.exit(0);
				
				  }

			
		});
		
		
		
		
		frame.setVisible(true);
		
	}
	

}
