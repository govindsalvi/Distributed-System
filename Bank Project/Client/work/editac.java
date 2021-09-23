package work;
import java.awt.*;
import java.awt.event.*;
public class editac extends Frame implements ActionListener
{
Label l1,l2;
TextField t1,t2;
Button b1,b2;
Font f=new Font("Sans Serif",Font.BOLD,18);
	public editac()
	{
	super("Edit Account");
	setForeground(new Color(110,10,10));
	setBackground(Color.GRAY);

	setFont(f);
	setSize(850,550);
	setResizable(false);
	Panel main=new Panel();
	main.setLayout(new GridLayout(3,2,50,75));
	Panel p1=new Panel();
	p1.setLayout(new BorderLayout(50,75));
	Panel p2=new Panel();
	p2.setLayout(new BorderLayout(50,75));
	Panel p3=new Panel();
	p3.setLayout(new BorderLayout(50,75));
	p1.add(l1=new Label("Authontication"),BorderLayout.WEST);
	p1.add(t1=new TextField(10),BorderLayout.EAST);
	t1.setEchoChar('$');
	p2.add(new Label("Account no."),BorderLayout.WEST);
	p2.add(t2=new TextField(10),BorderLayout.EAST);
	p3.add(b1=new Button("Show"),BorderLayout.WEST);
	p3.add(b2=new Button("Cancel"),BorderLayout.EAST);
	b1.addActionListener(this);
	b2.addActionListener(this);
	main.add(p1);main.add(p2);main.add(p3);
	add(main);
	}
public void actionPerformed(ActionEvent a)
	{
	if(a.getSource()==b2)
			this.setVisible(false);
	else
		{
		String s1=t1.getText();
		String s2=t2.getText();
		if(s1.equals("govind"))
			{
			this.setVisible(false);
			searchac ac=new searchac(s2,true,"Save Changes");
			ac.setVisible(true);
			}
		else
			{msgbox m=new msgbox(this,"Not Authorized");
			m.setVisible(true);}
		}
	}
public  Insets getInsets()
	{
	return new Insets(150,275,150,275);
	}
}
