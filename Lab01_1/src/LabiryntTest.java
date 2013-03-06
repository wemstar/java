
public class LabiryntTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Labirynt labirynt=new Labirynt(10,10);
		
		labirynt.dodajPrzeszkode(1,1,5,false);
		labirynt.dodajPrzeszkode(3, 4, 2, true);
		labirynt.wypisz();
		

	}

}
