package work;
import java.awt.*;
import java.awt.event.*;
public class about extends Frame implements ActionListener
{
	Button b;
	Font f=new Font("Sans Serif",Font.BOLD,16);
	public about()
	{
	super("About Us");
	setSize(850,550);
	setResizable(false);
	setLayout(new FlowLayout());
	setBackground(Color.GRAY);
	setFont(f);
	String text=" \n\n\n\n    \tThis Software A Client-Server Application On"+
		" Banking Managment \n"+
		" \tis design by Govind Salvi \n"+
		" \tStudent of M.B.M Engineering College,Jodhpur (Rajasthan).\n "+
		" \tThe Software is about how the management is done \n"+
		" \tat Bank lavel.Any authorized user can create,read,update"+
		" the Information of any customer";
		setForeground(new Color(110,10,10));
	 text+= "\n\n\n\tGOVIND SALVI\n"+
		" \tEmail Id: gloriousgovind@gmail.com\n";
		text+= "\n\tDON PANDYA\n"+
		" \tEmail Id: dpandyambm@gmail.com\n";
			text+= "\n\tNITIN TATER\n";
				text+= "\n\tBHARAT CHOUDHRY\n";
	TextArea te=new TextArea(text,20,80);
		add(te);
	te.setEditable(false);
	b=new Button("Ok");
	add(b);
	b.addActionListener(this);	
		
	}
public void actionPerformed(ActionEvent e)
	{
	this.setVisible(false);
	}
public Insets getInsets()
	{
	return new Insets(50,150,200,150);
	}
}
