
package Employee_information;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

	JLabel lpic,heading;
	JButton badd,bview,bremove,bupdate;
	ImageIcon img;


	Home(){
	setTitle("Home page");
	setSize(1334,800);
	setLocation(20,20);
	setVisible(true);
	setLayout(null);
	
	img=new ImageIcon("D:\\EMS\\landing_img.jpg");
	lpic=new JLabel(img);
	lpic.setBounds(0,0,1334,800);
	add(lpic);
	
	heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
	heading.setBounds(20,20,600,40);
	heading.setFont(new Font("Raleway",Font.BOLD,25));
	lpic.add(heading);
	
	badd=new JButton("Add Employee");
	badd.setBounds(20,100,150,40);
	badd.addActionListener(this);
	lpic.add(badd);
	
	bview=new JButton("View Employees");
	bview.setBounds(20,200,150,40);
	bview.addActionListener(this);
	lpic.add(bview);

	bupdate=new JButton("Update Employee");
	bupdate.setBounds(20,300,150,40);
	bupdate.addActionListener(this);
	lpic.add(bupdate);

	bremove=new JButton("Remove Employee");
	bremove.setBounds(20,400,150,40);
	bremove.addActionListener(this);
	lpic.add(bremove);

	


}
    public void actionPerformed(ActionEvent ae){
		
	if(ae.getSource()==badd){
            setVisible(false);
            new Add(); 
        } else if(ae.getSource()==bview) {
            setVisible(false);
            new View();
        } else if(ae.getSource()==bupdate) {
            setVisible(false);
            new View();
        } else {
            setVisible(false);
            new Remove();
        }

}



public static void main(String args[]){

	new Home();

}
}