import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;


class lab07 {
	
	public static void main(String[] args) {
		
	EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new Pastwisko();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});
		
		
	}
}