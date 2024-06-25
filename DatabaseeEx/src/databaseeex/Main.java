package databaseeex;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dionisius Pratama
 */
public class Main extends JFrame implements ActionListener {

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

    public Main() {
        initComponent();
        showToTable(DataAkses.showMahasiswa());
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
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int confirm = JOptionPane.showConfirmDialog(null, 
                        "Tambahkan data? ", "Konfirmasi", JOptionPane.YES_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String nama = txtNama.getText();
                    String nim = txtNIM.getText();
                    Mahasiswa m = new Mahasiswa(nama, nim);
                    DataAkses.addMahasiswa(m);
                    showToTable(DataAkses.showMahasiswa());
                }
            }
        }
        );
        pnl.add(btnAdd);
        
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(110, 360, 100, 35);
        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                String nim = JOptionPane.showInputDialog(null, "Masukkan NIM: ");
                DataAkses.delMahasiswa(nim);
                showToTable(DataAkses.showMahasiswa());
                JOptionPane.showMessageDialog(null, "Tabel Diperbarui");
            }
        });
        pnl.add(btnDelete);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(210, 360, 100, 35);
        btnUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(txtNIM.isEditable()){
                    String nim = JOptionPane.showInputDialog(null, "Masukkan NIM: ");
                    Mahasiswa m = DataAkses.searchMahasiswa(nim);
                    
                    if(m == null){
                        JOptionPane.showMessageDialog(null, "NIM tidak ditemukan");
                        
                    }else{
                        txtNama.setText(m.getNama());
                        txtNIM.setText(m.getNim());
                        txtNIM.setEditable(false);
                    }
                }else{
                    Mahasiswa m2 = new Mahasiswa();
                    m2.setNama(txtNama.getText()+"");
                    m2.setNim(txtNIM.getText()+"");
                    DataAkses.updateMahasiswa(m2);
                    txtNIM.setEditable(true);
                    showToTable(DataAkses.showMahasiswa());
                    JOptionPane.showMessageDialog(null, "Table updated");
                }
            }
        });
        
        pnl.add(btnUpdate);
        
        btnShow = new JButton("Show");
        btnShow.setBounds(310, 360, 100, 35);
        pnl.add(btnShow);

    }

    private void showToTable(List<Mahasiswa> listMahasiswa) {
        Object[][] arrObj = new Object[listMahasiswa.size()][2];
        int i = 0;
        for (Mahasiswa mahasiswa : listMahasiswa) {
            arrObj[i][0] = mahasiswa.getNama();
            arrObj[i][1] = mahasiswa.getNim();
            i++;
        }

//        DefaultTableModel dtm = new DefaultTableModel(arrObj, title);
//        tblShow.setModel(dtm);
//        spTbl1.setViewportView(tblShow);
    }
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
