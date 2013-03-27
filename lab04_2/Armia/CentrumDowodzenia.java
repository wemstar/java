package Armia;
import java.util.*;

public class CentrumDowodzenia  {

	public CentrumDowodzenia()
	{

	}




	public void zarejestrujCzolg(Czolg tank){
		dywizja.add(tank);
	}
	public void wydajRozkaz(String czolg,Rozkaz polecenie){
		int ktory=Integer.valueOf(czolg);
		dywizja.elementAt(ktory-1).dodajRozkaz(polecenie);
	}
	public String toString()
	{
		StringBuilder lista=new StringBuilder();
		lista.append("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n");
		int i=1;
		for (Czolg a:dywizja ) {
			lista.append(String.format("Czolg nr %1$d otrzymal rozkazy:\n",i));
			lista.append(a);
			++i;

			
		}
		return lista.toString();
	}




	private Vector<Czolg> dywizja=new Vector<Czolg>();
	
}