import java.util.*;
import java.io.*;
public class WczytywaczTxt implements Wczytywacz{
	
	public WczytywaczTxt(String str) throws IOException
	{
		rec=new ListOfRecords();
		file=new File(str);
		if(!file.canRead())throw new IOException("nie mozna przeczytac pliku");
		
		
	}
	public void wczytaj()throws IOException
	{
		Scanner in=null;
		try
		{
			in=new Scanner(file);
			while(in.hasNextLine())
			{
				String[]b=in.nextLine().split(";");
				if(b.length!=3)throw new IOException("Zly wymiar danych\n");
				rec.addRecord(b[0],b[1],b[2]);
			}
			
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("nie znaleziono pliku\n");
		}
		catch(IOException exe)
		{
			System.out.println(exe.getMessage());
		}
		finally
		{
			if(in!=null)in.close();
		}
	}
	public ListOfRecords getList()
	{
		return rec;
	}
	
	private File file;
	private ListOfRecords rec;

}
