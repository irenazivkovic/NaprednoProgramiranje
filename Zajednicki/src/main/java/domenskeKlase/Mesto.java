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
public class Mesto extends ApstraktniObjekat implements Serializable {

    private int mestoID;
    private int PTT;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int mestoID, int PTT, String naziv) {
        this.mestoID = mestoID;
        this.PTT = PTT;
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String nazivTabele() {
        return "Mesto";
    }

    @Override
    public String alijas() {
        return "m";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getInt("PTT"), rs.getString("Naziv"));
            lista.add(m);
        }
        rs.close();
        return lista;

    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "";
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public int getPTT() {
        return PTT;
    }

    public void setPTT(int PTT) {
        this.PTT = PTT;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
