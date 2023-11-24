/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenskeKlase;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja administratora koji se loguje na sistem Implementira klasu
 * ApstraktniObjekat
 *
 * Administrator ima sopsteveni Id, username i password
 *
 * @author Irena
 */
public class Administrator extends ApstraktniObjekat implements Serializable {

    /**
     * Id audministratora kao int
     */
    private int adminID;
    /**
     * Username audministratora kao Sting
     */
    private String username;
    /**
     * Password audministratora kao String
     */
    private String password;

    /**
     * Bezparametarski konstruktor
     */
    public Administrator() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za id, username i
     * password.
     *
     * @param adminID nova vrednost za id administratora
     * @param username nova vrednost za username administratora
     * @param password nova vrednost za password administratora
     */
    public Administrator(int adminID, String username, String password) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public String nazivTabele() {
        return "Administrator";
    }

    @Override
    public String alijas() {
        return "a";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Administrator a = new Administrator(rs.getInt("AdminID"), rs.getString("Username"), rs.getString("Password"));
            lista.add(a);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String primarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraca id administratora
     *
     * @return adminID kao int
     */
    public int getAdminID() {
        return adminID;
    }

    /**
     * Postavlja vrednost za id administratora.
     *
     * Id mora biti veci od nule.
     *
     * @param adminID id administratira kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setAdminID(int adminID) {
        if (adminID <= 0) {
            throw new IllegalArgumentException("ID admina ne sme biti nula niti manji");
        }

        this.adminID = adminID;
    }

    /**
     * Vraca username administratora
     *
     * @return username kao String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja vrednost atributa username.
     *
     * Username ne sme biti null niti prazan String.
     *
     * @param username nova vrednost za username administratora
     *
     * @throws NullPointerException ako se unese null vrednost za username
     * @throws IllegalArgumentException ako se unese prazan String kao username
     */
    public void setUsername(String username) {
        if (username == null) {
            throw new NullPointerException("Username ne sme biti null");
        }

        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username ne sme biti prazno");
        }

        this.username = username;
    }

    /**
     * Vraca password administratora
     *
     * @return password kao String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja vrednost atributa password.
     *
     * Password ne sme biti null niti prazan String.
     *
     * @param password nova vrednost za password administratora
     *
     * @throws NullPointerException ako se unese null vrednost za password
     * @throws IllegalArgumentException ako se unese prazan String kao password
     */
    public void setPassword(String password) {
        if (password == null) {
            throw new NullPointerException("Password ne sme biti null");
        }

        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password ne sme biti prazno");
        }

        this.password = password;
    }

}
