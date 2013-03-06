/**
 * 
 * @author wemstar
 * klasa podroznika po labiryncie
 *
 */
public class Podroznik {
	
	/**
	 * 
	 * @param lab labirynt do przejscia
	 */
	public Podroznik(Labirynt lab)
	{
		labirynt=lab;
		polozenie[0]=0;
		polozenie[1]=0;
		labirynt.ustawWartosc(polozenie[0], polozenie[1], -1);
		przeszedl=false;
		
		
	}
	public void przejdz(int x,int y)
	{
		
	
		if(przeszedl)return;
		else{
		if(labirynt.koniec(x,y)){przeszedl=true; 	labirynt.wypisz();}
		labirynt.ustawWartosc(x, y, -1);
		
		
		if(labirynt.moznaRuszyc(x+1,y)) przejdz(x+1,y);
		if(przeszedl)return;
		if(labirynt.moznaRuszyc(x,y+1)) przejdz(x,y+1);
		if(przeszedl)return;
		if(labirynt.moznaRuszyc(x-1,y)) przejdz(x-1,y);
		if(przeszedl)return;
		if(labirynt.moznaRuszyc(x,y-1)) przejdz(x,y-1);
		
		}
	 labirynt.ustawWartosc(x, y, -8);
		
		
	}
	 public void  start()
	{
		przejdz(0,0);
	}
	private boolean przeszedl;
	private int[] polozenie=new int[2];
	private Labirynt labirynt;

}
