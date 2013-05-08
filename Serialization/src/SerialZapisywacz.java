import java.io.*;



public class SerialZapisywacz {
	public SerialZapisywacz(String str,ListOfRecords lista)
	{
		
		file=new File(str+".ser");
		list=lista;
	}
	public void zapisz()throws IOException
	{
		
		ObjectOutputStream stream=null;
		try
		{
			if(!file.exists())file.createNewFile();
			stream=new ObjectOutputStream(new FileOutputStream(file));
			stream.writeObject(list);
			
		}
		
		finally
		{
			if(stream!=null)stream.close();
		}
	}
	
	
	
	private File file;
	private ListOfRecords list;

}
