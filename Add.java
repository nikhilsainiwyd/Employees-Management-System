
package Employee_information;


import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

 class  Add extends JFrame implements ActionListener{
	
     Random ran=new Random();
     int number=ran.nextInt(999999);
	
     JLabel heading,name,dob,address,email,designation,empid,lblempid,fname,salary,phone,education,aadhar;
     JTextField tname,tfname,taddress,temail,tdesignation,tsalary,tphone,taadhar;
     JComboBox cbeducation;
     JDateChooser dcdob;
     JButton add_details,back;
     
     
     
     
     
	Add(){


		getContentPane().setBackground(Color.WHITE);		

		setTitle("Add Employee page");
		setSize(850,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
	heading=new JLabel("ADD EMPLOYEE DETAIL");
	heading.setBounds(350,10,250,50);
	add(heading);

	//coding for label of first line======================================
	name=new JLabel("Name");
	name.setBounds(50,80,100,40);
	add(name);
	
	dob=new JLabel("Date Of Birth");
	dob.setBounds(50,130,100,40);
        //dob.setFont(new Font("serif", Font.PLAIN,15));
	add(dob);
	
	address=new JLabel("Address");
	address.setBounds(50,180,100,40);
	add(address);

	email=new JLabel("Email");
	email.setBounds(50,230,100,40);
	add(email);

	designation=new JLabel("Designation");
	designation.setBounds(50,280,100,40);
	add(designation);

	empid=new JLabel("Employee id");
	empid.setBounds(50,330,100,40);
	add(empid);
        
        lblempid=new JLabel(""+number);
        lblempid.setBounds(200,330,100,40);
        add(lblempid);

	//coding for textfiled of first line===================================
	tname=new JTextField();
	tname.setBounds(200,80,100,30);
	add(tname);
	
	dcdob=new JDateChooser();
	dcdob.setBounds(200,130,100,30);
	add(dcdob);
	
	taddress=new JTextField();
	taddress.setBounds(200,180,100,30);
	add(taddress);
	
	temail=new JTextField();
	temail.setBounds(200,230,100,30);
	add(temail);
	
	tdesignation=new JTextField();
	tdesignation.setBounds(200,280,100,30);
	add(tdesignation);
	
	/**tempid=new JTextField();
	tempid.setBounds(200,330,100,30);
	add(tempid);*/

	//coding for label of second line=================================
	fname=new JLabel("Father Name");
	fname.setBounds(500,80,100,40);
	add(fname);
	
	salary=new JLabel("Salary");
	salary.setBounds(500,130,100,40);
	add(salary);
	
	phone=new JLabel("Contact");
	phone.setBounds(500,180,100,40);
	add(phone);

	education=new JLabel("Higest Education");
	education.setBounds(500,230,100,40);
	add(education);
	
	aadhar=new JLabel("Aadhar Number");
	aadhar.setBounds(500,280,100,40);
	add(aadhar);

	//coding for textfield of second line================================
	tfname=new JTextField();
	tfname.setBounds(650,80,100,30);
	add(tfname);

	tsalary=new JTextField();
	tsalary.setBounds(650,130,100,30);
	add(tsalary);

	tphone=new JTextField();
	tphone.setBounds(650,180,100,30);
	add(tphone);

        String cources[]={"BBA","BCA","BA","B.COM","BTECH","B.SC","MBA","MCA","MA","M.COM","MTECH","M.SC","PHD"};
	cbeducation=new JComboBox(cources);
        cbeducation.setBackground(Color.WHITE);
	cbeducation.setBounds(650,230,100,30);
	add(cbeducation);

	taadhar=new JTextField();
	taadhar.setBounds(650,280,100,30);
	add(taadhar);
	
	//coding for button =========================================
        add_details = new JButton("Add Details");
	add_details.setBounds(250,450,100,40);
        add_details.addActionListener(this);
	add(add_details);
	
	back = new JButton("Back");
	back.setBounds(500,450,100,40);
        back.addActionListener(this);
	add(back);
}
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==add_details){
                String name=tname.getText();
                String fname=tfname.getText();
                String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                String address=taddress.getText();
                String email=temail.getText();
                String salary=tsalary.getText();
                String designation=tdesignation.getText();
                String phone=tphone.getText();
                String aadhar=taadhar.getText();
                String education=(String) cbeducation.getSelectedItem();
                String empid=lblempid.getText();
                
                try{
                    Conn conn=new Conn();
                    String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog( null, "Deatils added successfully");
                    setVisible(false);
                    new Home();
                } catch(Exception e){
                    e.printStackTrace();
                }
                 
            } else{
                setVisible(false);
                new Home();
            }
        }
        
public static void main(String args[]){
new Add();
}

}
 