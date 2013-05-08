import java.util.*;

public class Lab02  {
	
	
	public static void main(String[] args) {

		
		Wileomian f1=new Wileomian("2.0*x^3+10.0*x^2-1.0*x+3");
		f1.Wartosc(2.0,true);
		f1.calka(-2,2,100);
		f1.calka(-2,2,1000);
		f1.calka(-2,2,10000);


		
	}
	
}



class Wileomian
{
	public Wileomian(String wiel)
	{
		wilemian=wiel;
		int i=0;
		
		a=new Vector<Double>();
		a.add(new Double(0));
		a.add(new Double(0));
		a.add(new Double(0));
		a.add(new Double(0));
		while(wilemian.length()>0)
		{
			i=0;
			if(wilemian.contains("x"))
			{
				if (wilemian.contains("^")) {
					Double wspol=Double.valueOf(wilemian.substring(i,wilemian.indexOf("*")));
					i=wilemian.indexOf("*");
					int index=Integer.valueOf(wilemian.substring(i+3,i+4));
					wilemian=wilemian.substring(i+4);
					a.set(index,wspol);
					
				}
				else
				{
					Double wspol=Double.valueOf(wilemian.substring(i,wilemian.indexOf("*")));
					i=wilemian.indexOf("*");
					wilemian=wilemian.substring(i+2);
					a.set(1,wspol);

				}
				
			
					
			}
			else
			{
				Double wspol=Double.valueOf(wilemian.substring(i,i+2));
				wilemian=wilemian.substring(i+2);
				a.set(0,wspol);
			}
			
			


		}
		
		
		

	}
	public double Wartosc(double argument,boolean tryb){
		 double sum=0;
		 int i=0;

		for (Double x:a ) {
			sum=sum+x.doubleValue()*Math.pow(argument, (double) i);
			++i;
			//System.out.println(x.doubleValue());

			
		}

		if(tryb)System.out.printf("F(%1f)=%2f\n",argument,sum);
		return sum;
	}
	public double calka(double a,double b,int krok){

		double n=(b-a)/krok;
		double suma=0;

		double argument=a+n/2;
		
		for(int i=0;i<krok;++i)
		{
			suma=suma+Wartosc(argument,false)*n;
			argument+=n;

		}
		System.out.printf("calka(%1$4.2f,%2$4.2f)=%3$10.5f\n",a,b,suma);
		return suma;


		
	}
	private void umiesc(String ax)
	{
		if(ax.contains("x"))
		{
			if(ax.contains("^"))
			{
				// System.out.println();
				// System.out.println(); 
				a.set(Integer.valueOf(ax.substring(ax.indexOf("^")+1)),Double.valueOf(ax.substring(0,3)));
			}
			else
			{
				a.set(1,Double.valueOf(ax.substring(0,3)));
			}
			

		}else
		{
			a.set(0,Double.valueOf(ax));
		}
	}



	 private Vector<Double> a;
	 private String wilemian;
	

}