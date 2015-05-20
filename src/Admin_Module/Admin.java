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
 * @author Shukla
 */
public class Admin extends javax.swing.JFrame {
	private Connection con=null;
	private Statement s=null;
	private JTextField adminusername= new JTextField();
	private JTextField adminpassword= new JTextField();
	private JButton login= new JButton("LOGIN"); 
	
	  public Admin(){
	      super("Admin Login");  
              init();}
	    
	    public Admin(Connection c) {
	        super("Admin Login");
                init();
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydbsystem", "root","Vrushank4DS891");
	            s = con.createStatement();
	            
	        }catch(Exception e){
	            System.err.println("ERROR: "+e);
	        }}

private void init() {
		
			adminusername.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
			adminpassword.setHorizontalAlignment(JTextField.LEFT);
			
			JPanel p1=new JPanel(new GridLayout(0,2)); //Creating a panel for GUI
			p1.setBackground(Color.white);
                        GridBagConstraints constraints = new GridBagConstraints();
                        constraints.anchor = GridBagConstraints.WEST;
                        constraints.insets = new Insets(10, 10, 10, 10);
        
                        constraints.gridx = 0;
                        constraints.gridy = 0;
                        JLabel adminid = new JLabel("ADMIN_ID#:");
                        adminid.setFont(new Font ("Serif", Font.BOLD, 20));
                        adminid.setForeground(Color.BLUE);
                        p1.add(adminid, constraints);
        
                        constraints.gridx = 1;
                        p1.add(adminusername, constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 1;  
                        JLabel pass = new JLabel("PASSWORD:");
                        pass.setFont(new Font ("Serif", Font.BOLD, 20));
                        pass.setForeground(Color.BLUE);
                        p1.add(pass, constraints);
        
                        constraints.gridx = 1;
                        p1.add(adminpassword, constraints);
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
					
					String username = adminusername.getText();
			        String password = adminpassword.getText();
			        String query = "select password from admin where id ='"+username+"'";
			      
			        try {
			        	ResultSet r = s.executeQuery(query);
			        	
			            if(r == null){
			                System.out.print("off");
			            }
			            if(r.next() == false){
			                JOptionPane op = new JOptionPane();
                                        op.setBackground(Color.white);
                                        op.setFont(new Font ("Serif", Font.BOLD, 20));
                                        op.setForeground(Color.BLUE);
			                op.setMessage("The username "+username+" doesn't exist  ");
			                op.setMessageType(0);
			                JDialog dia = op.createDialog(null,"Error");
                                        dia.setFont(new Font ("Serif", Font.BOLD, 20));
                                        dia.setForeground(Color.BLUE);
			                dia.setTitle("LOGIN ERROR");
			                dia.setVisible(true);
			            }
			            else{
			            if(r.getString("password").equals(password)){
			                dispose();
			               AdminMenu aMenu = new AdminMenu(con);
			                aMenu.setVisible(true);
			            }else{
			                JOptionPane op = new JOptionPane();
                                        op.setBackground(Color.white);
                                        op.setFont(new Font ("Serif", Font.BOLD, 20));
                                        op.setForeground(Color.BLUE);
			                op.setMessage("The password for "+username+" user is different  ");
			                op.setMessageType(0);
			                JDialog dia = op.createDialog(null,"Error");
                                        dia.setFont(new Font ("Serif", Font.BOLD, 20));
                                        dia.setForeground(Color.BLUE);
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



