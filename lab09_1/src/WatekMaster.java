import java.util.*;
import java.util.concurrent.CyclicBarrier;
public class WatekMaster {
	
	 private int n,i;
	 private List<Watki> tab=new ArrayList<Watki>();
	 private CyclicBarrier barier;
	 private double suma=0;
	 private static final int count=100;
	
	
	
	public WatekMaster(String str)
	{
		
		n=Integer.valueOf(str);
		 i=(int)Math.round(count/n);
		barier=new CyclicBarrier(n); 
		
		
	}
	public void start()
	{
		Watki watek;
		for(int j=0;j<n-1;j++)
		{
			watek=new Watki(j*i,(j+1)*i-1,barier);
			tab.add(watek);
			watek.start();
		}
		watek=new Watki(i*(n-2),count,barier);
		tab.add(watek);
		watek.start();
		for(Watki wat:tab)
		{
			try {
				wat.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			suma+=wat.getSuma();
			System.out.println("suma z watku "+wat.getSuma());
		}
		System.out.print("suma całkowita to "+suma);
	}

}
