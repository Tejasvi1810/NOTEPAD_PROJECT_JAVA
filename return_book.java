import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;



class return_book extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField tf1,tf2;
	JButton b1,b2;
	
	Connection con;
		Statement stmt;
		
	
	return_book()
	{
		setSize(600,500);
		setTitle("Returning Books ");
		setLayout(null);
		
		l1 = new JLabel("Return  Book ");
		l2 = new JLabel("Book No: ");
		l3 = new JLabel("Student ID: ");
		l4 = new JLabel("Note:Check the book Properly!");
		
		tf1 = new JTextField(30);
		tf2 = new JTextField(30);
		b1 = new JButton("Return Book");
		b2 = new JButton("Back ");
		
		add(l1);add(l2);add(tf1);add(l3);add(tf2);add(l4);add(b1);add(b2);
		
		l1.setBounds(190,10,300,100);
		l1.setFont(new Font("Serif",Font.BOLD,25));
		
		l2.setBounds(100,100,100,50);
		l2.setFont(new Font("Serif",Font.BOLD,15));
		tf1.setBounds(300,115,120,20);
		
		l3.setBounds(100,150,150,50);
		l3.setFont(new Font("Serif",Font.BOLD,15));
		tf2.setBounds(300,170,120,20); 	
		
		l4.setBounds(100,300,300,50);
		l4.setFont(new Font("Serif",Font.BOLD,10));
		
		b1.setBounds(150,250,130,50);
		b2.setBounds(320,250,130,50);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/lib","root","");
				stmt=con.createStatement();
				System.out.println("Connected");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	
		
	}
	public static void main(String str[])
	{
		new return_book();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if(e.getSource()==b1)
		{
			String s1="delete from issue_book where Student_ID="+tf2.getText();
			stmt.executeUpdate(s1);
			JOptionPane.showMessageDialog(this,"Book Returned Succesfully !");
			b1.setEnabled(false);
		}
		
		
		
		
		if(e.getSource()==b2)
		{
			this.dispose();
			new librarian();
		}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	
	// return mai delete karna hai basically.
}
	
		
	
