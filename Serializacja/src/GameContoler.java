import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GameContoler {
	
	public GameContoler()
	{
		
		serial=new GameSerialize();
		
	}
	
	public JPanel loadPanel()
	{
		
		ActionListener listener=new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JButton buton=(JButton)e.getSource();
				buton.setText(kolejka);
				kolejka=kolejka=="X"?"O":"X";
			}
		};
		panel=serial.load();
		for(Component com:panel.getComponents())
		{
			JButton buton=(JButton)com;
		buton.addActionListener(listener);
		}
		return panel;
		
	}
	public void save()
	{
		serial.save(panel);
	}
	
	
	
	private JPanel panel;
	private GameSerialize serial;
	private String kolejka="X";

}
