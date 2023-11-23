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
 *
 * @author Irena
 */
public class Administrator extends ApstraktniObjekat implements Serializable {

    private int adminID;
    private String username;
    private String password;

    public Administrator() {
    }

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

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
