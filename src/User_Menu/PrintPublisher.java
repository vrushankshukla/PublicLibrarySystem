/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Menu;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import Admin_Module.UserMenu;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Shukla
 */
public class PrintPublisher extends javax.swing.JFrame {
    Connection con; Statement s;
    private javax.swing.JTextArea infotxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox pubcom;
    
    public PrintPublisher() {
        super("Publisher Book List");
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

        pubcom = new javax.swing.JComboBox();
        pubcom.setFont(new Font ("Serif", Font.BOLD, 16));
        pubcom.setForeground(Color.BLUE);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font ("Serif", Font.BOLD, 20));
        jLabel1.setForeground(Color.BLUE);
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton1.setForeground(Color.BLUE);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setFont(new Font ("Serif", Font.BOLD, 20));
        jSeparator1.setForeground(Color.BLUE);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setFont(new Font ("Serif", Font.BOLD, 20));
        jScrollPane1.setForeground(Color.BLUE);
        infotxt = new javax.swing.JTextArea();
        infotxt.setFont(new Font ("Serif", Font.BOLD, 16));
        infotxt.setForeground(Color.RED);
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton2.setForeground(Color.BLUE);
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new Font ("Serif", Font.BOLD, 20));
        jButton3.setForeground(Color.RED);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pubcom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pub1   ", "pub2   ", "pub3   ", "pub4   ", "pub5   ", "pub6   ", "pub7   ", "pub8   ", "pub9   ", "pub10   ", "pub11   ", "pub12   ", "pub13   ", "pub14   ", "pub15   ", "pub16   ", "pub17   ", "pub18   ", "pub19" }));

        jLabel1.setText("PUBLISHER:");

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        infotxt.setColumns(20);
        infotxt.setRows(5);
        jScrollPane1.setViewportView(infotxt);

        jButton2.setText("NEXT>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
               .addGap(34, 34, 34)
             .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
               .addComponent(pubcom, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                   .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
             .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pubcom, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
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
    	infotxt.setText(" ");
        String msg = "";
        String t="";
        String i = "";
        try {
            String p = pubcom.getSelectedItem().toString();
            String q1 = "Select * from publisher where publisher_name='"+p+"'";
            ResultSet r1 = this.con.createStatement().executeQuery(q1);
            while(r1.next()){
                p = r1.getString("publisher_id");
            }r1.close();
            
            String q2 = "Select * from book_info where publisher_id = '"+p+"'";
            ResultSet r2 = this.con.createStatement().executeQuery(q2);
            
            while(r2.next()){
                t = r2.getString("title");
                msg +="\n"+r2.getString("title");
            }r2.close();
            
            String q3 = "Select isbn from book_info where title = '"+t+"'";
            ResultSet r3 = this.con.createStatement().executeQuery(q3);
            while(r3.next()){
                i = r3.getString("isbn");
            }r3.close();
            
            String q4 = "Select book_id from book where isbn = '"+i+"'";
            ResultSet r4 = this.con.createStatement().executeQuery(q4);
            while(r4.next()) {
                msg += " | Book_ID# " +r4.getString("book_id");
            }r4.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PrintPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        infotxt.append(msg);
    }

   }


