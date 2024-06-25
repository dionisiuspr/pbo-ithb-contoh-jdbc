/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseeex;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Dionisius Pratama
 */
public class DatabaseeExUI extends JFrame {
        
    private JPanel pnl;
    
    private JLabel lblNama;
    private JLabel lblNIM;
    
    private JTextField txtNama;
    private JTextField txtNIM;
    
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnShow;

    //head
    JTable lblTable;
    JScrollPane jScroll;
    
//======
    JTable tblShow;
    JScrollPane jscroll;
    String[] os1 = {"NIM", "Nama"};
    String[][] os2 = {};

    public DatabaseeExUI() {
        initComponent();
    }

    private void initComponent() {
        setTitle("Mahasiswa");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        pnl = new JPanel();
        pnl.setSize(600, 600);
        pnl.setOpaque(false); //set transperancy
        pnl.setLayout(null); //spy bisa ngatur posisi
        add(pnl);

        tblShow = new JTable(os2, os1);
        jscroll = new JScrollPane(tblShow);
        jscroll.setLocation(100, 10);
        jscroll.setOpaque(false);
        jscroll.setSize(new Dimension(150, 100));
        this.add(jscroll);

        lblNama = new JLabel("Nama");
        lblNama.setBounds(10, 250, 70, 25);
        pnl.add(lblNama);
        txtNama = new JTextField(50);
        txtNama.setBounds(90, 250, 180, 25);
        pnl.add(txtNama);
        
        lblNIM = new JLabel("Nim");
        lblNIM.setBounds(10, 290, 70, 25);
        pnl.add(lblNIM);
        txtNIM = new JTextField(50);
        txtNIM.setBounds(90, 290, 180, 25);
        pnl.add(txtNIM);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(10, 360, 100, 35);
        pnl.add(btnAdd);
        btnAdd = new JButton("Delete");
        btnAdd.setBounds(110, 360, 100, 35);
        pnl.add(btnAdd);
        btnAdd = new JButton("Update");
        btnAdd.setBounds(210, 360, 100, 35);
        pnl.add(btnAdd);
        btnAdd = new JButton("Show");
        btnAdd.setBounds(310, 360, 100, 35);
        pnl.add(btnAdd);
        
    }

    public static void main(String[] args) {
        new DatabaseeExUI().setVisible(true);
    }

}
