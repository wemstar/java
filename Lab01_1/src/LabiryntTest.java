
public class LabiryntTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Labirynt labirynt=new Labirynt(10,10);
		
		labirynt.dodajPrzeszkode(1,1,5,false);
		labirynt.dodajPrzeszkode(6,0,5,true);
		labirynt.dodajPrzeszkode(3, 4, 2, true);
		labirynt.wypisz();
		Podroznik Indiana=new Podroznik(labirynt);
		
		Indiana.start();
		labirynt.wypisz();
		

	}

}
