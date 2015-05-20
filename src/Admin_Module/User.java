/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Module;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author SONY
 */
public class User extends javax.swing.JFrame{
	private Connection con=null;
	private Statement s=null;
	private JTextField userid= new JTextField();
	private JTextField password= new JTextField();
	private JButton login= new JButton("LOGIN"); 
	public static String userID;
	  public User(){
                super("User Login");
	        init();}
	    
	    public User(Connection c) {
	        super("User Login");
                init();
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydbsystem", "root","Vrushank4DS891");
	            s = con.createStatement();
	            
	        }catch(Exception e){
	            System.err.println("ERROR: "+e);
	        }}

private void init() {
		
			userid.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
			password.setHorizontalAlignment(JTextField.LEFT);
			
			JPanel p1=new JPanel(new GridLayout(0,2)); //Creating a panel for GUI
			p1.setBackground(Color.white);
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.anchor = GridBagConstraints.WEST;
                        constraints.insets = new Insets(10, 10, 10, 10);
                        
                        constraints.gridx = 0;
                        constraints.gridy = 0;
                        JLabel readerid = new JLabel("READER_ID#:");
                        readerid.setFont(new Font ("Serif", Font.BOLD, 20));
                        readerid.setForeground(Color.BLUE);
                        p1.add(readerid, constraints);
                        constraints.gridx = 1;
			p1.add(userid,constraints);
                        
                        
                        constraints.gridx = 0;
                        constraints.gridy = 1;  
                        JLabel pass = new JLabel("PASSWORD:");
                        pass.setFont(new Font ("Serif", Font.BOLD, 20));
                        pass.setForeground(Color.BLUE);
                        p1.add(pass, constraints);
                        constraints.gridx = 1;
			p1.add(password,constraints);
                        
                        TitledBorder tb = BorderFactory.createTitledBorder("Enter your ID and Paasword");
                        p1.setBorder(tb);
                        tb.setTitleColor(Color.blue);
			add(p1,BorderLayout.NORTH);
			setSize(700,500);
			JPanel p2= new JPanel(new FlowLayout(FlowLayout.CENTER));
			p2.setBackground(Color.white);
                        login.setFont(new Font ("Serif", Font.BOLD, 20));
                        login.setForeground(Color.BLUE);
                        p2.add(login);
			add(p2,BorderLayout.CENTER);
			
			login.addActionListener(new ButtonListener());
			
		}
private class ButtonListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("LOGIN")){
					
					userID = userid.getText();
			        String pwd = password.getText();
			        String query =   "select password from reader where reader_id = '"+userID+"'";
			      
			        try {
			        	ResultSet r = s.executeQuery(query);
			            if(r == null){
			                System.out.print("off");
			            }
			            if(r.next() == false){
			                JOptionPane op = new JOptionPane();
			                op.setMessage("The user "+userID+" doesn't exist  ");
			                op.setMessageType(0);
			                JDialog dia = op.createDialog(null,"Error");
			                dia.setTitle("LOGIN ERROR");
			                dia.setVisible(true);
			            }
			            else{
			            if(r.getString("password").equals(pwd)){
			                dispose();
			               UserMenu uMenu = new UserMenu();
			                uMenu.setVisible(true);;
			            }else{
			                JOptionPane op = new JOptionPane();
			                op.setMessage("The password for "+userID+" user is different  ");
			                op.setMessageType(0);
			                JDialog dia = op.createDialog(null,"Error");
			                dia.setTitle("LOGIN ERROR");
			                dia.setVisible(true);
			                
			            }
			           }
			        } catch (SQLException ex) {
			            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
			        }     
			        
			    }
			}
		}
}


