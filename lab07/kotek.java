import java.util.*;
import java.awt.geom.*;

class kotek extends Obiekt {
	public kotek(int x,int y,Swiatlo poscig)
	{
		super(x,y);
		this.gon=poscig;
	}

	public void ruch()
	{
		Point2D.Double polozenie=getKord();
		Point2D.Double cel=gon.getKord();
		double x=Math.signum(polozenie.getX()-cel.getX())*(-1);
		double y=Math.signum(polozenie.getY()-cel.getY())*(-1);
		polozenie.setLocation(polozenie.getX()+x*vel.nextInt(8),polozenie.getY()+y*vel.nextInt(8));

	}


	Random vel=new Random();
	private Swiatlo gon;

}