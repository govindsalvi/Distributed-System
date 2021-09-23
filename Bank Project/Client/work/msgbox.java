package work;
import java.awt.*;
import java.awt.event.*;
public class msgbox extends Dialog implements ActionListener
{
Label l1;
Button b1;
 public msgbox(Frame parent,String title)
	{
	super(parent,"message box",true);
	setSize(300,150);
	setLayout(new FlowLayout());
	setForeground(Color.GRAY);
	setResizable(false);	
	l1=new Label(title);
	add(l1);
	b1=new Button("Ok");
	add(b1);
	b1.addActionListener(this);
	}
public void actionPerformed(ActionEvent e)
	{
	this.setVisible(false);	
	}
public Insets getInsets()
	{
	return new Insets(25,100,25,100);	
	}
}