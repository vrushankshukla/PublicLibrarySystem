/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Menu;
import Admin_Module.*;
import java.awt.Color;
import java.awt.Font;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


/**
 *
 * @author Shukla
 */
public class BookReturn extends javax.swing.JFrame {
    Connection con; Statement s;
    String id=User.userID;
    DefaultListModel dl = new DefaultListModel();

    private javax.swing.JList bookList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    
    public BookReturn() {
        super("Return Book");
        init();
        connectsql();
        initList();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setFont(new Font ("Serif", Font.BOLD, 20));
        jScrollPane1.setForeground(Color.BLUE);
        bookList = new javax.swing.JList();
        bookList.setFont(new Font ("Serif", Font.BOLD, 16));
        bookList.setForeground(Color.RED);
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton1.setForeground(Color.BLUE);
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton2.setForeground(Color.RED);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font ("Serif", Font.BOLD, 20));
        jLabel1.setForeground(Color.BLUE);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(bookList);

        jButton1.setText("RETURN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<< BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("PLEASE SELECT THE BOOK YOU WANT TO RETURN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       .addGroup(layout.createSequentialGroup()
          .addGap(43, 43, 43)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addGroup(layout.createSequentialGroup()
             .addComponent(jButton2)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(jButton1))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)))
            .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setSize(700, 500);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	dispose();
        UserMenu umenu=new UserMenu();
        umenu.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            String da = dateFormat.format(date);
            
            String s = bookList.getSelectedValue().toString();
            String q1 = "Update borrow SET r_date ='"+da+"' where reader_id='"+this.id+"' AND book_id='"+s+"'";
            try{
                this.con.createStatement().execute(q1);
            }catch(SQLException e){
                System.out.println(e.getMessage());

            }
                dl.removeElement(s);
                
                JOptionPane op = new JOptionPane();
                op.setMessage("Thank you for returning the book "+s);
                op.setMessageType(1);
                JDialog dia = op.createDialog(null,"Info");
                dia.setTitle("INFO");
                dia.setVisible(true);
    }

 
 private void initList() {
        try {
            bookList.setModel(dl);
                                   
            String q1 = "Select * from borrow where reader_id ='"+this.id+"' AND r_date IS NULL";
            ResultSet r1 = this.con.createStatement().executeQuery(q1);
            while(r1.next()){
                dl.addElement(r1.getString("book_id"));
            }r1.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookReturn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

