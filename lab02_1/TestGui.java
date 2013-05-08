import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TestGui  {

	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new JFrame("Prziciski");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				ButtonPane panel=new ButtonPane();
				panel.setOpaque(true);

				frame.setContentPane(panel);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
	
class ButtonPane extends JPanel {

	ButtonPane()
	{
		 b1=new JButton("akcja");
		 b2=new JButton("reakcja");
		 b3=new JButton("nicnierobienie");
		 b3.setEnabled(false);
		 b2.setEnabled(false);
		 lab=new JLabel("hura");
		add(b1);
		add(b2);
		add(b3);
		add(lab);
		b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					b2.setEnabled(true);
					b3.setEnabled(true);
					lab.setText("cos zlego sie stal");


				}
			});

	}


	public JButton b1;
	public JButton b2;
	public JButton b3;
	public JLabel lab;	

		
}
