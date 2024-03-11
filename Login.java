
package Employee_information;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener
{
	JLabel luser,lpass, lpic;
	JTextField tuser;
	JPasswordField ppass;
	JButton blogin, buser, bforget, bchange, bexit;
	ImageIcon img;
	Login()
	{
		getContentPane().setBackground(Color.WHITE);		

		setTitle("Login Form");
		setSize(650,500);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		// Coding of Label User ================================
		luser=new JLabel("User Name :");
		luser.setBounds(30,100,150,30);
		add(luser);
		// Coding of Label Password ================================
		lpass=new JLabel("Password :");
		lpass.setBounds(30,140,150,30);
		add(lpass);
		// Coding of TextField User ================================
		tuser=new JTextField();
		tuser.setBounds(170,100,150,30);
		add(tuser);
		// Coding of TextFiled Password ================================
		ppass=new JPasswordField();
		ppass.setBounds(170,140,150,30);
		add(ppass);
		// Coding of Button NewUser ================================
		buser=new JButton("NEW USER");
		buser.setBounds(30,200,135,30);
		add(buser);
		// Coding of Button Login ================================
		blogin=new JButton("LOGIN");
		blogin.setBounds(170,200,135,30);
                blogin.addActionListener(this);
		add(blogin);

		// Coding of Button ================================
		bchange=new JButton("CHANGE PSWD");
		bchange.setBounds(30,250,135,30);
		add(bchange);
		// Coding of Button Forget  Password================================
		bforget=new JButton("FORGET\n PSWD");
		bforget.setBounds(170,250,135,30);
		add(bforget);
		// Coding of Button exit ================================
		bexit=new JButton("EXIT");
		bexit.setBounds(110,290,100,30);
		add(bexit);
		img=new ImageIcon("D:\\EMS\\Images\\loginicon.jpg");
		lpic=new JLabel(img);
		lpic.setBounds(340,100,280,250);
		add(lpic);

	}
        
        public void actionPerformed(ActionEvent ae){
            try{
                String username=tuser.getText();
                String password=ppass.getText();
                
                Conn c=new Conn();
                String query="select * from login where username= '"+username+"' and password='"+password+"'";
                
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Home();
               } else{
                   JOptionPane.showMessageDialog(null, "Invalid username or password");
                   setVisible(false);
               }
            } catch(Exception e){
                e.printStackTrace();
            }
        }

public static void main(String arg[])
{
        new Login();
}
 }