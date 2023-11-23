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
public class Stavka extends ApstraktniObjekat implements Serializable {

    private Narudzbenica narudzbenica;
    private Knjiga knjiga;
    private int redniBroj;
    private int kolicina;
    private double cenaKom;
    private double PDV;

    public Stavka() {
    }

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

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCenaKom() {
        return cenaKom;
    }

    public void setCenaKom(double cenaKom) {
        this.cenaKom = cenaKom;
    }

    public double getPDV() {
        return PDV;
    }

    public void setPDV(double PDV) {
        this.PDV = PDV;
    }

}
