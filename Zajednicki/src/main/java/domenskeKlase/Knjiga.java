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
 * Predstavlja elektronsku ili stampanu knjigu. Implementira klasu
 * ApstraktniObjekat
 *
 * Moze imati id, naslov, pisca, cenu i stanje.
 *
 * @author Irena
 */
public class Knjiga extends ApstraktniObjekat implements Serializable {

    /**
     * Id knjige kao int
     */
    private int knjigaID;
    /**
     * Naslov knjige kao String
     */
    private String naslov;
    /**
     * Pisac knjige kao String
     */
    private String pisac;
    /**
     * Cena knjige kao double
     */
    private double cena;
    /**
     * Pokazuje koliko knjiga ima na stanju.
     */
    private int stanje;

    /**
     * Bezparametarski konstruktor.
     */
    public Knjiga() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za id, username i
     * password.
     *
     * @param knjigaID nova vrednost za id knjige
     * @param naslov nova vrednost za naslov knjige
     * @param pisac nova vrednost za pisca knjige
     * @param cena nova vrednost za cenu knjige
     * @param stanje nova vrednost za broj knjiga na stanju
     */
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

    /**
     * Vraca id knjige
     *
     * @return knjigaID kao int
     */
    public int getKnjigaID() {
        return knjigaID;
    }

    /**
     * Postavlja vrednost za id knjige.
     *
     * Id mora biti veci od nule.
     *
     * @param knjigaID id knjige kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setKnjigaID(int knjigaID) {
        if (knjigaID <= 0) {
            throw new IllegalArgumentException("ID knjige ne sme biti nula niti manji");
        }

        this.knjigaID = knjigaID;
    }

    /**
     * Vraca naslov knjige
     *
     * @return naslov kao String
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Postavlja vrednost atributa naslov.
     *
     * Naslov ne sme biti null niti prazan String.
     *
     * @param naslov nova vrednost za naslov knjige
     *
     * @throws NullPointerException ako se unese null vrednost za naslov
     * @throws IllegalArgumentException ako se unese prazan String kao naslov
     */
    public void setNaslov(String naslov) {
        if (naslov == null) {
            throw new NullPointerException("Naslov ne sme biti null");
        }

        if (naslov.isEmpty()) {
            throw new IllegalArgumentException("Naslov ne sme biti prazan");
        }

        this.naslov = naslov;
    }

    /**
     * Vraca pisca knjige
     *
     * @return pisac kao String
     */
    public String getPisac() {
        return pisac;
    }

    /**
     * Postavlja vrednost atributa pisac.
     *
     * Pisac ne sme biti null niti prazan String.
     *
     * @param pisac nova vrednost za naslov knjige
     *
     * @throws NullPointerException ako se unese null vrednost za pisac
     * @throws IllegalArgumentException ako se unese prazan String kao pisac
     */
    public void setPisac(String pisac) {
        if (pisac == null) {
            throw new NullPointerException("Pisac ne sme biti null");
        }

        if (pisac.isEmpty()) {
            throw new IllegalArgumentException("Pisac ne sme biti prazan");
        }

        this.pisac = pisac;
    }

    /**
     * Vraca cenu knjige
     *
     * @return cena kao double
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja vrednost za cenu knjige.
     *
     * Cena mora biti veca od nule.
     *
     * @param cena id administratira kao double
     * @throws IllegalArgumentException ako se unese cena koji je manji od 1
     */
    public void setCena(double cena) {
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena knjiga ne sme biti manji ili jednak nuli");
        }

        this.cena = cena;
    }

    /**
     * Vraca broj knjiga koji je na stanju
     *
     * @return stanje kao int
     */
    public int getStanje() {
        return stanje;
    }

    /**
     * Postavlja vrednost za broj knjiga na stanju.
     *
     * Stanje mora biti veci ili jednak nuli.
     *
     * @param stanje stanje knjiga kao ceo broj
     * @throws IllegalArgumentException ako se unese stanje koje je manji od 0
     */
    public void setStanje(int stanje) {
        if (stanje < 0) {
            throw new IllegalArgumentException("Stanje knjiga ne sme biti manji od nula");
        }

        this.stanje = stanje;
    }

}
