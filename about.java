import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class about extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1;
	
	about()
	{
		setSize(600,600);
		 setTitle("About ");
		setLayout(null);
		
		l1 = new JLabel(" This Software is developer by Tejasvi ! Copyright Aptech Limited !");
		
		b1 = new JButton("OK");
		
		add(l1);add(b1);
		
		l1.setBounds(70,2,700,500);
		b1.setBounds(170,300,80,50);
		b1.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String str[])
	{
		new about();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			this.dispose();
			new notepad();
		}
	}
}

		