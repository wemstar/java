import java.io.*;
public class MainSeiral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length==1)
		{
			
			if(args[0].endsWith(".txt"))
			{
				readerPlik(args[0]);
				
			}
			else if(args[0].endsWith(".ser"))
			{
				streamOutputPlik(args[0]);
			}
			
		}
		else
		{
			System.out.print("bład pliku");
		}
		if(lista!=null)
		{
			zapiszPlik(args[0].substring(0,args[0].indexOf(".")));
		}

	}

	private static void zapiszPlik(String str) {
		
		try
		{
			SerialZapisywacz zapisz=new SerialZapisywacz(str,lista);
			zapisz.zapisz();
			
		}
		catch(IOException e)
		{
			System.out.print("Bład zapis u");
		}
		
		
	}

	private static void streamOutputPlik(String string) {
		try
		{
			Wczytywacz wczyt=new WczytywaczSerial(string);
			wczyt.wczytaj();
			lista=wczyt.getList();
			System.out.println(""+lista);
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			
		}
		
	}

	private static void readerPlik(String string) {
		
		try{
			Wczytywacz wczyt=new WczytywaczTxt(string);
			wczyt.wczytaj();
			lista=wczyt.getList();
			System.out.println(""+lista);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			
		}
		
	}
	public static ListOfRecords lista=null;

}
