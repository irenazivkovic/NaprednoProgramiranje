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
public class Kupac extends ApstraktniObjekat implements Serializable {

    private int kupacID;
    private String ime;
    private String prezime;
    private String adresa;
    private int poeni;
    private Mesto mesto;

    public Kupac() {
    }

    public Kupac(int kupacID, String ime, String prezime, String adresa, int poeni, Mesto mesto) {
        this.kupacID = kupacID;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.poeni = poeni;
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return "Kupac";
    }

    @Override
    public String alijas() {
        return "ku";
    }

    @Override
    public String spajanje() {
        return "JOIN mesto m on(m.mestoid=ku.mestoid)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getInt("PTT"), rs.getString("Naziv"));
            Kupac k = new Kupac(rs.getInt("KupacID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Adresa"), rs.getInt("Poeni"), m);
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(Ime,Prezime,Adresa,Poeni,MestoID)";
    }

    @Override
    public String primarniKljuc() {
        return "KupacID=" + kupacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "','" + prezime + "','" + adresa + "'," + poeni + "," + mesto.getMestoID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "Adresa='" + adresa + "',Poeni=" + poeni + ",MestoID=" + mesto.getMestoID();
    }

    @Override
    public String id() {
        return "KupacID=" + kupacID;
    }

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

}
