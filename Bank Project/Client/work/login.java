package work;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
class closing extends WindowAdapter
{
	public void windowClosing(WindowEvent ee)
	{
		Window w=ee.getWindow();
		w.setVisible(false);
		w.dispose();
		System.exit(1);
	}
}

public class login extends Frame implements ActionListener,ItemListener 
{ 
 TextField     t1,t2;
 JPasswordField t3;
 JLabel   l1,l2;
 JButton        b1,b2;
 Choice ipadd;
 Font f=new Font("Sans Serif",Font.BOLD,16);
AudioClip audioclip;
Image img;
URL url;
public login()
 {
   	super("Login Form");
	url=getClass().getResource("audio/fy_marioworld.mid");
	try {audioclip = Applet.newAudioClip(url);}
	catch(Exception eee) { }
	audioclip.play();
	setBackground(Color.GRAY);
	setSize(850,550);
	setResizable(false);
	closing wc=new closing();
	addWindowListener(wc);
	setForeground(new Color(110,10,10));
	setFont(f);
	Panel main=new Panel();
	main.setLayout(new GridLayout(4,2,25,50));
	Panel p1=new Panel();
	p1.setLayout(new BorderLayout(25,50));
	p1.add(new Label("Username"),BorderLayout.WEST);
	p1.add(t1=new TextField(10),BorderLayout.EAST);
	Panel p2=new Panel();
	p2.setLayout(new BorderLayout(25,50));
	p2.add(new Label("Password"),BorderLayout.WEST);
	p2.add(t2=new TextField(10),BorderLayout.EAST); 
	t2.setEchoChar('*');
	Panel p4=new Panel();
	p4.setLayout(new BorderLayout(25,50));
	p4.add(new Label("Select Server"),BorderLayout.WEST);
	ipadd=new Choice();
	ipadd.add("localhost");
	ipadd.add("Main Server");
	ipadd.add("10.10.10.2");
	ipadd.add("10.10.10.1");
	ipadd.select("localhost");
	p4.add(ipadd,BorderLayout.EAST); 
	ipadd.addItemListener(this);
	Panel p3=new Panel();
	p3.setLayout(new BorderLayout(25,50));
	p3.add(b1=new JButton("  Ok  "),BorderLayout.WEST); 
	b1.addActionListener(this);
	p3.add(b2=new JButton("Cancle"),BorderLayout.EAST); 
	b2.addActionListener(this);
	main.add(p1);
	main.add(p2);
	main.add(p4);
	main.add(p3);
	
	add(main);
 }

public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		this.setVisible(false);
		else 
		{
		String user=t1.getText();
		String pass=t2.getText();
		String get;
		String m;
		try{
		currip.ip=ipadd.getSelectedItem();
		connection c=new connection(currip.ip);
		c.toserver.writeBytes("1"+"\n");
		c.toserver.writeBytes(user+"\n");
		c.toserver.writeBytes(pass+"\n");
		get=c.fromserver.readLine();
		if(get.equals("1"))
		{
		detail d=new detail();
		d.setVisible(true);
		this.setVisible(false);
		}
		else
		{	
		m="unsuccess";
		msgbox msg=new msgbox(this,m);
		msg.setVisible(true);
		}
		}
		catch(Exception a) { }
		}	
	}
public void itemStateChanged(ItemEvent ie)
{
repaint();
}
	public Insets getInsets()
 	{
  	return new Insets(150,275,150,275);
 	}
}

