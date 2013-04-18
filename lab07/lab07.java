import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;


public class lab07
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new lab07Frame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}
}

class lab07Frame extends JFrame
{
	lab07Frame()
	{
		setTitle("lab07");
		setSize(DEFAULT_HEIGHT,DEFAULT_WIDTH);
		lab07Component component=new lab07Component();
		add(component);
		Swiatlo cel=new Swiatlo(400,500,10);
		component.add(cel);
		Random losowacz=new Random();
		for(int i=0;i<losowacz.nextInt(25);++i)
		{
			component.add(new kotek(losowacz.nextInt(800),losowacz.nextInt(800),cel) );
		}

	}




	private static final int DEFAULT_HEIGHT=800;
	private static final int DEFAULT_WIDTH=800;

}

class lab07Component extends JComponent
{
	public lab07Component()
	{
		new javax.swing.Timer(100 ,new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				for(Obiekt obj: tab)
				{
					obj.ruch();
				}
				repaint();
				
			}
		}).start();
	}
	public void paint(Graphics g)
	{
		 Graphics2D g2=( Graphics2D)g;
		 g2.setPaint(Color.yellow);
		 for(Obiekt obj:tab){
		 	g2.fill(new Ellipse2D.Double(obj.getKord().getX(),obj.getKord().getY(),25,25));
		 	g2.setPaint(Color.black);
		 }
	}
	public void add(Obiekt obj)
	{
		tab.add(obj);

	}


	private Vector<Obiekt> tab=new Vector<Obiekt>();
}