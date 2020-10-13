/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Karyawan {
    private static String nik;
    private static String nama;
    private static String tempat;
    private static Date tggl_lahir;
    private static String jenis_kelamin;
    private static String alamat;
    private static String agama;
    private static String no_hp;
    private static String url;

    public static String getAgama() {
        return agama;
    }

    public static void setAgama(String agama) {
        Karyawan.agama = agama;
    }

    public static String getAlamat() {
        return alamat;
    }

    public static void setAlamat(String alamat) {
        Karyawan.alamat = alamat;
    }

    public static String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public static void setJenis_kelamin(String jenis_kelamin) {
        Karyawan.jenis_kelamin = jenis_kelamin;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Karyawan.nama = nama;
    }

    public static String getNik() {
        return nik;
    }

    public static void setNik(String nik) {
        Karyawan.nik = nik;
    }

    public static String getNo_hp() {
        return no_hp;
    }

    public static void setNo_hp(String no_hp) {
        Karyawan.no_hp = no_hp;
    }

    public static String getTempat() {
        return tempat;
    }

    public static void setTempat(String tempat) {
        Karyawan.tempat = tempat;
    }

    public static Date getTggl_lahir() {
        return tggl_lahir;
    }

    public static void setTggl_lahir(Date tggl_lahir) {
        Karyawan.tggl_lahir = tggl_lahir;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Karyawan.url = url;
    }
}
