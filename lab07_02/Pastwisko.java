import java.util.*;
import java.awt.*;

import java.awt.*;
import java.awt.geom.*;


class Pastwisko {

	public Pastwisko(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void add(Ssak zwierze){
		zwierzyniec.add(zwierze);
	}
	
	private void idz(Ssak zwierze){

		
				
			
			
		zwierze.nextMove();
		znormalizuj(zwierze);
		findBuddies();


	}
	public void orzyj()
	{
		for (int i=0; i<10;++i ) {
			for (Ssak a :zwierzyniec ) {
				idz(a);
				System.out.println("zwierze: "+a+" kordy: "+a.kordy());
				
			}
			
		}
	}
	public void chase(Ssak zwierze)
	{
		Ssak buddies=zwierze.getBuddies();


	}
	private void znormalizuj(Ssak zwierze)
	{
		Point2D.Double wsp=zwierze.kordy();
		if(wsp.getX()>x){wsp.setLocation(wsp.getX()-x,wsp.getY());}
		if(wsp.getY()>y){wsp.setLocation(wsp.getX(),wsp.getY()-y);}
		if(wsp.getX()<0){wsp.setLocation(wsp.getX()+x,wsp.getY());}
		if(wsp.getY()<0){wsp.setLocation(wsp.getX(),wsp.getY()+y);}


	}
	void findBuddies()
	{
		for (Ssak a: zwierzyniec) {
			for ( Ssak b:zwierzyniec ) {
				if(a!=b)
				{
					if(a.seeRadius()>(a.kordy().distance(b.kordy())))
					{
						
						if(a.isPredator()&& !b.isPredator())
						{
							a.setBuddies(b);
							a.setChase(true);


						}
						else if(!a.isPredator()&&!b.isPredator())
						{
							a.setBuddies(b);
							a.setChase(true);
						}
						else if (!a.isPredator()&&b.isPredator()) {
							a.setBuddies(b);
							a.setChase(true);

							
						}
					}
				}
				
			}
			
		}

	}




	private int x;
	private int y;
	private Vector<Ssak> zwierzyniec=new Vector<Ssak>();

	
}