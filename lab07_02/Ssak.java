import java.awt.*;
import java.awt.geom.*;
import java.util.*;

abstract class Ssak 
{
	public Ssak(double x,double y){
		wsp=new Point2D.Double(x,y);
		buddies=null;
	}
	

	public void setBuddies(Ssak bud){ buddies=bud;}
	public Ssak getBuddies(){return buddies;}
	abstract public boolean isPredator();

	public double velocity(){ return velocity;}
	public void setVelocity(double v){velocity=v;}

	public void setSeeRadius(double r){radius=r;}
	public double seeRadius(){return radius;}

	public Point2D.Double kordy(){return wsp;}
	public void setChase(boolean c){chase=c;}
	public void nextMove()
	{
		if(buddies != null){
			scigaj();
		
		}
		else {
			randomMove();
		}
	}
	private void randomMove()
	{
		int kierunek=skok.nextInt(8);
		switch (kierunek) {
			case 0:
				wsp.setLocation(wsp.getX(),wsp.getY()+velocity);
				break;
			case 1:
				wsp.setLocation(wsp.getX()+velocity,wsp.getY()+velocity);
				break;
			case 2:
				wsp.setLocation(wsp.getX()+velocity,wsp.getY());
				break;
			case 3:
				wsp.setLocation(wsp.getX()+velocity,wsp.getY()-velocity);
				break;
			case 4:
				wsp.setLocation(wsp.getX(),wsp.getY()-velocity);
				break;
			case 5:
				wsp.setLocation(wsp.getX()-velocity,wsp.getY()-velocity);
				break;
			case 6:
				wsp.setLocation(wsp.getX()-velocity,wsp.getY());
				break;
			case 7:
				wsp.setLocation(wsp.getX()-velocity,wsp.getY()+velocity);
				break;
			}
	}
	void scigaj()
	{
		double x=Math.signum(wsp.getX()-buddies.wsp.getX());
		double y=Math.signum(wsp.getY()-buddies.wsp.getY());

		if(chase){
			x=x*(-1);
			y=y*(-1);
		}
		wsp.setLocation(wsp.getX()+x*velocity,wsp.getY()+y*velocity);
		System.out.print("scigam :"+buddies);
	}

	private boolean chase;

	private Ssak buddies;

	private double radius;

	private double velocity;

	private Point2D.Double wsp;

	private Random skok=new Random();
}