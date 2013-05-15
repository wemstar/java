import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.*;


public class GameSerialize {
	
	
	
	
	
	
	public void save(JPanel pan)
	{
		Component[] com=pan.getComponents();
		str =new Vector<>();
		for(Component k:com)
		{
			JButton but=(JButton)k;
			str.add(but.getText());
			
		}
		try {
			ObjectOutputStream stre=new ObjectOutputStream(new FileOutputStream("cos.dat"));
			stre.writeObject(str);
			stre.close();
			
		}catch(FileNotFoundException e)
		{}
		
		catch ( IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public JPanel load()
	{
		
		try{
			ObjectInputStream stre=new ObjectInputStream(new FileInputStream("cos.dat"));
			str= (Vector<String> )stre.readObject();
			stre.close();
		}
		catch(FileNotFoundException e)
		{}
		catch ( IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		JPanel panel;
		if(str==null)panel=createPanel();
		else panel=restorePanel();
		
		
		return panel;
	}
	private JPanel createPanel(){
		JPanel pan=new JPanel();
		pan.setLayout(new GridLayout(3,3));
		for(int x=0;x<9;++x)
		{
			JButton buton=new JButton();
			pan.add(buton);
		}
		
		
		
		return pan;
		
	}
	private JPanel restorePanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3,3));
		for(String stri:str)
		{
			JButton button=new JButton();
			button.setText(stri);
			button.setActionCommand(stri);
			panel.add(button);
		}
		return panel;
		
	}
	
	
	private Vector<String> str; 

}
