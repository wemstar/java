

public class Lab01
{
	public static  void main(String[] argv)
	{
		int[] tmp={7,2,4,3,6,8,1,5,9,5,1,1};
		Tablica tab=new Tablica(100);
		System.out.println("liczba jest w mjejscu "+tab.start(3));
		
		

	}
};



;lskdflkas




class Tablica
{
	/**
	 * sdflkajlfjslkj
	 * @param  tablica
	 * @return
	 */
	public Tablica(int [] tablica)
	{
		c=tablica;
		drukuj(0,c.length);

	}
	public Tablica(int n)
	{
		c=new int[[n]];
		for(int i=0;i<n;++i)
		{
			c[i]=i;
		}

	}
	public int start(int k)
	{
		
		n=k;

		return zanjdzElement(0,c.length-1);

	}
	public int zanjdzElement(int a,int b){
		
		
		while(a!=b){
		int dzielnik =partition( a, b);
		dzielnik=dzielnik-a+1;
			if (c[a+dzielnik-1]>n) b=a+dzielnik-1;
			else
					{
						a+=dzielnik;
						mejesce+=dzielnik;
						System.out.println("mej "+mejesce+"dziel "+dzielnik);
					}
		}

		return mejesce;
		

		


	}
	public void drukuj(int poczatek,int koniec)
	{
		for(int i=poczatek;i<koniec;++i)
		{
			System.out.print(" "+c[i]);
		}
		System.out.println(" ");
	}
	public int partition( int a, int b)
	{
		System.out.print(" poczatek"+a+"koniec "+b+" tablica ");
		drukuj(0,c.length);
		int e,tmp;
		e=c[a];        //elemennt dzielacy
		
		

		while (a<b)
		{
			while ((a<b) && (c[b]>=e)) b--;
			while ((a<b) && (c[a]<e)) a++;
			if (a<b)
			{
				tmp=c[a];
				c[a]=c[b];
				c[b]=tmp;
			}
		}
		
		return a;
	}

	private int n;
	private int mejesce;
	private int[] c;


}