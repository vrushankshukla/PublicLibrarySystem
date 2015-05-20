/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Module;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author SONY
 */
public class AdminMenu extends javax.swing.JFrame {
        JCheckBox addCopy, searchBook, addReader,printBranch,top10FreqBorrower, top10MostBorrowedBook,avgFine, quit; 
	CheckboxGroup group; 
	
	JPanel panel=new JPanel(new GridLayout(8,0));
	private Connection con;
	public AdminMenu(){
                super("Admin Menu");
		init();
	}
	 public AdminMenu(Connection c) {
                super("Admin Menu");
	        init();
	        this.con = c;}
	
	private void init() {
                panel.setBackground(Color.white);
		group=new CheckboxGroup();
               
                setBackground(Color.white);
		
                addCopy=new JCheckBox("Add a Book",false);
                addCopy.setFont(new Font ("Serif", Font.BOLD, 16));
                addCopy.setForeground(Color.BLUE);
		addCopy.setBackground(Color.white);
                searchBook=new JCheckBox("Search Book & Get Status",false);
                searchBook.setFont(new Font ("Serif", Font.BOLD, 16));
                searchBook.setForeground(Color.BLUE);
		searchBook.setBackground(Color.white);
                addReader=new JCheckBox("Add New Reader",false);
		addReader.setFont(new Font ("Serif", Font.BOLD, 16));
                addReader.setForeground(Color.BLUE);
                addReader.setBackground(Color.white);
                printBranch=new JCheckBox("Get Branch Information",false);
		printBranch.setFont(new Font ("Serif", Font.BOLD, 16));
                printBranch.setForeground(Color.BLUE);
                printBranch.setBackground(Color.white);
                top10FreqBorrower=new JCheckBox("Get Information of Top 10 Most Frequent Borrowers in a Branch",false);
		top10FreqBorrower.setFont(new Font ("Serif", Font.BOLD, 16));
                top10FreqBorrower.setForeground(Color.BLUE);
                top10FreqBorrower.setBackground(Color.white);
                top10MostBorrowedBook=new JCheckBox("Get Information of Top 10 Most Borrowed Books in a Branch",false);
		top10MostBorrowedBook.setFont(new Font ("Serif", Font.BOLD, 16));
                top10MostBorrowedBook.setForeground(Color.BLUE);
                top10MostBorrowedBook.setBackground(Color.white);
                avgFine=new JCheckBox("Find the Average Fine",false);
		avgFine.setFont(new Font ("Serif", Font.BOLD, 16));
                avgFine.setForeground(Color.BLUE);
                avgFine.setBackground(Color.white);
               
                quit=new JCheckBox("Quit",false);
                quit.setFont(new Font ("Serif", Font.BOLD, 16));
                quit.setForeground(Color.RED);
                quit.setBackground(Color.white);
                TitledBorder tb = BorderFactory.createTitledBorder("Select Your Choice");
                panel.setBorder(tb);
                tb.setTitleColor(Color.blue);
		
                add(panel,BorderLayout.CENTER);
		setSize(700,500);
		panel.add(addCopy); 
		
		panel.add(searchBook); 
		
		panel.add(addReader);
		
		panel.add(printBranch); 
		
		panel.add(top10FreqBorrower); 
		
		panel.add(top10MostBorrowedBook);
		
		panel.add(avgFine); 
		
		panel.add(quit); 
		add(panel,BorderLayout.CENTER);
		 panel.setVisible(true);
		
		ActionListener actionListener = new ActionHandler();
		addCopy.addActionListener(actionListener);
		searchBook.addActionListener(actionListener);
		addReader.addActionListener(actionListener);
		printBranch.addActionListener(actionListener);
		top10FreqBorrower.addActionListener(actionListener);
		top10MostBorrowedBook.addActionListener(actionListener);
		avgFine.addActionListener(actionListener);
		quit.addActionListener(actionListener);
		
}
		
	class ActionHandler implements ActionListener {
	   
	    public void actionPerformed(ActionEvent event) {
	        JCheckBox checkbox = (JCheckBox) event.getSource();
	        if (checkbox == addCopy) {
	           dispose();
	           AddBookCopy abCopy=new AddBookCopy();
	           abCopy.setVisible(true);
	        } else if (checkbox == searchBook) {
	        	 dispose();
		           SearchById sCopy=new SearchById();
		           sCopy.setVisible(true);
	        } else if (checkbox == addReader) {
	            dispose();
	            AddReader addreader=new AddReader();
	            addreader.setVisible(true);
	        }else if (checkbox == printBranch) {
	        	dispose();
	            PrintBranch printbranch=new PrintBranch();
	            printbranch.setVisible(true);
	        } else if (checkbox == top10FreqBorrower) {
	        	dispose();
	            BranchForReaders topb=new BranchForReaders();
	            topb.setVisible(true);
	        }else if (checkbox == top10MostBorrowedBook) {
	           dispose();
	           BranchForBooks ttb=new BranchForBooks();
	           ttb.setVisible(true);
	        }else if (checkbox == avgFine) {
	            dispose();
	            AvgFine fine=new AvgFine();
	            fine.setVisible(true);
	        } else if (checkbox == quit) {
	            dispose();
	        }
	    }}		
}

	




