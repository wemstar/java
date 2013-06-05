import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Watki extends Thread {

	private int start;
	private int koniec;
	private CyclicBarrier bariera;
	private double suma=0;
	
	public Watki(int start,int koniec,CyclicBarrier bariera)
	{
		this.start=start;
		this.koniec=koniec;
		this.bariera=bariera;
	}
	
	public void run()
	{
		try {
			bariera.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=start;i<=koniec;i++)
		{
			suma+=(Math.cos(i)+Math.sin(i));
			//System.out.println(i);
		}
	}
	public double getSuma()
	{
		return suma;
	}
}
