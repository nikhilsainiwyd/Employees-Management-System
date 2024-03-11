
package Employee_information;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Splash extends JFrame implements ActionListener
{
	JLabel lpic,heading;
	JButton bclickhere;
	ImageIcon img;
	Splash()
	{	
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		setSize(1170,650);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);

		

		heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(65,30,1200,60);
		heading.setFont(new Font("serif",Font.PLAIN,60));
		heading.setForeground(Color.RED);
		add(heading);
			
		// Coding of Button clickhere ================================
		bclickhere=new JButton("CLICK HERE TO CONTINUE");
		bclickhere.setBounds(400,500,300,70);
		bclickhere.setBackground(Color.BLACK);
		bclickhere.setForeground(Color.WHITE);
		bclickhere.addActionListener(this);
		add(bclickhere);

			
		img=new ImageIcon("D:/EMS/splash.jpg");
		lpic=new JLabel(img);
		lpic.setBounds(50,100,1050,500);
		add(lpic);

		while(true){
			heading.setVisible(false);
			try{
			Thread.sleep(500);
		} catch (Exception e){
			
		}
			heading.setVisible(true);
			try{
			Thread.sleep(500);
		} catch (Exception e){
			
		}
		}

	}
	
	public void actionPerformed(ActionEvent ae){
		setVisible(false);
		new Login();
	}

public static void main(String arg[])
{
        new Splash();
}
}