import java.awt.geom.*;





abstract class Obiekt {
	
	public Obiekt(double x,double y){
		polozenie=new Point2D.Double(x,y);
	}
	abstract public void ruch();
	public Point2D.Double getKord(){return polozenie;}






	private Point2D.Double polozenie;







}