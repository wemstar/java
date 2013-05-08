import java.io.Serializable;
import java.util.*;
import java.io.*;

public class ListOfRecords implements Serializable{
	
	class Record implements Serializable
	{
		Record(String ime,String nazwisko,String wiek)
		{
			this.ime=ime;
			this.nazwsiko=nazwisko;
			this.wiek=Integer.valueOf(wiek);
			
		}
		private String ime;
		private String nazwsiko;
		private int wiek;
		public String toString()
		{
			StringBuffer buf=new StringBuffer();
			buf.append("Imie: ");
			buf.append(wiek);
			buf.append(" Nazwisko: ");
			buf.append(nazwsiko);
			buf.append(" Wiek: ");
			buf.append(wiek);
			
			
			return buf.toString();
			
		}
	}
	public String toString()
	{
		StringBuffer buf=new StringBuffer();
		for(Record rec:tab)
		{
			buf.append(rec.toString()+"\n");
		}
		return buf.toString();
		
	}
	public void addRecord(String name,String nazwisko,String wiek)
	{
		tab.add(new Record(name,nazwisko,wiek));
	}
	
	ArrayList<Record> tab=new ArrayList<Record>();

}
