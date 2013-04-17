import java.awt.*;
import java.awt.geom.*;

class Owca extends Ssak {
	
	public Owca(double x,double y){
		super(x,y);
		setSeeRadius(20);
		setVelocity(1);
	}
	public boolean isPredator()
	{
		return false;
	}

}