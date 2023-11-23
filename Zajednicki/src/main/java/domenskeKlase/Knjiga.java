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
public class Knjiga extends ApstraktniObjekat implements Serializable {

    private int knjigaID;
    private String naslov;
    private String pisac;
    private double cena;
    private int stanje;

    public Knjiga() {
    }

    public Knjiga(int knjigaID, String naslov, String pisac, double cena, int stanje) {
        this.knjigaID = knjigaID;
        this.naslov = naslov;
        this.pisac = pisac;
        this.cena = cena;
        this.stanje = stanje;
    }

    @Override
    public String toString() {
        return "[Naslov] " + naslov + " [Pisac] " + pisac;
    }

    @Override
    public String nazivTabele() {
        return "Knjiga";
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Knjiga k = new Knjiga(rs.getInt("KnjigaID"), rs.getString("Naslov"), rs.getString("Pisac"), rs.getDouble("Cena"), rs.getInt("Stanje"));
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(Naslov,Pisac,Cena,Stanje)";
    }

    @Override
    public String primarniKljuc() {
        return "KnjigaID=" + knjigaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naslov + "','" + pisac + "'," + cena + "," + stanje;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "Cena=" + cena + ", Stanje=" + stanje;
    }

    @Override
    public String id() {
        return "KnjigaID=" + knjigaID;
    }

    public int getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(int knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPisac() {
        return pisac;
    }

    public void setPisac(String pisac) {
        this.pisac = pisac;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

}
