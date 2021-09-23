package work;
import java.awt.*;
import java.awt.event.*;
public class transaction extends Frame implements ActionListener
{
Label l1,l2;
TextField t1,t2,t3;
Button b1,b2;
String whitch;
Font f=new Font("Sans Serif",Font.BOLD,18);
	public transaction(String s,String acno)
	{
	super(s);
	whitch=s;
	setForeground(new Color(110,10,10));
	setBackground(Color.GRAY);

	setFont(f);
	setSize(850,550);
	//setResizable(false);

	Panel main=new Panel();
	main.setLayout(new GridLayout(4,2,50,25));

	Panel p1=new Panel();
	p1.setLayout(new BorderLayout(50,25));

	Panel p2=new Panel();
	p2.setLayout(new BorderLayout(50,25));

	Panel p3=new Panel();
	p3.setLayout(new BorderLayout(50,25));

	Panel p4=new Panel();
	p4.setLayout(new BorderLayout(50,25));

	p1.add(l1=new Label("Account no"),BorderLayout.WEST);
	p1.add(t1=new TextField(10),BorderLayout.EAST);

	p2.add(new Label("Name"),BorderLayout.WEST);
	p2.add(t2=new TextField(10),BorderLayout.EAST);
	t1.setEditable(false);
	t2.setEditable(false);

	p3.add(new Label(whitch+" Amount"),BorderLayout.WEST);
	p3.add(t3=new TextField(10),BorderLayout.EAST);

	p4.add(b1=new Button(whitch),BorderLayout.WEST);
	p4.add(b2=new Button("Cancel"),BorderLayout.EAST);
	try{
		connection c=new connection(currip.ip);
		c.toserver.writeBytes("10"+"\n");
		c.toserver.writeBytes(acno+"\n");
		t1.setText(c.fromserver.readLine());
		t2.setText(c.fromserver.readLine());
	   }
	catch(Exception ee) { }

	b1.addActionListener(this);
	b2.addActionListener(this);
	main.add(p1);main.add(p2);main.add(p3);main.add(p4);
	add(main);
	}
public void actionPerformed(ActionEvent a)
	{
	
	if(a.getSource()==b2)
			this.setVisible(false);
	else
		{
		String re="";
		String acno=t1.getText();
		String money=t3.getText();
		if((a.getActionCommand()).equals("Deposit"))
			{
				try{
					
					connection c=new connection(currip.ip);
					c.toserver.writeBytes("11"+"\n");
					c.toserver.writeBytes(acno+"\n");
					c.toserver.writeBytes(money+"\n");
					if((c.fromserver.readLine()).equals("1"))
					re="Amount Deposited";
					else
					re="Not Done";
					msgbox m=new msgbox(this,re);				
					m.setVisible(true);
					}
				catch (Exception ee) { }
			}
		if((a.getActionCommand()).equals("Withdrwal"))
			{
				try{
					connection c=new connection(currip.ip);
					c.toserver.writeBytes("12"+"\n");
					c.toserver.writeBytes(acno+"\n");
					c.toserver.writeBytes(money+"\n");
					String ss=c.fromserver.readLine();
					if(ss.equals("1"))
					re="Amount Withdrwal Success";
					else 
					{
					if(ss.equals("2"))
					re="Do not have sufficient balance";
					else
					re="Not done";
					}
					msgbox m=new msgbox(this,re);
					m.setVisible(true);
					}
				catch (Exception ee) { }
			}
	
		}
	}
public  Insets getInsets()
	{
	return new Insets(150,275,200,275);
	}
}
