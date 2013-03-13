import java.util.*;

class Piasek  {
		
		public static void main(String[] args) {
			Pojemnik klepsydra=new Pojemnik(20,20,200);
			klepsydra.Start();
			
		}
}







class Pojemnik {

	public Pojemnik(int x,int y,int n){
		szerokosc=x-2;
		wysokosc=y-1;
		pojemnosc=n;
		tabMozliwe=new int[y][x];
		tabZiar=new ArrayList<Ziarnko>();
		for(int i=0;i<y;++i){
			tabMozliwe[i][0]=-5;
			tabMozliwe[i][x-1]=-5;
		}
		for (int i=0; i<x; ++i) {
			tabMozliwe[y-1][i]=-5;
			
		}

	}

	public void Start(){
		// Drukuj();
		for(int j=0;j<pojemnosc+20;++j)
		{
			if(j<pojemnosc)
			{
				tabZiar.add(new Ziarnko(rand.nextInt(szerokosc)+1));
			}
			for (Ziarnko ziar : tabZiar) {
				ziar.nextMove();
				
			}
			//Drukuj();


		}
		Drukuj();
		
	}

	public void Drukuj(){
		System.out.println();
		for (int[]a :tabMozliwe ) {
			for (int b : a) {
				System.out.print(String.format("%1$2d",b));
				
			}
			System.out.println();
		}
	}
	class Ziarnko {
		public Ziarnko(int ax){
			y=0;
			x=ax;
			tabMozliwe[y][x]=-1;

		}
		public boolean hasNextMove(int x_1,int y_1){
			if(x_1<szerokosc && y_1 < wysokosc && x_1>0)
			{
				if (tabMozliwe[y_1][x_1]<0)return false;
								return true; 
			}
			return false;
			
			
		
				
			


		}
		public void nextMove(){
			if(hasNextMove(x,y+1))
			{
				Przemesc(x,y+1);
				
			}
			else 
			{
				if(rand.nextInt(1)==0)
				{
					if(hasNextMove(x+1,y+2))
					{
						Przemesc(x+1,y+2);
					}else if(hasNextMove(x-1,y+2))
					{
						Przemesc(x-1,y+2);
					}
					
				}
				else
				{
					if(hasNextMove(x-1,y+2))
					{
						Przemesc(x-1,y+2);
					}else if(hasNextMove(x+1,y+2))
					{
						Przemesc(x+1,y+2);
					}
				}
				


			}
		}
		public void Przemesc(int x_1,int y_1)
		{
			tabMozliwe[y][x]=0;
				y=y_1;
				x=x_1;
			tabMozliwe[y][x]=-1;

		}

		private int x;
		private int y;
		
	}
	Random rand=new Random();
	private int szerokosc;
	private int wysokosc;
	private int pojemnosc;
	private int[][] tabMozliwe;
	private ArrayList<Ziarnko> tabZiar;
	
}