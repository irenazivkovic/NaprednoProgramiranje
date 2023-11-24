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
 * Predstavlja mesto prebivalista kupca Implementira klasu ApstraktniObjekat
 *
 * Mesto ima svoj id, ptt i naziv.
 *
 * @author Irena
 */
public class Mesto extends ApstraktniObjekat implements Serializable {

    /**
     * Id mesta kao ceo broj
     */
    private int mestoID;
    /**
     * Postanski broj mesta kao ceo broj
     */
    private int PTT;
    /**
     * Naziv mesta kao String vrednost
     */
    private String naziv;

    /**
     * Bezparametarski konstruktor
     */
    public Mesto() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za id, ptt i naziv.
     *
     * @param mestoID nova vrednost za id mesta
     * @param PTT nova vrednost za ptt mesta
     * @param naziv nova vrednost za naziv mesta
     */
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

    /**
     * Vraca id mesta
     *
     * @return mestoID kao int
     */
    public int getMestoID() {
        return mestoID;
    }

    /**
     * Postavlja vrednost za id mesta.
     *
     * Id mora biti veci od nule.
     *
     * @param mestoID id mesta kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setMestoID(int mestoID) {
        if (mestoID <= 0) {
            throw new IllegalArgumentException("ID mesta ne sme biti nula niti manji");
        }

        this.mestoID = mestoID;
    }

    /**
     * Vraca ptt mesta
     *
     * @return PTT kao int
     */
    public int getPTT() {
        return PTT;
    }

    /**
     * Postavlja vrednost za ptt.
     *
     * PTT mora biti veci od nule.
     *
     * @param PTT ptt knjige kao ceo broj
     * @throws IllegalArgumentException ako se unese ptt koji je manji od 1
     */
    public void setPTT(int PTT) {
        if (PTT <= 0) {
            throw new IllegalArgumentException("PTT mesta ne sme biti nula niti manji");
        }

        this.PTT = PTT;
    }

    /**
     * Vraca naziv mesta
     *
     * @return naziv kao String
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost atributa naziv.
     *
     * Naziv ne sme biti null niti prazan String.
     *
     * @param naziv nova vrednost za naziv mesta
     *
     * @throws NullPointerException ako se unese null vrednost za naziv
     * @throws IllegalArgumentException ako se unese prazan String kao naziv
     */
    public void setNaziv(String naziv) {
        if (naziv == null) {
            throw new NullPointerException("Naziv ne sme biti null");
        }

        if (naziv.isEmpty()) {
            throw new IllegalArgumentException("Naziv ne sme biti prazan");
        }

        this.naziv = naziv;
    }

}
