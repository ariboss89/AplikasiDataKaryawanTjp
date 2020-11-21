/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.DbConnection;
import View.FormUtama;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class tb_login {
    public static String username;
    private String password;
    private String konfirmasi;
    private DbConnection con;
    private Statement st;
    private ResultSet res;
    private String query;
    public static String role;

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        tb_login.role = role;
    }

    public String getKonfirmasi() {
        return konfirmasi;
    }

    public void setKonfirmasi(String konfirmasi) {
        this.konfirmasi = konfirmasi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        tb_login.username = username;
    }
    
    public void Login(String username, String password) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_login where username ='" + username + "' And password = '" + password + "'");
            if (res.next()) {
                JOptionPane.showMessageDialog(null, "Welcome " + username);
                new FormUtama().setVisible(true);
            } 
            else{
                JOptionPane.showMessageDialog(null, "Username or Password is Wrong");
            }
        } catch (SQLException e) {

        }
    }

    public void CekUsername(String username){
        con = new DbConnection();
        con.connect();        
        try{
            Statement st = con.conn.createStatement();
            res = st.executeQuery("select *from tb_login where username = '"+username+"'"); 
            if(res.next()){
                JOptionPane.showMessageDialog(null, "Username Already Exist !!");
            }
            
        }catch(SQLException ex){
            
        }
    }
    
    public void Save(String username, String password) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_login(username, password)values('" + username + "','" + password + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String username, String password) {
        con = new DbConnection();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_login set password = '"+password+"' where username = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Password Berhasil di Ganti !!");
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
            query = "SELECT COUNT(username) AS Jumlah FROM tb_login";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_login order by username Asc";
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
