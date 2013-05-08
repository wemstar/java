import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;



class PastwiskoComponent extends JComponent
{


	public PastwiskoComponent(){
		new javax.swing.Timer(100,new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				for (Ssak zwierz :zwierzeta ) {
					zwierz.ruch();
					findBuddies(zwierz);
			
				}
				repaint();
				


			}
		}).start();
		
	}
	public void paint(Graphics g)
	{
		 Graphics2D g2=( Graphics2D)g;
		 
		 for(Ssak obj:zwierzeta){
		 	if(!obj.isZjedzony())
		 	{
		 		if(obj.isPredator())g2.setPaint(Color.red);
		 		else g2.setPaint(Color.black);
		 		g2.fill(new Ellipse2D.Double(obj.getPosition().getX()-10,obj.getPosition().getY()-10,20,20));
		 		g2.draw(new Ellipse2D.Double(obj.getPosition().getX()-obj.rad()/2,obj.getPosition().getY()-obj.rad()/2,obj.rad(),obj.rad()));
		 	}
		 }
	}

	public void add(Ssak zwierz)
	{
		zwierzeta.add(zwierz);
	}
	
	public void drukuj()
	{
		for (Ssak zwierz :zwierzeta ) {

			System.out.println(zwierz.getPosition());
			
		}
	}
	private void findBuddies(Ssak zwierz)
	{
		for (Ssak a :zwierzeta ) {

			if(a!=zwierz)
			{
				double odleg=zwierz.getPosition().distance(a.getPosition());
				if(odleg<zwierz.rad())
				{
					if(!a.isPredator())
						zwierz.setBuddies(a);
					if(zwierz.isPredator()&&!a.isPredator() &&odleg<10)
					{
						a.zjedzony();
						
						
						
					}
				}
				else
				{

					zwierz.resetBuddies();
				}
			}
			
		}
	}


	
private Vector<Ssak> zwierzeta=new Vector<Ssak>();

}