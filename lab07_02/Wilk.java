import java.awt.*;
import java.awt.geom.*;

class Wilk extends Ssak {

	public Wilk(double x,double y){
		super(x,y);
		setSeeRadius(30);
		setVelocity(3);
	}
	public boolean isPredator(){
		return true;
	}
	
}