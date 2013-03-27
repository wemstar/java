import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


 public class Lab03  {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run(){
				JFrame frame = new JFrame("Ulamki");
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        		UlamekFrame newContentPane = new UlamekFrame();
        		newContentPane.setOpaque(true); 
        		frame.setContentPane(newContentPane);
        		frame.setSize(400,400);
 
        
        		frame.pack();
        		frame.setVisible(true);
			}
		});
	}
	
}
class UlamekFrame extends JPanel
{
	UlamekFrame()
	{
		
		plusLicznik=new JButton("+");
		minusLicznik=new JButton("-");
		plusMianownik=new JButton("+");
		minusMianownik=new JButton("-");
		licznik1=new JTextField(1);
		mianownik1=new JTextField(1);
		licznik2=new JTextField(1);
		mianownik2=new JTextField(1);
		licznik3=new JTextField(1);
		mianownik3=new JTextField(1);


		ActionListener sluchacz=new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				Ulamek ulamek1=new Ulamek(Integer.valueOf(licznik1.getText()),Integer.valueOf(mianownik1.getText()));
				Ulamek ulamek2=new Ulamek(Integer.valueOf(licznik1.getText()),Integer.valueOf(mianownik1.getText()));
				Ulamek ulamek3;
				if("dodaj".equals(event.getActionCommand()))ulamek3=ulamek1.dodaj(ulamek2);
				else ulamek3=ulamek1.dodaj(ulamek2);
				ulamek3=ulamek3.nwd();

				licznik3.setText(String.format("%1$2d",ulamek3.licznik));
				mianownik3.setText(String.format("%1$2d",ulamek3.mianownik));


			}
		};
		plusLicznik.addActionListener(sluchacz);
		minusLicznik.addActionListener(sluchacz);
		plusMianownik.addActionListener(sluchacz);
		minusMianownik.addActionListener(sluchacz);
		plusLicznik.setActionCommand("plus");
		minusLicznik.setActionCommand("minus");
		plusMianownik.setActionCommand("plus");
		minusMianownik.setActionCommand("minus");



		setLayout(new GridLayout(2,7));
		add(licznik1);
		add(plusLicznik);
		add(minusLicznik);
		add(licznik2);
		add(licznik3);
		add(mianownik1);
		add(plusMianownik);
		add(minusMianownik);
		
		
		add(mianownik2);
		add(mianownik3);
		

	}



	JButton plusLicznik;
	JButton minusLicznik;
	JButton plusMianownik;
	JButton minusMianownik;
	JTextField licznik1;
	JTextField mianownik1;
	JTextField licznik2;
	JTextField mianownik2;
	JTextField licznik3;
	JTextField mianownik3;

}
class Ulamek
{
	Ulamek(int l,int m)
	{
		licznik=l;
		mianownik=m;

	}
	public Ulamek nwd()
	{
		int dzielnik=0;
		for (int i=licznik;i>0 ;--i ) {
			if((mianownik%i)==0)
				{
					dzielnik=i;
					break;
				}

			
		}
		
		if(dzielnik!=0)return new Ulamek(licznik/dzielnik,mianownik/dzielnik);
		else return this;
		

	}
	public Ulamek dodaj(Ulamek inny)
	{
		return new Ulamek(licznik*inny.mianownik+inny.licznik*mianownik,mianownik*inny.mianownik);
	}



	public final int licznik;
	public final int mianownik;
}



