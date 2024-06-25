package databaseeex;

import java.sql.*;
import java.util.*;

public class DataAkses {

    public static List<Mahasiswa> showMahasiswa() {
        List<Mahasiswa> listMahasiswa = new ArrayList<>();

        String query = "SELECT * FROM tbl_mhs";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection().
                                                    prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setNama(rs.getString("nama"));
                m.setNim(rs.getString("nim"));
                listMahasiswa.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listMahasiswa;
    }

    public static void addMahasiswa(Mahasiswa mhs) {
        String query = "INSERT INTO tbl_mhs(nama, nim) VALUES (?, ?)";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareCall(query);
            st.setString(1, mhs.getNama());
            st.setString(2, mhs.getNim());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delMahasiswa(String nim) {
        String query = "delete from tbl_mhs WHERE nim =?";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareCall(query);
            st.setString(1, nim);
            System.out.println(st);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Mahasiswa searchMahasiswa(String nim){
        Mahasiswa m = null;
        
        String query = "SELECT * FROM tbl_mhs WHERE nim = ?";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareCall(query);
            st.setString(1, nim);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                m = new Mahasiswa();
                m.setNama(rs.getString("nama"));
                m.setNim(rs.getString("nim"));
                break;
            }
       
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    
    public static void updateMahasiswa(Mahasiswa m){
           String query = "update tbl_mhs set nama = ?, nim =? WHERE nim = ?";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareCall(query);
            st.setString(1, m.getNama());
            st.setString(2, m.getNim());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
            
}
