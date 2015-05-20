/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Module;
import java.applet.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 *
 * @author SHUKLA
 */
public class MainMenu extends javax.swing.JFrame {
	Connection con;
	private JLabel adminUse = new JLabel("For administrative use: ");
        private JLabel readerUse = new JLabel("For reader use:        ");
	private JButton admin= new JButton("ADMIN");
	private JButton reader= new JButton("READER");
	private JButton quit= new JButton("QUIT");

	private Statement st;
	
	public MainMenu(){
                super("Welcome to New York Public Library");
		init();
		connectsql();
	}
	

private void connectsql() {
	 try{
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydbsystem", "root","Vrushank4DS891");
         st = con.createStatement();
         
     }catch(Exception e){
         System.err.println("ERROR: "+e);
     }
 }
		
public void init(){
	
	JPanel p1=new JPanel(new GridBagLayout());
//        JLabel i = new JLabel();
//        i.setIcon(new ImageIcon("C:\\Users\\SONY\\Documents\\NetBeansProjects\\PublicLibraraySystem\\src\\img\\icon.png"));
//        i.setSize(5, 5);
        p1.setBackground(Color.white);
//        p1.add(i);
//        validate();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        constraints.gridx = 0;
        constraints.gridy = 0;   
        adminUse.setFont(new Font ("Serif", Font.BOLD, 20));
        adminUse.setForeground(Color.BLUE);
        p1.add(adminUse, constraints);
        
        constraints.gridx = 1;
        admin.setFont(new Font ("Serif", Font.BOLD, 20));
        admin.setForeground(Color.BLUE);
        p1.add(admin, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1; 
        readerUse.setFont(new Font ("Serif", Font.BOLD, 20));
        readerUse.setForeground(Color.BLUE);
        p1.add(readerUse, constraints);
        
        constraints.gridx = 1;
        reader.setFont(new Font ("Serif", Font.BOLD, 20));
        reader.setForeground(Color.BLUE);
        p1.add(reader, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        quit.setFont(new Font ("Serif", Font.BOLD, 20));
        quit.setForeground(Color.RED);
        p1.add(quit, constraints);
        TitledBorder tb = BorderFactory.createTitledBorder("Select Your Choice");
        p1.setBorder(tb);
        tb.setTitleColor(Color.blue);
        
	
        setSize(700,500);
	add(p1,BorderLayout.CENTER);
	
	admin.addActionListener(new ButtonListener());
	reader.addActionListener(new ButtonListener());
	quit.addActionListener(new ButtonListener());
}
private class ButtonListener implements ActionListener{
	
	private Connection con;

	public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("ADMIN")){
				dispose();
		        Admin admin = new Admin(this.con);
		        admin.setVisible(true);
			}
		
		
		if(e.getActionCommand().equals("READER")){
			dispose();
			User user=new User(this.con);
			user.setVisible(true);
		}
		
		if(e.getActionCommand().equals("QUIT"))
			{System.exit(0);}
			
		}
	}
	
	
  
public static void main(String args[]) {
          try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MainMenu().setVisible(true);
        }
});
}

}



