package Armia;
import java.util.*;


interface Czolg extends Parent {
	
}
public class Czolg  {


	public String ostatniRozkaz(){
		return new String("Ostatni Rozkaz: ")+rozkazy.lastElement().toString();
	}
	public void dodajRozkaz(Rozkaz polecenie)
	{
		rozkazy.add(polecenie);

	}
	public String toString()
	{
		StringBuilder lista=new StringBuilder();


		for (Rozkaz roz : rozkazy) {
			lista.append(roz);
			
		}
		return lista.toString();
	}


	private Vector<Rozkaz> rozkazy=new Vector<Rozkaz>();
	
}