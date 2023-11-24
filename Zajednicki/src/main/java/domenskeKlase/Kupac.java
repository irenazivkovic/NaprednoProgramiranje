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
 * Predstavlja profil kupca. Implementira klasu ApstraktniObjekat
 *
 * Kupac ima svoj id, ime, prezime, adresu, poene i mesto.
 *
 * @author Irena
 */
public class Kupac extends ApstraktniObjekat implements Serializable {

    /**
     * Id kupca kao ceo broj.
     */
    private int kupacID;
    /**
     * Ime autora kao String
     */
    private String ime;
    /**
     * Prezime autora kao String
     */
    private String prezime;
    /**
     * Adresa autora kao String
     */
    private String adresa;
    /**
     * Broj poena koje je kupac sakupio.
     */
    private int poeni;
    /**
     * Mesto stanovanja kupca.
     */
    private Mesto mesto;

    /**
     * Bezparametarski konstruktor.
     */
    public Kupac() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za id, ime, prezime,
     * adtresu, poene i mesto.
     *
     * @param kupacID nova vrednost za id kupca
     * @param ime nova vrednost za ime kupca
     * @param prezime nova vrednost za prezime kupca
     * @param adresa nova vrednost za adresu kupca
     * @param poeni nova vrednost za poene koje je kupac osvojio
     * @param mesto nova vrednost za mesto gde kupac zivi
     */
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

    /**
     * Vraca id kupca
     *
     * @return kupacID kao int
     */
    public int getKupacID() {
        return kupacID;
    }

    /**
     * Postavlja vrednost za id kupca.
     *
     * Id mora biti veci od nule.
     *
     * @param kupacID id kupca kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setKupacID(int kupacID) {
        if (kupacID <= 0) {
            throw new IllegalArgumentException("ID kupca ne sme biti nula niti manji");
        }

        this.kupacID = kupacID;
    }

    /**
     * Vraca ime kupca
     *
     * @return ime kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost atributa ime.
     *
     * Ime ne sme biti null vrednost, niti prazan String.
     *
     * @param ime nova vrednost za ime kupca
     *
     * @throws NullPointerException ako se unese null vrednost za ime
     * @throws IllegalArgumentException ako se unese prazan String kao ime
     */
    public void setIme(String ime) {
        if (ime == null) {
            throw new NullPointerException("Ime ne sme biti null");
        }

        if (ime.isEmpty()) {
            throw new IllegalArgumentException("Ime ne sme biti prazan");
        }

        this.ime = ime;
    }

    /**
     * Vraca prezime kupca
     *
     * @return prezime kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost atributa prezime.
     *
     * Prezime ne sme biti null vrednost, niti prazan String.
     *
     * @param prezime nova vrednost za prezime kupca
     *
     * @throws NullPointerException ako se unese null vrednost za prezime
     * @throws IllegalArgumentException ako se unese prazan String kao prezime
     */
    public void setPrezime(String prezime) {
        if (prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null");
        }

        if (prezime.isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazan");
        }

        this.prezime = prezime;
    }

    /**
     * Vraca adresu kupca
     *
     * @return adresa kao String
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Postavlja vrednost atributa adresa.
     *
     * Adresa ne sme biti null vrednost, niti prazan String.
     *
     * @param adresa nova vrednost za adresu
     *
     * @throws NullPointerException ako se unese null vrednost za adresa
     * @throws IllegalArgumentException ako se unese prazan String kao adresa
     */
    public void setAdresa(String adresa) {
        if (adresa == null) {
            throw new NullPointerException("Adresa ne sme biti null");
        }

        if (adresa.isEmpty()) {
            throw new IllegalArgumentException("Adresa ne sme biti prazan");
        }

        this.adresa = adresa;
    }

    /**
     * Vraca poene koje je kupac ostvario
     *
     * @return poeni kao int
     */
    public int getPoeni() {
        return poeni;
    }

    /**
     * Postavlja vrednost za poene.
     *
     * Poeni moraju biti veci ili jednaki nuli.
     *
     * @param poeni poeni kupca kao ceo broj
     * @throws IllegalArgumentException ako se unese poene koji je manji od 0
     */
    public void setPoeni(int poeni) {
        if (poeni < 0) {
            throw new IllegalArgumentException("Poeni ne smeju biti nula niti manji");
        }

        this.poeni = poeni;
    }

    /**
     * Vraca mesto gde kupac zivi
     *
     * @return mesto kao objekat klase Mesto
     */
    public Mesto getMesto() {
        return mesto;
    }

    /**
     * Postavlja vrednost atributa mesto.
     *
     * Masto ne sme biti null.
     *
     * @param mesto nova vrednost za mesto stanovanja
     *
     * @throws NullPointerException ako se unese null vrednost za mesto
     */
    public void setMesto(Mesto mesto) {
        if (mesto == null) {
            throw new NullPointerException("Mesto ne sme biti null");
        }

        this.mesto = mesto;
    }

}
