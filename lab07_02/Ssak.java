abstract class Ssak 
{
	public Ssak(double x,double y){
		wsp=new Point2D.Double(x,y);
	}
	public void idz(Point2D.Double range){

		int kierunek=skok.nextInt(8);
		switch (kierunek) {
			case 0:
				wsp.setLocation(wsp.getX(),wsp.getY()+3);
				break;
			case 1:
				wsp.setLocation(wsp.getX()+3,wsp.getY()+3);
				break;
			case 2:
				wsp.setLocation(wsp.getX()+3,wsp.getY());
				break;
			case 3:
				wsp.setLocation(wsp.getX()+3,wsp.getY()-3);
				break;
			case 4:
				wsp.setLocation(wsp.getX(),wsp.getY()-3);
				break;
			case 5:
				wsp.setLocation(wsp.getX()-3,wsp.getY()-3);
				break;
			case 6:
				wsp.setLocation(wsp.getX()-3,wsp.getY());
				break;
			case 7:
				wsp.setLocation(wsp.getX()-3,wsp.getY()+3);
				break;
				
			
			
		}

	}

	public void setBuddies(Ssak bud){ buddies=bud;}
	abstract public boolean isPredator();
	public double velocity(){ return velocity;}
	public void setVelocity(double v){velocity=v;}

	public void setSeeRadius(double r){radius=r;}

	public double seeRadius(){return radius;}
	public Point2D.Double kordy(){return wsp;}


	private boolean chase;
	private SSak buddies;
	private double radius;
	private double velocity;
	private Point2D.Double wsp;
	private Random skok=new Random();
}