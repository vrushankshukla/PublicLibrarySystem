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
public class PrintBranch extends javax.swing.JFrame {
	
	private static Connection con=null;
	private static Statement s=null;
	private JTextField branchid= new JTextField();
	
	private JButton print= new JButton("Print >>"); 
	private JButton menu= new JButton("<< MAIN MENU"); 
	
	String st1=null,st2=null;
	
	public PrintBranch(){
        super("Branch Information");
        init();
        connectsql();}

	private void connectsql() {
		try{
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydbsystem", "root","Vrushank4DS891");
	        s = con.createStatement();
	        System.out.println("Connected to db");
	        
	    }catch(Exception e){
	        System.err.println("ERROR: "+e);
	    }
	
	}
	 private void displayGUI() {
	        JOptionPane.showMessageDialog(
	            null, getPanel(), "Output : ",
	                JOptionPane.INFORMATION_MESSAGE);
	    }

	    private JPanel getPanel() {
	        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
	        JLabel Label1 = getLabel("Branch Name : " + st1);
	        JLabel Label2 = getLabel("Branch Location : " + st2);
	        
	        panel.add(Label1);
	        panel.add(Label2);
	       
	        return panel;
	    }	
 
private JLabel getLabel(String string) {
	 return new JLabel(string);
		}
	private void init() {

		branchid.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
		
		
	JPanel p1=new JPanel(new GridLayout(1,0)); //Creating a panel for GUI
		p1.setBackground(Color.white);
                JLabel bid = new JLabel("Enter the Branch ID");
                bid.setFont(new Font ("Serif", Font.BOLD, 20));
                bid.setForeground(Color.BLUE);
		p1.add(bid);
		p1.add(branchid);
		
		TitledBorder tb = BorderFactory.createTitledBorder("Branch Info");
                p1.setBorder(tb);
                tb.setTitleColor(Color.blue);
		add(p1,BorderLayout.NORTH);
		setSize(700,500);
		
		JPanel p2= new JPanel(new FlowLayout(FlowLayout.CENTER));
                p2.setBackground(Color.white);
                menu.setFont(new Font ("Serif", Font.BOLD, 20));
                menu.setForeground(Color.RED);
		p2.add(menu);
                print.setFont(new Font ("Serif", Font.BOLD, 20));
                print.setForeground(Color.BLUE);
		p2.add(print);
		add(p2,BorderLayout.CENTER);
		print.addActionListener(new ButtonListener());
		menu.addActionListener(new ButtonListener());
		
}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		if(e.getActionCommand().equals("<< MAIN MENU")){
	    	dispose();
	    	AdminMenu aMenu=new AdminMenu();
	    	aMenu.setVisible(true);
	    	}
		
			
			if(e.getActionCommand().equals("Print >>")){
				String bid = branchid.getText();
		        
		        
		        String q = "select name,location from branch where branch_id="+bid+"";
		        
		         try {
		        	ResultSet rs = s.executeQuery(q);
		        	while(rs.next()){
		              st1=rs.getString("name");
		              st2=rs.getString("location");
		            }
		        	
		        	}
		            catch (SQLException ex) {
		            Logger.getLogger(AddBookCopy.class.getName()).log(Level.SEVERE, null, ex);
		        } displayGUI();
		         
		         }
			
		}
	}
			
	

}


