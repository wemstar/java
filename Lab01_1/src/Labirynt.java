

/**
 * 
 * @author wemstar
 * klasa tworzy labirynt
 *
 */
public class Labirynt {

	
	/**
	 * 
	 * @param x wysokośc
	 * @param y szerokość
	 */
	public Labirynt(int x,int y)
	{
		labir=new int[y][x];
		szerokosc=x;
		wysokosc=y;
		
	}
	public void dodajPrzeszkode(int x,int y,int dl,boolean kierunek)
	{
		if(x>wysokosc || x<0||y>szerokosc || y<0) return;
		if(kierunek==false &&(x+dl>szerokosc))return;
		else if(y+dl>wysokosc)return;
		
		if(kierunek==false)
		{
			for(int i=0;i<dl;i++)
			{
				labir[y][x+i]=-2;
			}
		}else
		{
			for(int i=0;i<dl;i++)
			{
				labir[y+i][x]=-2;
			}
			
		}
		
	}
	public void wypisz()
	{
		System.out.println(toString());
		
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<wysokosc;++i)
		{
			for(int j=0;j<szerokosc;j++)
			{
				s+=  String.format(" %,2d", labir[i][j]);



			}
			s+="\n";
		}
		return s;
		
	}
	
	private int[][] labir;
	private int wysokosc;
	private int szerokosc;
	

}
