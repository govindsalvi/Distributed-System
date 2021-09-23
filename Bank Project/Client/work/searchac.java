package work;
import java.awt.*;
import java.awt.event.*;
public  class searchac extends Frame implements ActionListener
{
Label l1,l2,l3,l4,l5,l6;
TextField t1,t2,t3,t4,t5,t6;
Button b1,b2,b3;
TextArea a;
Choice c;
String s;
Font f=new Font("Sans Serif",Font.BOLD,14);

public searchac(String acno,boolean bo,String buttonname)
	{
	super("Account Information");
	setSize(850,550);
	setResizable(false);
	setForeground(new Color(110,10,10));
	setBackground(Color.GRAY);
	setFont(f);

	try
		{	
	connection c=new connection(currip.ip);
	c.toserver.writeBytes("5"+"\n");
	c.toserver.writeBytes(acno+"\n");
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
	s=acno;
	l1=new Label("Account no.");
	l2=new Label("Name.");
	l3=new Label("Phone no.");
	l4=new Label("Account Type");
	l5=new Label("Amount");
	l6=new Label("Address.");
	t1=new TextField(20);
	t2=new TextField(20);
	t3=new TextField(20);
	t4=new TextField(20);
	t5=new TextField(20);
	a=new TextArea("",5,20,1);
	b1=new Button(buttonname);
	b2=new Button("Cancel");
	p1.add(l1,BorderLayout.WEST);
	p1.add(t1,BorderLayout.EAST);
	p2.add(l2,BorderLayout.WEST);
	p2.add(t2,BorderLayout.EAST);
	p3.add(l3,BorderLayout.WEST);
	p3.add(t3,BorderLayout.EAST);
	p4.add(l4,BorderLayout.WEST);
	p4.add(t4,BorderLayout.EAST);
	p5.add(l5,BorderLayout.WEST);
	p5.add(t5,BorderLayout.EAST);
	p6.add(l6,BorderLayout.WEST);
	p6.add(a,BorderLayout.EAST);
	p7.add(b1,BorderLayout.WEST);
	p7.add(b2,BorderLayout.EAST);
	b1.addActionListener(this);
	b2.addActionListener(this);
	main.add(p1);main.add(p2);main.add(p3);main.add(p4);
	main.add(p5);main.add(p6);main.add(p7);
	add(main);
	
	t1.setText(c.fromserver.readLine());
	t2.setText(c.fromserver.readLine());
	t3.setText(c.fromserver.readLine());
	t4.setText(c.fromserver.readLine());
	t5.setText(c.fromserver.readLine());
	 a.setText(c.fromserver.readLine());
	if(t1.getText().equals("null"))
			{
			msgbox m=new msgbox(this,"Account Not Exists");
			this.setVisible(false);
			m.setVisible(true);
			}
		}
	catch(Exception e) { }
	t1.setEditable(false);
	t2.setEditable(bo);
	t3.setEditable(bo);
	t4.setEditable(bo);
	t5.setEditable(bo);
	a.setEditable(bo);
	}
public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==b2)
		this.setVisible(false);
	else
		{
		if(e.getActionCommand().equals("Save Changes"))
			{
				String check;
			try	{
				String s1,s2,s3,s4,s5,s6;
				s1=t1.getText();s2=t2.getText();s3=t3.getText();s4=t4.getText();s5=t5.getText();s6=a.getText();
				connection c=new connection(currip.ip);
				c.toserver.writeBytes("6"+"\n");
				c.toserver.writeBytes(s1+"\n");
				c.toserver.writeBytes(s2+"\n");
				c.toserver.writeBytes(s3+"\n");
				c.toserver.writeBytes(s4+"\n");
				c.toserver.writeBytes(s5+"\n");
				c.toserver.writeBytes(s6+"\n");
				if((c.fromserver.readLine()).equals("1"))
					check="Account Updated ";
				else
					check="Not Updated";
				msgbox m=new msgbox(this,check);
					m.setVisible(true);
				
				}
			catch(Exception ee) { }
			}
		if(e.getActionCommand().equals("Back"))
			{
			this.setVisible(false);
			searchbyac ac= new searchbyac();
			ac.setVisible(true);
			}
		if(e.getActionCommand().equals("Delete"))
			{
			String msg;			
			String s1=t1.getText();
			try
				{
				connection c=new connection(currip.ip);
				c.toserver.writeBytes("2"+"\n");
				c.toserver.writeBytes(s1+"\n");
				if((c.fromserver.readLine()).equals("1"))
				msg="Account Successfully Deleted";
				else
				msg="Action Can not Completed";
				msgbox m=new msgbox(this,msg);
				m.setVisible(true);
				}	
			catch(Exception ee)	{	}
		
			}

		}
	}
public Insets getInsets()
	{
	return new Insets(100,275,100,270);
	}
}