import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class notepad extends JFrame implements ActionListener
{
	JMenuBar mb;
	JTextArea ta1;
	JMenu mn1,mn2,mn3,mn4,mn5,mn6;
	JMenuItem mt1,mt2,mt3,mt4,mt5,mt6,mt7;
	JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9;
	notepad()
	{
		setSize(600,600);
		 setTitle("Tejas - Notepad");
		 
		 mb = new JMenuBar();
		
		ta1 = new JTextArea();
		JScrollPane csc = new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		mn1 = new JMenu("File");
		mn2 = new JMenu("Format");
		mn3 = new JMenu("Application");
		mn4 = new JMenu("Help");
		mn5 = new JMenu("Background Color");
		mn6 = new JMenu("Font Color");
		
		ButtonGroup bg = new ButtonGroup();
		r1 = new JRadioButton("Green");
		r2 = new JRadioButton("Red");
		r3 = new JRadioButton("Cyan");
		r9 = new JRadioButton("White");
		r4 = new JRadioButton("Custom");
		r5 = new JRadioButton("Pink");
		r6 = new JRadioButton("Blue");
		r7 = new JRadioButton("Black");
		r8 = new JRadioButton("Yellow");
		bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);bg.add(r5);
		bg.add(r6);bg.add(r7);bg.add(r8);bg.add(r9);
		
		
		
		mt1 = new JMenuItem("New");
		mt2 = new JMenuItem("Open");
		mt3 = new JMenuItem("Save");
		mt4 = new JMenuItem("Exit");
		
		mt5 = new JMenuItem("Paint");
		mt6 = new JMenuItem("LMS");
		
		mt7 = new JMenuItem("About us ");
		
		
		mn1.add(mt1);mn1.add(mt2);mn1.add(mt3);mn1.add(mt4);
		mn5.add(r1);mn5.add(r2);mn5.add(r3);mn5.add(r9);mn5.add(r4);
		
		mn6.add(r5);mn6.add(r6);mn6.add(r7);mn6.add(r8);
		mn2.add(mn5);mn2.add(mn6);
		
		
		mn3.add(mt5);mn3.add(mt6);
		mn4.add(mt7);
		mb.add(mn1);mb.add(mn2);mb.add(mn3);mb.add(mn4);
		add(csc);
		setJMenuBar(mb);
		
		r1.addActionListener(this);r2.addActionListener(this);
		r3.addActionListener(this);r4.addActionListener(this);
		r5.addActionListener(this);r6.addActionListener(this);
		r7.addActionListener(this);r8.addActionListener(this);
		r9.addActionListener(this);
		mt7.addActionListener(this);mt1.addActionListener(this);
		mt6.addActionListener(this);mt2.addActionListener(this);
		mt5.addActionListener(this);mt3.addActionListener(this);
		mt4.addActionListener(this);
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String str[])
	{
		new notepad();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==r1)
			ta1.setBackground(Color.green);
		else if(e.getSource()==r2)
			ta1.setBackground(Color.red);
		else if(e.getSource()==r3)
			ta1.setBackground(Color.cyan);
		else if(e.getSource()==r9)
			ta1.setBackground(Color.white);
		else if(e.getSource()==r4)
		{
			JColorChooser cd = new JColorChooser();
			Color c = cd.showDialog(this,"select color",Color.blue);
			ta1.setBackground(c);
		}
		
		
		
		else if(e.getSource()==r5)
			ta1.setForeground(Color.pink);
		else if(e.getSource()==r6)
			ta1.setForeground(Color.blue);
		else if(e.getSource()==r7)
			ta1.setForeground(Color.black);
		else if(e.getSource()==r8)
			ta1.setForeground(Color.yellow);
		
		if(e.getSource()==mt7)
		{
			about obj = new about();
			obj.setSize(500,400);
			obj.setLocation(getLocation().x+50,getLocation().y+70);
			
			obj.show();
			
		}
		if(e.getSource()==mt4)
		{
			if(ta1.getText().equals(""))
				System.exit(0);
			int a = JOptionPane.showConfirmDialog(this,"Do you want to Save ? ");
			if(a==0)
			{
				JFileChooser js = new JFileChooser();
			js.showSaveDialog(this);
			String f2 = js.getSelectedFile().getPath();
			System.out.println(f2);
			try
			{
				FileWriter fw = new FileWriter(f2);
				BufferedWriter buf = new BufferedWriter(fw);
				
				buf.write(ta1.getText());
				
				buf.close();
				buf.close();
			}
			catch(Exception oo)
			{
				System.out.println(oo);
			}
			}
			else
				//this.dispose();
				System.exit(0);
		
				
			
		}
		if(e.getSource()==mt1)
		{
			ta1.setText(" ");
			ta1.setBackground(Color.white);
			ta1.setForeground(Color.black);
			ta1.requestFocus();
		}
		// for opening a file...from editor
		if(e.getSource()==mt2)
		{
			JFileChooser js = new JFileChooser();
			js.showOpenDialog(this);
			String f1 = js.getSelectedFile().getPath();
			System.out.println(f1);
			try
			{
				FileReader fd = new FileReader(f1);
				BufferedReader buf = new BufferedReader(fd);
				String s1 = " ";
				while((s1=buf.readLine())!=null)
				{
					ta1.append(s1+"\n");
				}
				buf.close();
				fd.close();
			}
			catch(Exception o)
			{
				System.out.println(o);
			}
		}
		
		// for saving a created file...
		if(e.getSource()==mt3)
		{
			JFileChooser js = new JFileChooser();
			js.showSaveDialog(this);
			String f2 = js.getSelectedFile().getPath();
			System.out.println(f2);
			try
			{
				FileWriter fw = new FileWriter(f2);
				BufferedWriter buf = new BufferedWriter(fw);
				
				buf.write(ta1.getText());
				
				buf.close();
				buf.close();
			}
			catch(Exception oo)
			{
				System.out.println(oo);
			}
		}
		
		if(e.getSource()==mt5)
		{
			try
			{
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("mspaint.exe");
			}
			catch(Exception w)
			{
				System.out.println(w);
			}
		}
		if(e.getSource()==mt6)
		{
			new Users();
		}
			
		
		
	}
		
		
}
		
		
		
		
		
		
		
		