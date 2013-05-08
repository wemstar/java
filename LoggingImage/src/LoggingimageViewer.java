import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;

import javax.swing.*;


public class LoggingimageViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(System.getProperty("java.util.logging.config.class")==null && System.getProperty("java.util.logging.config.file")==null)
		{
			try 
			{
				Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT=10;
				Handler handler=new FileHandler("%h/loggingImageViewer.log",0,LOG_ROTATION_COUNT);
				Logger.getLogger("com.horstmann.corejava").addHandler(handler);
			}catch (IOException e)
			{
				Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "nie mozna utwożyc pliku dziennika",e);
				
			}
		}
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				Handler windowHandler=new WindowHandler();
				windowHandler.setLevel(Level.ALL);
				Logger.getLogger("com.hoestmann.corejava").addHandler(windowHandler);
				
				JFrame frame=new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Logger.getLogger("com.hoestmann.corejava").fine("Wyśfielenie ramki");
				frame.setVisible(true);
				
			}
			
		});

	}

}
class ImageViewerFrame extends JFrame {
	public ImageViewerFrame()
	{
		logger.entering("Image Frame","<int>");
		setTitle("Loggin image viever");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("Plik");
		setJMenuBar(menuBar);
		menuBar.add(menu);
		JMenuItem openItem=new JMenuItem("Otwórz");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				logger.fine("Kończenie");
				System.exit(0);
			}
			
		});
		label=new JLabel();
		add(label);
		logger.exiting("ImageVieweFrame","<int>");
		
		
	}
	private class FileOpenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			logger.entering("ImageVieweFrameEvent.FileOpenListener","actionPerformed",event);
			JFileChooser chooser=new JFileChooser();
			chooser.setCurrentDirectory(new File(" "));
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
			{
				public boolean accept(File f)
				{
					return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
					
				}
				public String getDescription()
				{
					return "Obrazy gif";
				}
			});
			int r=chooser.showOpenDialog(ImageViewerFrame.this);
			if(r==JFileChooser.APPROVE_OPTION)
			{
				String name=chooser.getSelectedFile().getPath();
				logger.log(Level.FINE,"Wczytywanie pliku {0}",name);
				label.setIcon(new ImageIcon(name));
			}
			else logger.fine("Anulowano okkon otwierania pliku");
			logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
		}
	}
	
	private JLabel label;
	private static Logger logger=Logger.getLogger("com.horstmann.corejava");
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=400;

}

class WindowHandler extends StreamHandler
{
	public WindowHandler()
	{
		frame=new JFrame();
		final JTextArea output=new JTextArea();
		output.setEditable(false);
		frame.setSize(200,200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		setOutputStream(new OutputStream()
		{
			public void write(int b)
			{
				
			}
			public void write(byte[]b,int off,int len)
			{
				output.append(new String(b,off,len));
				
			}
			
		});
	}
	public void publish(LogRecord record)
	{
		if(!frame.isVisible())return;
		super.publish(record);
		flush();
	}
	private JFrame frame;
}
