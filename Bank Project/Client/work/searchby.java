package work;
import java.awt.*;
import java.awt.event.*;
public class searchby extends Frame implements ActionListener
{
Label l1,l2;
TextField t1,t2;
Button b1,b2;
String whitchform;
Font f=new Font("Sans Serif",Font.BOLD,18);
	public searchby(String s)
	{
	super(s);
	whitchform=s;
	setFont(f);
	setForeground(new Color(110,10,10));
	setBackground(Color.GRAY);

	setSize(850,550);
	setResizable(false);
	Panel main=new Panel();
	main.setLayout(new GridLayout(3,2,50,75));
	
	Panel p2=new Panel();
	p2.setLayout(new BorderLayout(50,75));
	
	Panel p3=new Panel();
	p3.setLayout(new BorderLayout(50,75));

	
	p2.add(new Label("Account no."),BorderLayout.WEST);
	p2.add(t2=new TextField(10),BorderLayout.EAST);

	p3.add(b1=new Button("Show"),BorderLayout.WEST);
	p3.add(b2=new Button("Cancel"),BorderLayout.EAST);

	b1.addActionListener(this);
	b2.addActionListener(this);
	main.add(p2);main.add(p3);
	add(main);
	}
public void actionPerformed(ActionEvent a)
	{
	if(a.getSource()==b2)
			this.setVisible(false);
	else 
		{
		String s2=t2.getText();
		if(whitchform.equals("Search Account"))
		{
		this.setVisible(false);
		searchac ac=new searchac(s2,false,"Back");
		ac.setVisible(true);
		}
		if(whitchform.equals("Deposit"))
			{
			transaction d=new transaction("Deposit",s2);
			d.setVisible(true);
			this.setVisible(false);
			}
		if(whitchform.equals("Withdrwal"))
			{
			transaction d= new transaction("Withdrwal",s2);
			d.setVisible(true);
			this.setVisible(false);
			}
		if(whitchform.equals("Balance Inquiry"))
			{
			balanceshow d=new balanceshow(s2);
			d.setVisible(true);
			this.setVisible(false);
			}
		}
	}
public  Insets getInsets()
	{
	return new Insets(150,275,150,275);
	}
}
