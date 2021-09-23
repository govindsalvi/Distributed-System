package work;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
import java.net.*;
 class detail extends Frame implements ActionListener
{
MenuBar m; 
Menu m1,m2,m3,m4,m5;
MenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14;
Font f=new Font("Sans Serif",Font.PLAIN,14);
Image img;
URL url;
//Graphics g;
AudioClip audioClip;
	public detail()
	{
	setFont(f);
	setForeground(new Color(110,10,10));
	setBackground(Color.GRAY);
	setLayout(new FlowLayout());
	setSize(850,550);
	setResizable(false);
	url=getClass().getResource("images/bank.jpg");
	//pic.show();
        img=getToolkit().getImage(url);
	m=new MenuBar();
	setMenuBar(m);
	m1=new Menu("Account Details");

	m2=new Menu("Transction");

	m3=new Menu("Show");

	m4=new Menu("Search");

	m5=new Menu("Help");

	i1=new MenuItem("New Account");
	i2=new MenuItem("Delete Account");
	i3=new MenuItem("-");
	i4=new MenuItem("Exit");
	i5=new MenuItem("Edit Account");

	i6=new MenuItem("Withdrwal");
	i7=new MenuItem("Deposit");
	i8=new MenuItem("Transfer");

	i9=new MenuItem("Balance inquiry");
	i10=new MenuItem("Mini statement");

	i11=new MenuItem("By Name");
	i12=new MenuItem("By Account No.");

	i13=new MenuItem("View help ");
	i14=new MenuItem("About us");


	m1.add(i1);
	m1.add(i2);
	m1.add(i5);
	m1.add(i3);
	m1.add(i4);


	m2.add(i6);
	m2.add(i7);
	m2.add(i8);

	m3.add(i9);
	m3.add(i10);

	m4.add(i11);
	m4.add(i12);

	m5.add(i13);
	m5.add(i14);

	m.add(m1);
	m.add(m2);
	m.add(m3);
	m.add(m4);
	m.add(m5);

	i1.addActionListener(this);
	i2.addActionListener(this);
	i4.addActionListener(this);
	i5.addActionListener(this);
	i6.addActionListener(this);
	i7.addActionListener(this);
	i8.addActionListener(this);
	i9.addActionListener(this);
	i10.addActionListener(this);
	i11.addActionListener(this);
	i12.addActionListener(this);
	i13.addActionListener(this);
	i14.addActionListener(this);
	}
public void paint(Graphics g)
{
g.drawImage(img,0,0,this);
}

public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==i1)
		{
		try	
		{
		audioClip = Applet.newAudioClip(new URL ("file:fy_marioworld.wav"));
		audioClip.play();
		newac l=new newac();
		l.setVisible(true);
		}
		catch(Exception eee)
		{eee.printStackTrace();}
		
		}
	else if(e.getSource()==i2)
		{ 
		deleteaccount d=new deleteaccount();
		d.setVisible(true);
		}
	else if(e.getSource()==i4)
		{
		this.setVisible(false);
		login l=new login();
		l.setVisible(true);
		} 
	else if(e.getSource()==i5)
		{
		editac l=new editac();
		l.setVisible(true);} 
	else if(e.getSource()==i12)
		{

		searchby l=new searchby("Search Account");
		l.setVisible(true);}
	else if(e.getSource()==i6)
		{

		searchby l=new searchby("Withdrwal");
		l.setVisible(true);}
	else if(e.getSource()==i7)
		{
		searchby l=new searchby("Deposit");
		l.setVisible(true);}
	else if(e.getSource()==i9)
		{

		searchby l=new searchby("Balance Inquiry");
		l.setVisible(true);}
	else if(e.getSource()==i14)
		{
		about l=new about();
		l.setVisible(true);}
	}
public Insets getInsets()
 	{
  	return new Insets(150,275,150,275);
 	}
} 