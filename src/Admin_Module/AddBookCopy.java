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
public class AddBookCopy extends javax.swing.JFrame {


	private static Connection con=null;
	private static Statement s=null;
        private static Statement s1=null;
	private JTextField title= new JTextField();
	private JTextField isbn= new JTextField();
	private JTextField pubName= new JTextField();
	private JTextField pubAdd= new JTextField();
	private JTextField pubDate= new JTextField();
	private JTextField branchId= new JTextField();
	private JTextField authorName= new JTextField();
	private JTextField copy= new JTextField();
	
	
	private JButton add= new JButton("ADD >>"); 
	private JButton menu= new JButton("<< MAIN MENU"); 
	 public AddBookCopy(){
                super("Add Book");
	        init();
	        connectsql();}
	    
	   

		private void connectsql() {
			try{
		        Class.forName("com.mysql.jdbc.Driver");
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydbsystem", "root","Vrushank4DS891");
		        s = con.createStatement();
                        s1=con.createStatement();
		        System.out.println("Connected to db");
		        
		    }catch(Exception e){
		        System.err.println("ERROR: "+e);
		    }
		
	}

@SuppressWarnings("unchecked")
private void init()
{
        
	title.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
	isbn.setHorizontalAlignment(JTextField.LEFT);
	pubName.setHorizontalAlignment(JTextField.LEFT);
	pubAdd.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
	pubDate.setHorizontalAlignment(JTextField.LEFT);
	authorName.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
	branchId.setHorizontalAlignment(JTextField.LEFT);
	copy.setHorizontalAlignment(JTextField.LEFT);
	
JPanel p1=new JPanel(new GridLayout(8,0)); //Creating a panel for GUI
        p1.setBackground(Color.white);
        JLabel ltitle = new JLabel("Title of the Book");
        ltitle.setFont(new Font ("Serif", Font.BOLD, 20));
        ltitle.setForeground(Color.BLUE);
	p1.add(ltitle);
	p1.add(title);
        JLabel lisbn = new JLabel("ISBN");
        lisbn.setFont(new Font ("Serif", Font.BOLD, 20));
        lisbn.setForeground(Color.BLUE);
	p1.add(lisbn);
	p1.add(isbn);
        JLabel lpname = new JLabel("Publisher Name");
        lpname.setFont(new Font ("Serif", Font.BOLD, 20));
        lpname.setForeground(Color.BLUE);
	p1.add(lpname);
	p1.add(pubName);
        JLabel loc = new JLabel("Publisher Location");
        loc.setFont(new Font ("Serif", Font.BOLD, 20));
        loc.setForeground(Color.BLUE);
	p1.add(loc);
	p1.add(pubAdd);
        JLabel lpdate = new JLabel("Publication Date");
        lpdate.setFont(new Font ("Serif", Font.BOLD, 20));
        lpdate.setForeground(Color.BLUE);
	p1.add(lpdate);
	p1.add(pubDate);
        JLabel laname = new JLabel("Author Name");
        laname.setFont(new Font ("Serif", Font.BOLD, 20));
        laname.setForeground(Color.BLUE);
	p1.add(laname);
	p1.add(authorName);
        JLabel lbid = new JLabel("Branch ID");
        lbid.setFont(new Font ("Serif", Font.BOLD, 20));
        lbid.setForeground(Color.BLUE);
	p1.add(lbid);
	p1.add(branchId);
        JLabel lnoc = new JLabel("Number of Copy");
        lnoc.setFont(new Font ("Serif", Font.BOLD, 20));
        lnoc.setForeground(Color.BLUE);
	p1.add(lnoc);
	p1.add(copy);
        
        TitledBorder tb = BorderFactory.createTitledBorder("Enter all the details to add a book");
        p1.setBorder(tb);
        tb.setTitleColor(Color.blue);
	add(p1,BorderLayout.NORTH);
	setSize(700,500);
	
	JPanel p2= new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.setBackground(Color.white);
	menu.setFont(new Font ("Serif", Font.BOLD, 20));
        menu.setForeground(Color.RED);
        p2.add(menu);
        add.setFont(new Font ("Serif", Font.BOLD, 20));
        add.setForeground(Color.BLUE);
	p2.add(add);
	add(p2,BorderLayout.CENTER);
	add.addActionListener(new ButtonListener());
	menu.addActionListener(new ButtonListener());
	
}
private class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
	if(e.getActionCommand().equals("<< MAIN MENU")){
    	dispose();
    	AdminMenu aMenu=new AdminMenu();
    	aMenu.setVisible(true);
    	}
                 String st2=null,st1=null; String query4=null,query5=null;
		ResultSet rs=null,rs1=null;
		if(e.getActionCommand().equals("ADD >>")){
			String btitle = title.getText();
	        String bisbn = isbn.getText();
	        String pname = pubName.getText();
	        String pdate = pubDate.getText();
	        String padd = pubAdd.getText();
	        String aname = authorName.getText();
	        String branch=branchId.getText();
	        String cpy= copy.getText();
	        
	        String q =  "INSERT INTO book (isbn) "
                     + "values ('"+bisbn+"')";
	        String q1= "INSERT INTO author (name) "
                    + "values ('"+aname+"')";
	        String q2= "INSERT INTO publisher (publisher_name,location) "
                    + "values ('"+pname+"','"+padd+"')";
	        String q3= "INSERT INTO copy (branch_id, isbn, number_of_copies) "
                    + "values ('"+branch+"','"+bisbn+"','"+cpy+"')";
                
               
	         try {
	        	int r = s.executeUpdate(q);
	        	if(r == 0){
	                System.out.print("off");
	            }
	        	int r1= s.executeUpdate(q1);
	        	if(r1 == 0){
	                System.out.print("off");
	            }
	        	int r2 = s.executeUpdate(q2);
	        	if(r2== 0){
	                System.out.print("off");
	            }
	        	int r3 = s.executeUpdate(q3);
	        	if(r3 == 0){
	                System.out.print("off");
	            }
                        
                            con.close();
                            connectsql();
                    query5= "select author_id from author where name=\""+aname+"\"";
                       rs1 = s1.executeQuery(query5);
	                while(rs1.next()){
		               st1 =rs1.getString("author_id");
		                System.out.println(st1);
		        	} rs1.close();
                       
                        query4= "select publisher_id from publisher where publisher_name=\""+pname+"\"";
                           rs = s.executeQuery(query4);
	                while(rs.next()){
		               st2 =rs.getString("publisher_id");
		                
		        	} rs.close();
                                
                        String q4= "INSERT INTO `book_info` (`isbn`, `title`, `publisher_id`, `publication_date`, `author_id`)"
                    + "values ('"+bisbn+"','"+btitle+"','"+st2+"','"+pdate+"','"+st1+"')";
                    int r4 = s.executeUpdate(q4);
                          if(r4 == 0){
	                System.out.print("off");}
                          
                         
                    
	           }
	            catch (SQLException ex) {
	            Logger.getLogger(AddBookCopy.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	        JOptionPane.showMessageDialog(
 	            null, "The Book has been successfully added! ", " ",
 	                JOptionPane.INFORMATION_MESSAGE);	         
	         
	 	    }
				
	        
	         }}

}

		
	

		



