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
public class SearchById extends javax.swing.JFrame {
	 private static Connection con=null;
	 Statement s;
	 
	  private JTextField bookid= new JTextField();
	  private JButton back=new JButton("BACK");
      private JButton enter= new JButton("ENTER");
      JPanel p1=new JPanel(new GridLayout(1,0)); //Creating a panel for GUI
      public static String st1 = null,st2 = null,st3 = null,st4 = null,st5 = null,st6 = null,st7 = null;
      int int1=0;
      public SearchById(){
                super("Search For a Book");
	        init();
	        connectsql();}
	    
	    private void connectsql() {
	    	try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydbsystem", "root","Vrushank4DS891");
	            s = con.createStatement();
	           
	            System.out.println("connected");
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
	        JLabel Label1 = getLabel("Book Name : " + st1);
	        JLabel Label2 = getLabel("Author : " + st2);
	        JLabel Label3= getLabel("Publisher : " + st3);
	        JLabel Label4 = getLabel("Publication Date : " + st4);
	        JLabel Label5 = getLabel("ISBN : " + st5);
	        panel.add(Label1);
	        panel.add(Label2);
	        panel.add(Label3);
	        panel.add(Label4);
	        panel.add(Label5);

	        return panel;
	    }	
    
private JLabel getLabel(String string) {
	 return new JLabel(string);
		}

private void init() {
		p1.setBackground(Color.white);
		bookid.setHorizontalAlignment(JTextField.LEFT);// Set inputs alignments
		
		setSize(700,500);
                JLabel id = new JLabel("Enter the Book ID:");
                id.setFont(new Font ("Serif", Font.BOLD, 20));
                id.setForeground(Color.BLUE);
                p1.add(id);
		p1.add(bookid);
                TitledBorder tb = BorderFactory.createTitledBorder("Search by Book ID");
                p1.setBorder(tb);
                tb.setTitleColor(Color.blue);
		add(p1,BorderLayout.NORTH);
		setVisible(true);
		JPanel p2= new JPanel(new FlowLayout(FlowLayout.CENTER));
                p2.setBackground(Color.white);
                back.setFont(new Font ("Serif", Font.BOLD, 20));
                back.setForeground(Color.RED);
		p2.add(back);
                enter.setFont(new Font ("Serif", Font.BOLD, 20));
                enter.setForeground(Color.BLUE);
		p2.add(enter);
		add(p2,BorderLayout.CENTER);
		back.addActionListener(new ButtonListener());
		enter.addActionListener(new ButtonListener());
		
}
private class ButtonListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("BACK")){
			dispose();
			AdminMenu amenu=new AdminMenu();
			amenu.setVisible(true);
			
		}
		
		if(e.getActionCommand().equals("ENTER")){
 			String id = bookid.getText();
 			ResultSet rs=null;
 			String query1 = null,query2 = null,query3 = null,query4 = null,query5 = null;
			 try {
		        	query1= "select book_info.title, book_info.isbn from book_info join book on book.isbn=book_info.isbn where book.book_id="+id+"";
	                 rs = s.executeQuery(query1);
	                while(rs.next()){
		                st1 =rs.getString("title");
		                st5=rs.getString("isbn");
		                }rs.close();
	                query2= "select publication_date from book_info where isbn= "+st5+"";
	                  rs = s.executeQuery(query2);
	                while(rs.next()){
		                st4 =rs.getString("publication_date");
		                }rs.close();
	                query3= "select publisher_name from publisher join book_info on book_info.publisher_id=publisher.publisher_id where book_info.isbn="+st5+"";
	                  rs = s.executeQuery(query3);
	                while(rs.next()){
		                st3 =rs.getString("publisher_name");
		                }rs.close();
	                query4= "select name from author join book_info on book_info.author_id=author.author_id where isbn="+st5+"";
	                  rs = s.executeQuery(query4);
	                while(rs.next()){
		                st2 =rs.getString("name");
		                System.out.println(st6);
		        	} rs.close();
	                
			 }
			 
			 catch (SQLException ex) {
		            Logger.getLogger(SearchById.class.getName()).log(Level.SEVERE, null, ex);
		        }     
			 
			 displayGUI();
		}
}}}



