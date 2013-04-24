import java.awt.geom.*;
import java.util.*;

abstract class Ssak {
	
	public Ssak(double x,double y,int vel,int zasieg)
	{
		punkt=new Point2D.Double(x,y);
		chase=null;
		velo=vel;
		radius=zasieg;
		zjedz=false;
	}

	/**
	 * funkcje przemieszczjace
	 */
	public void ruch()
	{
		if(chase != null)chaseMove();
		else randomMove();

	}
	private void randomMove(){

		double x=punkt.getX()+2*los.nextInt(velo)-velo;
		double y=punkt.getY()+2*los.nextInt(velo)-velo;
		x=x>800?x-800:x;
		y=y>800?y-800:y;
		x=x<0?x+800:x;
		y=y<0?y+800:y;

		punkt.setLocation(x,y);

		// if(isValid(nowy))punkt=nowy;
		// else randomMove();
	}
	private void chaseMove(){
		double x= Math.signum((int)(punkt.getX()-chase.punkt.getX()));
		double y= Math.signum((int)(punkt.getY()-chase.punkt.getY()));
		x=chase.isPredator()?(-1)*x:x;
		y=chase.isPredator()?(-1)*y:y;

		punkt.setLocation(punkt.getX()-x*velo,punkt.getY()-y*velo);


	}

	private boolean isValid(Point2D.Double x){return true;}
	abstract boolean isPredator();



	/**
	 * getery i setery
	 */
	public void setBuddies(Ssak a)
	{
		chase=a;
	}
	public void resetBuddies(){chase=null;}

	public int rad(){return radius;}
	

	public Point2D.Double getPosition(){return punkt;}
	public void zjedzony(){zjedz=true;}
	public boolean isZjedzony(){return zjedz;}
	
	/**
	 * zmienne prywatne
	 */

	private int velo;
	private Ssak chase;
	private int radius;
	private boolean zjedz;




	private Random los=new Random();
	private Point2D.Double punkt;
}