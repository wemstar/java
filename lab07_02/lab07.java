import java.awt.*;
import java.awt.geom.*;

class lab07 {
	
	public static void main(String[] args) {
		

		Pastwisko pole=new Pastwisko(100,100);
		pole.add(new Owca(1,1));
		pole.add(new Wilk(0,25));
		
		pole.orzyj();
		
	}
}