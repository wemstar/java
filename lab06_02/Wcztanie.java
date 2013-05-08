import java.io.*;
import java.util.*;


class Wcztanie {
	public static void main(String[] args) {
		
		try
		{

			Wczytywacz czytacz =new Wczytywacz("test.txt");
			czytacz.oblicz();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

class Wczytywacz {

	Wczytywacz(String plik) throws Exception
	{
		File fil=new File(plik);
		try
		{
			if(!fil.exists())throw new NoFileException(plik);
			if(!fil.canRead())throw new CantReadException(plik);
			Scanner czytacz=new Scanner(fil);
			while(czytacz.hasNext())
			{
				if(czytacz.hasNextDouble())
				{
					tab.add(new Double(czytacz.nextDouble()));

				}
				else
				{
					throw new BadValueException(czytacz.next());
				}

			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;

			
		}
	}
	void oblicz()
	{
		new Liczydlo(tab).srednia();

	}


	Vector<Double> tab=new Vector<Double>();
	
}
class Liczydlo {
	Liczydlo(Vector<Double> tab)
	{
		this.tab=tab;
	}


	double srednia()
	{
		double suma=0;
		for (Double a :tab ) {

			suma+=a.doubleValue();
			
		}
		double srednia=suma/tab.size();
		System.out.print(String.format("%1$5.3f\n",srednia));
		return srednia;
	}
	Vector<Double> tab;
}


class NoFileException extends Exception {
	NoFileException(String str)
	{
		super(str);
	}
}
class BadValueException extends Exception {
	BadValueException(String str)
	{
		super(str);
	}
}
class CantReadException extends Exception {
	CantReadException(String str)
	{
		super(str);
	}
}