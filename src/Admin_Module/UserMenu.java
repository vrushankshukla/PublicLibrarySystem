/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Module;
import User_Menu.*;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.BorderFactory;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Shukla
 */
public class UserMenu extends javax.swing.JFrame{

	JCheckBox searchBook, bookCheckout,bookReturm,bookReserve, computeFine,printReserved, printPublisher,quit; 
	CheckboxGroup group; 
	Label lab; Statement s;
	JPanel panel=new JPanel(new GridLayout(8,0));
	private Connection con;
	
	public UserMenu(){
                super("User Login");
		init();
		connectsql();
	}
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
	
	
	private void init() {
                panel.setBackground(Color.white);
		group=new CheckboxGroup();
		setBackground(Color.white);
		searchBook=new JCheckBox("Search a Book",false);
                searchBook.setFont(new Font ("Serif", Font.BOLD, 16));
                searchBook.setForeground(Color.BLUE);
		searchBook.setBackground(Color.white);
		bookCheckout=new JCheckBox("Book Checkout",false);
                bookCheckout.setFont(new Font ("Serif", Font.BOLD, 16));
                bookCheckout.setForeground(Color.BLUE);
		bookCheckout.setBackground(Color.white);
		bookReturm=new JCheckBox("Book Return",false);
                bookReturm.setFont(new Font ("Serif", Font.BOLD, 16));
                bookReturm.setForeground(Color.BLUE);
		bookReturm.setBackground(Color.white);
		bookReserve=new JCheckBox("Book Reserve",false);
                bookReserve.setFont(new Font ("Serif", Font.BOLD, 16));
                bookReserve.setForeground(Color.BLUE);
		bookReserve.setBackground(Color.white);
		computeFine=new JCheckBox("Compute Fine",false);
		computeFine.setFont(new Font ("Serif", Font.BOLD, 16));
                computeFine.setForeground(Color.BLUE);
		computeFine.setBackground(Color.white);
                printReserved=new JCheckBox("Get the List of Book Reserved",false);
		printReserved.setFont(new Font ("Serif", Font.BOLD, 16));
                printReserved.setForeground(Color.BLUE);
		printReserved.setBackground(Color.white);
                printPublisher=new JCheckBox("Get the Book_ID & Titles of books Published by a Publisher",false);
		printPublisher.setFont(new Font ("Serif", Font.BOLD, 16));
                printPublisher.setForeground(Color.BLUE);
		printPublisher.setBackground(Color.white);
                quit=new JCheckBox("Quit",false);
		quit.setFont(new Font ("Serif", Font.BOLD, 16));
                quit.setForeground(Color.RED);
		quit.setBackground(Color.white);
		setSize(700,500);
		panel.add(searchBook); 
		
		panel.add(bookCheckout); 
		
		panel.add(bookReturm);
		
		panel.add(bookReserve); 
		
		panel.add(computeFine); 
		
		panel.add(printReserved);
		
		panel.add(printPublisher); 
		
		panel.add(quit); 
                
                TitledBorder tb = BorderFactory.createTitledBorder("Select Your Choice");
                panel.setBorder(tb);
                tb.setTitleColor(Color.blue);
		add(panel,BorderLayout.CENTER);
		 panel.setVisible(true);
		
		ActionListener actionListener = new ActionHandler();
		searchBook.addActionListener(actionListener);
		bookCheckout.addActionListener(actionListener);
		bookReturm.addActionListener(actionListener);
		bookReserve.addActionListener(actionListener);
		computeFine.addActionListener(actionListener);
		printReserved.addActionListener(actionListener);
		printPublisher.addActionListener(actionListener);
		quit.addActionListener(actionListener);
		
}
		
	class ActionHandler implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent event) {
	        JCheckBox checkbox = (JCheckBox) event.getSource();
	        if (checkbox == searchBook) {
	            dispose();
	            BookSearch bsearch= new BookSearch();
	            bsearch.setVisible(true);
	        } else if (checkbox == bookCheckout) {
	        	dispose();
	            BookCheckout bc= new BookCheckout();
	            bc.setVisible(true);
	        } else if (checkbox == bookReturm) {
	        	dispose();
	            BookReturn br= new BookReturn();
	            br.setVisible(true);
	        }else if (checkbox == bookReserve) {
	        	dispose();
	            BookReserve bres= new BookReserve();
	            bres.setVisible(true);
	        }else if (checkbox == computeFine) {
	        	dispose();
	            ComputeFine cf= new ComputeFine();
	            cf.setVisible(true);
	           
	        }else if (checkbox == printReserved) {
	        	dispose();
	            PrintBookList printbook= new PrintBookList();
	            printbook.setVisible(true);
	        } else if (checkbox == printPublisher) {
	        	dispose();
	            PrintPublisher printpub= new PrintPublisher();
	            printpub.setVisible(true);
	        }else if (checkbox == quit) {
	            dispose();
	        }


	    }}		
}


