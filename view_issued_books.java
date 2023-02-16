import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class view_issued_books extends JFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	JTable t;
	JButton b1;
	
	view_issued_books()
	{
		setSize(1000,700);
		setTitle("Viewing Issued Books  ");
		setLayout(null);
		
		b1 = new JButton("Back");
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/lib","root","");
				stmt=con.createStatement();
				System.out.println("Connected");
				
				String s1="select * from issue_book";
				ResultSet rs = stmt.executeQuery(s1);
					int i=0,j=0;
		String str[]={"Book_no","Student_Id","S_Name","Mobile"};
			Object obj[][]=new Object[10][4];
			
				while(rs.next())
				{
					obj[i][j++]=rs.getString("Book_no");
					obj[i][j++]=rs.getString("Student_Id");
					obj[i][j++]=rs.getString("S_Name");
					obj[i][j++]=rs.getString("Mobile");
					i++;
					j=0;
				}
				t = new JTable(obj,str);
				
					
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			b1.addActionListener(this);
			
			JScrollPane js = new JScrollPane(t);
				add(js);
				add(b1);
				js.setBounds(20,50,700,500);
				b1.setBounds(320,550,130,50);
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	public static void main(String str[])
	{
		new view_issued_books();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
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
}
		
		