/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Menu;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Admin_Module.UserMenu;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Shukla
 */
public class PrintBookList extends javax.swing.JFrame {
    Connection con; Statement s;
    
    private javax.swing.JTextArea infotext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField titletxt;
   
    public PrintBookList() {
        super("List of Books");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setFont(new Font ("Serif", Font.BOLD, 20));
        jPanel1.setForeground(Color.BLUE);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font ("Serif", Font.BOLD, 20));
        jLabel1.setForeground(Color.BLUE);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setFont(new Font ("Serif", Font.BOLD, 20));
        jSeparator1.setForeground(Color.BLUE);
        titletxt = new javax.swing.JTextField();
        titletxt.setFont(new Font ("Serif", Font.BOLD, 20));
        titletxt.setForeground(Color.BLUE);
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton1.setForeground(Color.BLUE);
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton2.setForeground(Color.BLUE);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setFont(new Font ("Serif", Font.BOLD, 20));
        jScrollPane1.setForeground(Color.BLUE);
        infotext = new javax.swing.JTextArea();
        infotext.setFont(new Font ("Serif", Font.BOLD, 16));
        infotext.setForeground(Color.RED);
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton3.setForeground(Color.RED);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.setBackground(Color.white);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TITLE:");

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("NEXT >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        infotext.setColumns(20);
        infotext.setRows(5);
        jScrollPane1.setViewportView(infotext);

        jButton3.setText("<< BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createSequentialGroup()
                   .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                   .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jButton3)
                   .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3});

        pack();
        setSize(700,500);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	 dispose();
         UserMenu uMenu=new UserMenu();
         uMenu.setVisible(true);
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        BookSearch bsearch = new BookSearch();
        bsearch.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            try {
            String msg = "";
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            List<String> bids = new ArrayList();
            String da = dateFormat.format(date);
            String ti = titletxt.getText();
            String query = "Select * from book_info where title ='"+ti+"'";
            ResultSet res = this.con.createStatement().executeQuery(query);
            String submsg = "";
            while(res.next()){
                String q1 = "Select * from author where author_id = '"+res.getString("author_id")+"'";
                ResultSet r1 = this.con.createStatement().executeQuery(q1);
                String auth = "";
                while(r1.next()){
                    auth = r1.getString("name");
                }r1.close();
                
                msg = "TITLE: "+ti+"\nISBN: "+res.getString("isbn")+"\nAUTHOR: "+auth+"\n"; 
                String q3 = "Select * from book where isbn ='"+res.getString("isbn")+"'";
                ResultSet r3 = this.con.createStatement().executeQuery(q3);
                while(r3.next()){
                    bids.add(r3.getString("book_id"));
                }r3.close();
            }res.close();
            
            String msg2 = "";
            for(String bid: bids){
                msg2 += "Book ID "+bid+"\n";
            }
            infotext.setText(msg+msg2);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 }

