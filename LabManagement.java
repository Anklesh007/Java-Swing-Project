import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

/*class LabManagement
{
	public static void main(String args[])
	{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String u = "postgres";
		String p = "fulls@30";
		try
		{
			Connection connection = DriverManager.getConnection(url,u,p);
			System.out.print("Successful");
			connection.close();
		}
		catch(SQLException e)
		{
			System.out.print("Error Occured"+e);
		}
	}
}*/

class LabManagement extends JFrame implements ActionListener
{  
   JLabel title,msg,uname,pass;
   JTextField unameval;
   JPasswordField passval;
   JComboBox cb;
   JButton ok;
   LabManagement()
   {
      setDefaultCloseOperation(HIDE_ON_CLOSE);
      setResizable(false);
      JPanel p = new JPanel();

      title = new JLabel("LAB MANAGEMENT SYSTEM");
      title.setBounds(60,10,400,30);
      title.setFont(new Font("Serif",Font.BOLD,20));
      title.setForeground(Color.GREEN);
      p.add(title);
      
      String s[] = {"Staff","Student"};
      cb = new JComboBox(s);
      cb.setFont(new Font("Serif",Font.PLAIN,20));
      cb.setBounds(50,60,300,40);
      p.add(cb);
      
      unameval = new JTextField();
      unameval.setFont(new Font("Serif",Font.PLAIN,20));
      unameval.setBounds(50,130,300,50);
      Border titled1 = BorderFactory.createTitledBorder("ENTER USERNAME");
      unameval.setBorder(titled1);
      p.add(unameval);
      
      passval = new JPasswordField();
      passval.setFont(new Font("Serif",Font.PLAIN,20));
      passval.setBounds(50,190,300,50);
      Border titled2 = BorderFactory.createTitledBorder("ENTER PASSWORD");
      passval.setBorder(titled2);
      p.add(passval);
            
      ok = new JButton("LOGIN");  
      ok.setFont(new Font("Serif",Font.BOLD,17));
      ok.setBounds(50,260,300,50);
      ok.setBackground(Color.GREEN);  
      ok.addActionListener(this);
      p.add(ok);
      
      msg = new JLabel();
      msg.setBounds(75,125,300,20); 
      
      p.setLayout(null);
      add(p);
      }
	public void actionPerformed(ActionEvent e)
   	{
      if(unameval.getText().isEmpty())
      {
         JOptionPane.showMessageDialog(null, "Enter Username","Alert",JOptionPane.ERROR_MESSAGE);
      }
      else if(passval.getText().isEmpty())
      {
         JOptionPane.showMessageDialog(null, "Enter Password","Alert",JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         if(cb.getSelectedIndex()==1)
         {
            msg.setText("");
            Student s = new Student();
            s.setSize(500,500);
            s.setLocation(800,300);
            s.show();
         }  
         else if(cb.getSelectedIndex()==0)
         {
            msg.setText("");
            Staff s = new Staff();
            s.setSize(500,500);
            s.setLocation(800,300);         
            s.show();
         }
      }
  }
   
   //Student Frame-----------------------------------------------------------------------
   public class Student extends JFrame implements ActionListener
   {
      JLabel title,name,rno,sem,in,out;
      JComboBox semval;
      JTextField nameval,rnoval,inval,outval;
      JButton sub;
      public Student()
      {
         setDefaultCloseOperation(HIDE_ON_CLOSE);
         setResizable(false);
         
         title = new JLabel("STUDENT DETAIL FORM");
         title.setBounds(100,10,400,30);
         title.setFont(new Font("Serif",Font.BOLD,25));
         title.setForeground(Color.BLUE);

         name = new JLabel("NAME: ");
         name.setFont(new Font("Serif",Font.PLAIN,20));
         name.setBounds(20,70,200,20);
         
         rno = new JLabel("REG NO: ");
         rno.setFont(new Font("Serif",Font.PLAIN,20));
         rno.setBounds(20,120,200,20);
         
         sem = new JLabel("SEMESTER: ");
         sem.setFont(new Font("Serif",Font.PLAIN,20));
         sem.setBounds(20,170,200,20);
         
         in = new JLabel("IN TIME: ");
         in.setFont(new Font("Serif",Font.PLAIN,20));
         in.setBounds(20,220,200,20);
         
         out = new JLabel("OUT TIME: ");
         out.setFont(new Font("Serif",Font.PLAIN,20));
         out.setBounds(20,270,200,20);
         
         nameval = new JTextField();
         nameval.setBounds(150,70,300,30);
         nameval.setFont(new Font("Serif",Font.PLAIN,20));
         
         rnoval = new JTextField();
         rnoval.setBounds(150,120,300,30);
         rnoval.setFont(new Font("Serif",Font.PLAIN,20));
         
         String str[] = {"I","II","III","IV","V","VI","VII","VIII"};
         semval = new JComboBox(str);
         semval.setBounds(150,170,300,30);
         semval.setFont(new Font("Serif",Font.PLAIN,20));
         
         inval = new JTextField();
         inval.setBounds(150,220,300,30);
         inval.setFont(new Font("Serif",Font.PLAIN,20));
         
         outval = new JTextField();
         outval.setBounds(150,270,300,30);
         outval.setFont(new Font("Serif",Font.PLAIN,20));
       
         sub = new JButton("SUBMIT");
         sub.setBounds(125,350,250,50);
         sub.setFont(new Font("Serif",Font.BOLD,30));
         sub.setBackground(Color.BLUE);
         sub.setForeground(Color.WHITE);
         sub.addActionListener(this);
         
         JPanel p = new JPanel();
         p.setLayout(null);
         p.add(title);p.add(name);p.add(rno);p.add(sem);
         p.add(nameval);p.add(rnoval);p.add(in);p.add(out);
         p.add(semval);p.add(sub);
         p.add(inval);p.add(outval);
         add(p);
      }
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == sub)
         {
        	 String url = "jdbc:postgresql://localhost:5432/postgres";
        	 String u = "postgres";
        	 String p = "fulls@30";
        	 String INSERT_USERS_SQL ="Insert into Demo Values(?,?,?,?,?)";
        	 try
        	 {
        	Connection connection = DriverManager.getConnection(url,u,p);
        	     			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        	     	            preparedStatement.setString(1,"Ram");
        	     	            preparedStatement.setInt(2, 2);
        	     	            preparedStatement.setString(3, "IV");
        	     	            preparedStatement.setString(4, "12:20");
        	     	            preparedStatement.setString(5, "1:00");
        	     	            preparedStatement.executeUpdate();
        	     			connection.close();
        	     		}
        	     		catch(SQLException oe)
        	     		{
        	     			System.out.print("Error Occured"+oe);
        	     		}
        	 nameval.setText("");
            rnoval.setText("");
            inval.setText("");
            outval.setText("");
            semval.setSelectedIndex(0);
         }
      }
   }
   
   //Staff Frame-------------------------------------------------------------------------------
   public class Staff extends JFrame implements ActionListener
   {
      JLabel title,name,rno,sem,in,out;
      JComboBox semval;
      JTextField nameval,rnoval,inval,outval;
      JButton sub;
      public Staff()
      {
         setDefaultCloseOperation(HIDE_ON_CLOSE);
         setResizable(false);
         
         title = new JLabel("STAFF DETAIL FORM");
         title.setBounds(140,10,400,30);
         title.setFont(new Font("Serif",Font.BOLD,25));
         title.setForeground(Color.RED);

         name = new JLabel("NAME: ");
         name.setFont(new Font("Serif",Font.PLAIN,20));
         name.setBounds(20,70,200,20);
         
         rno = new JLabel("STAFF ID: ");
         rno.setFont(new Font("Serif",Font.PLAIN,20));
         rno.setBounds(20,120,200,20);
         
         sem = new JLabel("SEMESTER: ");
         sem.setFont(new Font("Serif",Font.PLAIN,20));
         sem.setBounds(20,170,200,20);
         
         in = new JLabel("IN TIME: ");
         in.setFont(new Font("Serif",Font.PLAIN,20));
         in.setBounds(20,220,200,20);
         
         out = new JLabel("OUT TIME: ");
         out.setFont(new Font("Serif",Font.PLAIN,20));
         out.setBounds(20,270,200,20);
         
         nameval = new JTextField();
         nameval.setBounds(150,70,300,30);
         nameval.setFont(new Font("Serif",Font.PLAIN,20));
         
         rnoval = new JTextField();
         rnoval.setBounds(150,120,300,30);
         rnoval.setFont(new Font("Serif",Font.PLAIN,20));
         
         String str[] = {"I","II","III","IV","V","VI","VII","VIII"};
         semval = new JComboBox(str);
         semval.setBounds(150,170,300,30);
         semval.setFont(new Font("Serif",Font.PLAIN,20));
         
         inval = new JTextField();
         inval.setBounds(150,220,300,30);
         inval.setFont(new Font("Serif",Font.PLAIN,20));
         
         outval = new JTextField();
         outval.setBounds(150,270,300,30);
         outval.setFont(new Font("Serif",Font.PLAIN,20));
       
         sub = new JButton("SUBMIT");
         sub.setBounds(125,350,250,50);
         sub.setFont(new Font("Serif",Font.BOLD,30));
         sub.setBackground(Color.RED);
         sub.addActionListener(this);
         
         JPanel p = new JPanel();
         p.setLayout(null);
         p.add(title);p.add(name);p.add(rno);p.add(sem);
         p.add(nameval);p.add(rnoval);p.add(in);p.add(out);
         p.add(semval);p.add(sub);
         p.add(inval);p.add(outval);
         add(p);
      }
      public void actionPerformed(ActionEvent ke)
      {
         if(ke.getSource() == sub)
         {
        	 String url = "jdbc:postgresql://localhost:5432/postgres";
        	 String u = "postgres";
        	 String p = "fulls@30";
        	 String INSERT_USERS_SQL ="Insert into Demo Values(?,?,?,?,?)";
        	 try
        	 {
        	Connection connection = DriverManager.getConnection(url,u,p);
        	     			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        	     	            preparedStatement.setString(1,"Ram");
        	     	            preparedStatement.setInt(2, 2);
        	     	            preparedStatement.setString(3, "IV");
        	     	            preparedStatement.setString(4, "12:20");
        	     	            preparedStatement.setString(5, "1:00");
        	     	            preparedStatement.executeUpdate();
        	     			connection.close();
        	     		}
        	     		catch(SQLException oe)
        	     		{
        	     			System.out.print("Error Occured"+oe);
        	     		}
        	 
        	nameval.setText("");
            rnoval.setText("");
            inval.setText("");
            outval.setText("");
            semval.setSelectedIndex(0);
         }
      }
   }

   
   public static void main(String args[])
   {
      LabManagement reg = new LabManagement();
      reg.setVisible(true);
      reg.setSize(400,400);
      reg.setLocation(800,300);
   }
}