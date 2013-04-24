import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;







class Pastwisko extends JFrame
{
	
	Pastwisko()
	{
		setTitle("Pastwisko");
		setSize(DEFAULT_HEIGHT,DEFAULT_WIDTH);
		PastwiskoComponent component=new PastwiskoComponent();
		add(component);
		
		
		Random losowacz=new Random();
		for(int i=0;i<losowacz.nextInt(25)+25;++i)
		{
			component.add(new Owca(losowacz.nextDouble()*DEFAULT_WIDTH,losowacz.nextDouble()*DEFAULT_HEIGHT) );
		}
		for(int i=0;i<losowacz.nextInt(5)+1;++i)
		{
			component.add(new Wilk(losowacz.nextDouble()*DEFAULT_WIDTH,losowacz.nextDouble()*DEFAULT_HEIGHT) );
		}

	}




	private static final int DEFAULT_HEIGHT=800;
	private static final int DEFAULT_WIDTH=800;
	




	
}


