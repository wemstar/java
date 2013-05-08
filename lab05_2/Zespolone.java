


public class Zespolone {

	public Zespolone(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	public Zespolone dodaj(Zespolone other)
	{
		this.x+=other.x;
		this.y+=other.y;
		return this;
	}
	public Zespolone odejmij(Zespolone other)
	{
		this.x-=other.x;
		this.y-=other.y;
		return this;
	}
	public Zespolone pomnoz(Zespolone other)
	{
		this.x=this.x*other.x-this.y*other.y;
		this.y=this.x*other.y+this.y*other.x;
		return this;
	}
	public Zespolone podziel(Zespolone other) throws ArithmeticException
	{
		double dzielnik=other.x*other.x+other.y*other.y;
		if(dzielnik==0)throw new ArithmeticException("dzielenie zero");
		Zespolone nowa=pomnoz(other);
		x/=dzielnik;
		y/=dzielnik;
		return this;

	}
	public String toString()
	{
		return "".format("z = %1$6.3f + %2$6.3fi",x,y);
	}





	private double x;
	private double y;
	public static void main(String[] args) {
		Zespolone nowa=new Zespolone(2.58,2.98);
		System.out.println(nowa);
		nowa.dodaj(new Zespolone(1.5,8.5));
		System.out.println(nowa);
		nowa.odejmij(new Zespolone(1.5,8.5));
		System.out.println(nowa);
		nowa.pomnoz(new Zespolone(2.5,50.5));
		System.out.println(nowa);
	}

	
}