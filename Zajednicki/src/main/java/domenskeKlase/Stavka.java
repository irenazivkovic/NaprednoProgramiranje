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
 * Predstavlja stsvku narudzbenice koja je ugradjena u narudzbenicu. Stavka je
 * slab objekat od narudzbenice. Implementira klasu ApstraktniObjekat
 *
 * Ima atribute: narudzbenica, knjiga, redni broj, kolivinu, cenu po komadu i
 * pdv
 *
 * @author Irena
 */
public class Stavka extends ApstraktniObjekat implements Serializable {

    /**
     * Narudbenica kao objekat klase Narudzbenica
     */
    private Narudzbenica narudzbenica;
    /**
     * Knjiga kao objekat klase Knjiga
     */
    private Knjiga knjiga;
    /**
     * Redni broj stavke narudzbenice kao ceo broj
     */
    private int redniBroj;
    /**
     * Kolicina kao ceo broj
     */
    private int kolicina;
    /**
     * Cena stavke po komadu kao double
     */
    private double cenaKom;
    /**
     * PDV stavke kao double
     */
    private double PDV;

    /**
     * Bezparametarski konstruktor.
     */
    public Stavka() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za narudzbenicu,
     * knjigu, redni broj stavke, kolicinu, cenu po komadu i PDV.
     *
     * @param narudzbenica nova vrednost za objekat narudzbenice
     * @param knjiga nova vrednost za objekat knjige
     * @param redniBroj nova vrednost za redni broj stavke narudzbenice
     * @param kolicina nova vrednost za kolicinu stavke narudzbenice
     * @param cenaKom nova vrednost za cenu po komadu stavke narudzbenice
     * @param PDV nova vrednost za PDV stavke narudzbenice
     */
    public Stavka(Narudzbenica narudzbenica, Knjiga knjiga, int redniBroj, int kolicina, double cenaKom, double PDV) {
        this.narudzbenica = narudzbenica;
        this.knjiga = knjiga;
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.cenaKom = cenaKom;
        this.PDV = PDV;
    }

    @Override
    public String nazivTabele() {
        return "Stavka";
    }

    @Override
    public String alijas() {
        return "s";
    }

    @Override
    public String spajanje() {
        return "JOIN narudzbenica n on(n.narudzbenicaid=s.narudzbenicaid)"
                + "JOIN administrator a on(a.adminid=n.adminid)"
                + "JOIN kupac ku on(ku.kupacid=n.kupacid)"
                + "JOIN mesto m on(m.mestoid=ku.mestoid)"
                + "JOIN knjiga k on(k.knjigaid=s.knjigaid)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Administrator a = new Administrator(rs.getInt("AdminID"), rs.getString("Username"), rs.getString("Password"));
            Knjiga k = new Knjiga(rs.getInt("KnjigaID"), rs.getString("Naslov"), rs.getString("Pisac"), rs.getDouble("Cena"), rs.getInt("Stanje"));
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getInt("PTT"), rs.getString("Naziv"));
            Kupac ku = new Kupac(rs.getInt("KupacID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Adresa"), rs.getInt("Poeni"), m);
            Narudzbenica n = new Narudzbenica(rs.getInt("NarudzbenicaID"), rs.getTimestamp("Datum"), rs.getDouble("Popust"), rs.getDouble("UkupnaCena"), Status.valueOf(rs.getString("Status")), ku, null, a);
            Stavka s = new Stavka(n, k, rs.getInt("RedniBroj"), rs.getInt("Kolicina"), rs.getDouble("CenaKom"), rs.getDouble("PDV"));
            lista.add(s);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(NarudzbenicaID, RedniBroj, Kolicina,CenaKom,PDV, KnjigaID)";
    }

    @Override
    public String primarniKljuc() {
        return "NarudzbenicaID=" + narudzbenica.getNarudzbenicaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return narudzbenica.getNarudzbenicaID() + "," + redniBroj + "," + kolicina + "," + 0 + "," + PDV + "," + knjiga.getKnjigaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "NarudzbenicaID=" + narudzbenica.getNarudzbenicaID();
    }

    /**
     * Vraca objekat Narudzbenica
     *
     * @return narudzbenica kao objekat klase Narudzbenica
     */
    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    /**
     * Postavlja vrednost atributa narudzbenica.
     *
     * Narudzbenica ne sme biti null.
     *
     * @param narudzbenica nova vrednost za narudzbenicu
     *
     * @throws NullPointerException ako se unese null vrednost za narudzbenica
     */
    public void setNarudzbenica(Narudzbenica narudzbenica) {
        if (narudzbenica == null) {
            throw new NullPointerException("Narudzbenica ne sme biti null");
        }

        this.narudzbenica = narudzbenica;
    }

    /**
     * Vraca objekat knjiga
     *
     * @return knjiga kao objekat klase Knjiga
     */
    public Knjiga getKnjiga() {
        return knjiga;
    }

    /**
     * Postavlja vrednost atributa knjiga.
     *
     * Knjiga ne sme biti null.
     *
     * @param knjiga nova vrednost za knjigu
     *
     * @throws NullPointerException ako se unese null vrednost za knjigu
     */
    public void setKnjiga(Knjiga knjiga) {
        if (knjiga == null) {
            throw new NullPointerException("Knjiga ne sme biti null");
        }

        this.knjiga = knjiga;
    }

    /**
     * Vraca redni broj stavke narudzbenice
     *
     * @return redniBroj kao int
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Postavlja vrednost za redni broj stavke.
     *
     * Redni broj mora biti veci od nule.
     *
     * @param redniBroj redni broj stavke kao ceo broj
     * @throws IllegalArgumentException ako se unese redni broj koji je manji od 1
     * 1
     */
    public void setRedniBroj(int redniBroj) {
        if (redniBroj <= 0) {
            throw new IllegalArgumentException("Redni broj ne sme biti nula niti manji");
        }

        this.redniBroj = redniBroj;
    }

    /**
     * Vraca kolicinu stavke narudzbenice
     *
     * @return kolicina kao int
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * Postavlja vrednost za kolicinu stavke.
     *
     * Kolicina mora biti veca ili jednaka nulu.
     *
     * @param kolicina kolicina stavke kao ceo broj
     * @throws IllegalArgumentException ako se unese kolicina koja je manji od 0
     */
    public void setKolicina(int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException("Kolicina ne sme biti manja od nule");
        }

        this.kolicina = kolicina;
    }

    /**
     * Vraca cenu po komadu stavke narudzbenice
     *
     * @return cenaKom kao double
     */
    public double getCenaKom() {
        return cenaKom;
    }

    /**
     * Postavlja vrednost za cenu stavke po komadu.
     *
     * Cena mora biti veci od nule.
     *
     * @param cenaKom cena stavke kao double vrednost
     * @throws IllegalArgumentException ako se unese cenu koja je manji od 1
     */
    public void setCenaKom(double cenaKom) {
        if (cenaKom <= 0) {
            throw new IllegalArgumentException("Cena po komadu ne sme biti nula niti manji");
        }

        this.cenaKom = cenaKom;
    }

    /**
     * Vraca PDV stavke narudzbenice
     *
     * @return PDV kao double
     */
    public double getPDV() {
        return PDV;
    }

    /**
     * Postavlja vrednost za PDV stavke.
     *
     * PDV mora biti veci od nule.
     *
     * @param PDV PDV stavke kao double vrednost
     * @throws IllegalArgumentException ako se unese PDV koji je manji od 0
     */
    public void setPDV(double PDV) {
        if (PDV <= 0) {
            throw new IllegalArgumentException("PDV ne sme biti nula niti manji");
        }

        this.PDV = PDV;
    }

}
