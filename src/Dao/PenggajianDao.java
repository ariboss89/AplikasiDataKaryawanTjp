/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.DbConnection;
import Model.tb_penggajian;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PenggajianDao extends tb_penggajian{
    DbConnection con;
    Statement st;
    ResultSet res;
    String query;
    
    public void Save(String Id, String nik, String status, int gaji, int lembur, int totalgaji, String bulan, String tahun) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_penggajian(Id, nik, status, gaji, lembur, totalgaji, bulan, tahun)values('" + Id + "','" + nik + "','" + status + "','" + gaji + "','" + lembur+ "','" + totalgaji + "', '"+bulan+"', '"+tahun+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String Id, int lembur, int totalgaji, String bulan, String tahun) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_penggajian set lembur = '"+lembur+"', totalgaji = '"+totalgaji+"', bulan = '"+bulan+"', tahun = '"+tahun+"' where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(String Id) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_penggajian where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }
    
    public String[][] Show() {

        res = null;
        String[][] data = null;
        con = new DbConnection();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_penggajian";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_penggajian order by Id Asc";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][8];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nik");
                data[r][2] = res.getString("status");
                data[r][3] = res.getString("gaji");
                data[r][4] = res.getString("lembur");
                data[r][5] = res.getString("totalgaji");
                data[r][6] = res.getString("bulan");
                data[r][7] = res.getString("tahun");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 8; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
    public String[][] Search(String search) {

        res = null;
        String[][] data = null;
        con = new DbConnection();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_penggajian";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "SELECT *FROM tb_penggajian WHERE Id like '%"+search+"%' or nik like '%"+search+"%' or bulan like '%"+search+"%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][8];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nik");
                data[r][2] = res.getString("status");
                data[r][3] = res.getString("gaji");
                data[r][4] = res.getString("lembur");
                data[r][5] = res.getString("totalgaji");
                data[r][6] = res.getString("bulan");
                data[r][7] = res.getString("tahun");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 8; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
