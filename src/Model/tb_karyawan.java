/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.DbConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class tb_karyawan {
    private String nik;
    private String nama;
    private String tempat;
    private Date tggl_lahir;
    private String jenis_kelamin;
    private String alamat;
    private String agama;
    private String no_hp;
    private String img;
    private DbConnection con;
    private Statement st;
    private ResultSet res;
    private String query;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public Date getTggl_lahir() {
        return tggl_lahir;
    }

    public void setTggl_lahir(Date tggl_lahir) {
        this.tggl_lahir = tggl_lahir;
    }
    
    public void Save(String nik, String nama, String tempat, Date tggl, String jenis_kelamin, String alamat, String agama, String no_hp, String img) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_karyawan(nik, nama, tempat, tggl_lahir, jenis_kelamin, alamat, agama, no_hp, img)values('" + nik + "','" + nama + "','" + tempat + "','" + tggl+ "','" + jenis_kelamin + "','" + alamat + "','" + agama + "','" + no_hp + "','" + img + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String nik, String nama, String tempat, Date tggl, String jenis_kelamin, String alamat, String agama, String no_hp, String img) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_karyawan set nama = '"+nama+"', tempat = '"+tempat+"', tggl_lahir = '"+tggl+"', jenis_kelamin = '"+jenis_kelamin+"', alamat = '"+alamat+"', agama = '"+agama+"', no_hp = '"+no_hp+"', img = '"+img+"' where nik = '" + nik + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(String username) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_login where username = '" + username + "'";
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
            query = "SELECT COUNT(nik) AS Jumlah FROM tb_karyawan";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_karyawan order by nik Asc";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][9];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("nik");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("tempat");
                data[r][3] = res.getString("tggl_lahir");
                data[r][4] = res.getString("jenis_kelamin");
                data[r][5] = res.getString("alamat");
                data[r][6] = res.getString("agama");
                data[r][7] = res.getString("no_hp");
                data[r][8] = res.getString("img");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][9];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 9; c++) {
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
            query = "SELECT COUNT(username) AS Jumlah FROM tb_login";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_login where username like '%"+ search +"%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][1];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("username");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][1];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 1; c++) {
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
