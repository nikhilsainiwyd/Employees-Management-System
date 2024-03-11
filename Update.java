
package Employee_information;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 class  Update extends JFrame implements ActionListener{
	
    
	
     JLabel heading,name,empId,dob,address,email,designation,lblempid,fname,salary,phone,education,aadhar;
     JTextField teducation,tfname,taddress,temail,tdesignation,tsalary,tphone,taadhar;
     JButton add_details,back;
     String empid;
     
     
     
     
	Update(String empid){
                 this.empid=empid;
		getContentPane().setBackground(Color.WHITE);		

		setTitle("Update Employee page");
		setSize(850,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
	heading=new JLabel("Update EMPLOYEE DETAIL");
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

	empId=new JLabel("Employee id");
	empId.setBounds(50,330,100,40);
	add(empId);
        
        lblempid=new JLabel();
        lblempid.setBounds(200,330,100,40);
        add(lblempid);

  	//coding for textfiled of first line===================================
	JLabel lblname=new JLabel();
	lblname.setBounds(200,80,100,30);
	add(lblname);
	
	JLabel lbldob=new JLabel();
	lbldob.setBounds(200,130,100,30);
	add(lbldob);
	
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


	teducation=new JTextField();
	teducation.setBounds(650,230,100,30);
	add(teducation);

	JLabel lblaadhar=new JLabel();
	lblaadhar.setBounds(650,280,100,30);
	add(lblaadhar);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empid='"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                tsalary.setText(rs.getString("salary"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empid"));
                tdesignation.setText(rs.getString("designation"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
	
	//coding for button =========================================
        add_details = new JButton("Update Details");
	add_details.setBounds(250,450,200,40);
        add_details.addActionListener(this);
	add(add_details);
	
	back = new JButton("Back");
	back.setBounds(500,450,100,40);
        back.addActionListener(this);
	add(back);
}
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==add_details){
               
                String fname=tfname.getText();
                String address=taddress.getText();
                String email=temail.getText();
                String salary=tsalary.getText();
                String designation=tdesignation.getText();
                String phone=tphone.getText();
                String education=teducation.getText();
              
                
                try{
                    Conn conn=new Conn();
                    String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"'where empid='"+empid+"'";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog( null, "Deatils updated successfully");
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
new Update("");
}

}
 