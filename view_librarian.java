import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class view_librarian extends JFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	JTable t;
	JButton b1;
	
	view_librarian()
	{
		setSize(700,700);
		setTitle("Librarian  ");
		setLayout(null);
		
		b1 = new JButton("Back");
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/lib","root","");
				stmt=con.createStatement();
				System.out.println("Connected");
				
				String s1="select * from add_librarian";
				ResultSet rs = stmt.executeQuery(s1);
				String str[]={"Name","Gender","Email","Address","ID","Mobile"};
			Object obj[][]=new Object[20][6];
		
				int i=0,j=0;
				
				while(rs.next())
				{
					obj[i][j++]=rs.getString("Name");
					obj[i][j++]=rs.getString("Gender");
					obj[i][j++]=rs.getString("Email");
					obj[i][j++]=rs.getString("Address");
					obj[i][j++]=rs.getInt("ID");
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
			
			JScrollPane js = new JScrollPane(t);
				add(js);
				add(b1);
				js.setBounds(20,50,700,500);
				b1.setBounds(320,550,130,50);
		
			
		
			b1.addActionListener(this);
			
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	public static void main(String str[])
	{
		new view_librarian();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				this.dispose();
				new admin();
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
}