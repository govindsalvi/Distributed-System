package work;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class newac extends Frame implements ActionListener
{
Label l1,l2,l3,l4,l5,l6;
TextField t1,t2,t3,t4,t5,t6;
Button b1,b2,b3;
TextArea a;
Choice ch;
AudioClip audioClip;
Font f=new Font("Sans Serif",Font.BOLD,14);
public newac()
	{
	
	super("New Account");
	setFont(f);
	setSize(850,550);
	setResizable(false);
	setForeground(new Color(110,10,10));
	setBackground(Color.GRAY);

	Panel main=new Panel();
	main.setLayout(new GridLayout(7,2,50,20));
	Panel p1=new Panel();
	p1.setLayout(new BorderLayout(50,20));
	Panel p2=new Panel();
	p2.setLayout(new BorderLayout(50,20));
	Panel p3=new Panel();
	p3.setLayout(new BorderLayout(50,20));
	Panel p4=new Panel();
	p4.setLayout(new BorderLayout(50,20));
	Panel p5=new Panel();
	p5.setLayout(new BorderLayout(50,20));
	Panel p6=new Panel();
	p6.setLayout(new BorderLayout(50,20));
	Panel p7=new Panel();
	p7.setLayout(new BorderLayout(50,20));
	l1=new Label("Account no.");
	l2=new Label("Name.");
	l3=new Label("Phone no.");
	l4=new Label("Account Type");
	l5=new Label("Initial Amount");
	l6=new Label("Address.");

	t1=new TextField(20);
	t1.setEditable(false);
	t2=new TextField(20);
	t3=new TextField(20);

	t4=new TextField(20);
	t5=new TextField(20);
	a=new TextArea("",5,20,1);
	b1=new Button("Add New");
	b2=new Button("Save");
	b3=new Button("Cancel");
	p1.add(l1,BorderLayout.WEST);
	p1.add(t1,BorderLayout.EAST);
	p2.add(l2,BorderLayout.WEST);
	p2.add(t2,BorderLayout.EAST);
	p3.add(l3,BorderLayout.WEST);
	p3.add(t3,BorderLayout.EAST);
	p4.add(l4,BorderLayout.WEST);
	p4.add(t4,BorderLayout.EAST); //t4
	p5.add(l5,BorderLayout.WEST);
	p5.add(t5,BorderLayout.EAST);
	p6.add(l6,BorderLayout.WEST);
	p6.add(a,BorderLayout.EAST);
	p7.add(b1,BorderLayout.WEST);
	p7.add(b2,BorderLayout.CENTER);
	p7.add(b3,BorderLayout.EAST);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	main.add(p1);main.add(p2);main.add(p3);main.add(p4);
	main.add(p5);main.add(p6);main.add(p7);
	add(main);
	}
public void actionPerformed(ActionEvent e)
	{
	String mb;
	if(e.getSource()==b3)
	this.setVisible(false);
	if(e.getSource()==b2)
		{
		String s1,s2,s3,s4,s5,s6;
		s1=t1.getText();s2=t2.getText();s3=t3.getText();s4=t4.getText();s5=t5.getText();s6=a.getText();
		try{
		connection c=new connection(currip.ip);
		c.toserver.writeBytes("3"+"\n");
		c.toserver.writeBytes(s1+"\n");
		c.toserver.writeBytes(s2+"\n");
		c.toserver.writeBytes(s3+"\n");
		c.toserver.writeBytes(s4+"\n");
		c.toserver.writeBytes(s5+"\n");
		c.toserver.writeBytes(s6+"\n");
		if((c.fromserver.readLine()).equals("1"))
		mb="Entered";	
		else 
		mb="Not Done";
		msgbox m=new msgbox(this,mb);
		m.setVisible(true);
				}
		catch(Exception ee) { }
		}
	if(e.getSource()==b1)
		{
		try	
		{
		audioClip = Applet.newAudioClip(new URL ("file:274aamer_z1.wav"));
		audioClip.play();
		}
		catch(Exception eee)
		{}
			
			String acno;
			try{
			connection c=new connection(currip.ip);
			c.toserver.writeBytes("4"+"\n");
			acno=c.fromserver.readLine();
			t1.setText(acno);			

			}
			catch(Exception ee) { }
			
		}
	}
public Insets getInsets()
	{
	return new Insets(100,275,100,270);
	}
}