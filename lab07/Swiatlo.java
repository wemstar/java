import java.awt.geom.*;



class Swiatlo extends Obiekt {
	

	public Swiatlo(double x,double y,double rad){
		super(x,y);
		angle=Math.PI;
		this.rad=rad;
	}
	public void ruch(){


		Point2D.Double pkt=getKord();
		angle+= Math.PI*0.025;
		double x=rad*Math.cos(angle);
		double y=rad*Math.sin(angle);
		pkt.setLocation(pkt.getX()+x,pkt.getY()+y);


	}
	double angle;
	double rad;
}