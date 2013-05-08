import java.io.*;


public class WczytywaczSerial implements Wczytywacz {

	public WczytywaczSerial(String str) throws IOException
	{
		rec=new ListOfRecords();
		file=new File(str);
		if(!file.canRead())throw new IOException("nie mozna przeczytac pliku");
		
	}
	@Override
	public void wczytaj()throws IOException {
		
		ObjectInputStream stream=null;
		try
		{
			stream=new ObjectInputStream(new FileInputStream(file));
			rec=(ListOfRecords)stream.readObject();
		}
		catch(IOException exe)
		{
			System.out.print("Bład wczytywania");
			
		}
		catch(ClassNotFoundException exe)
		{
			System.out.println("Nie znaleziono klasy");
		}
		finally
		{
			if(stream!=null)stream.close();
		}

	}

	@Override
	public ListOfRecords getList() {
		return rec;
	}

	private File file;
	private ListOfRecords rec;
}
