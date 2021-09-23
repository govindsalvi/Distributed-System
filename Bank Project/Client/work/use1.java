import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
public class use1 extends Frame implements ActionListener
{
Button b;
AudioClip audioClip;
MenuBar m;
Menu m1;
MenuItem i;
public use1()
	{
  	//super("hello");
	setLayout(new FlowLayout());
	setSize(600,600);
	setVisible(true);
        b=new Button("Push me");
	add(b);
	b.addActionListener(this);
        m=new MenuBar();
	setMenuBar(m);
	m1=new Menu("Sounds");
	i=new MenuItem("Hi who there");
	i.addActionListener(this);
	m1.add(i);
        m.add(m1);
			

	}

public void actionPerformed(ActionEvent e)
	{
	
		try	
		{
		audioClip = Applet.newAudioClip(new URL ("file:274aamer_z1.wav"));
		audioClip.play();
		}
		catch(Exception eee)
		{}
		
	
	}
public static void main(String []a)
	{
	new use1();
	}

}