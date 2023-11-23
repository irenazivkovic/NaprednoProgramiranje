/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenskeKlase;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Irena
 */
public class Narudzbenica extends ApstraktniObjekat implements Serializable {

    private int narudzbenicaID;
    private Date datum;
    private double popust;
    private double ukupnaCena;
    private Status status;
    private Kupac kupac;
    private ArrayList<Stavka> stavke;
    private Administrator administrator;

    public Narudzbenica() {
    }

    public Narudzbenica(int narudzbenicaID, Date datum, double popust, double ukupnaCena, Status status, Kupac kupac, ArrayList<Stavka> stavke, Administrator administrator) {
        this.narudzbenicaID = narudzbenicaID;
        this.datum = datum;
        this.popust = popust;
        this.ukupnaCena = ukupnaCena;
        this.status = status;
        this.kupac = kupac;
        this.stavke = stavke;
        this.administrator = administrator;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public String nazivTabele() {
        return "Narudzbenica";
    }

    @Override
    public String alijas() {
        return "n";
    }

    @Override
    public String spajanje() {
        return "JOIN kupac ku on(ku.kupacid=n.kupacid)"
                + "JOIN mesto m on(m.mestoid=ku.mestoid)"
                + "JOIN administrator a on(a.adminid=n.adminid)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Administrator a = new Administrator(rs.getInt("AdminID"), rs.getString("Username"), rs.getString("Password"));
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getInt("PTT"), rs.getString("Naziv"));
            Kupac k = new Kupac(rs.getInt("KupacID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Adresa"), rs.getInt("Poeni"), m);
            Narudzbenica n = new Narudzbenica(rs.getInt("NarudzbenicaID"), rs.getTimestamp("Datum"), rs.getDouble("Popust"), rs.getDouble("UkupnaCena"), Status.valueOf(rs.getString("Status")), k, null, a);
            lista.add(n);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(Datum,Popust,UkupnaCena,Status,KupacID,AdminID)";
    }

    @Override
    public String primarniKljuc() {
        return "NarudzbenicaID=" + narudzbenicaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Timestamp(datum.getTime()) + "'," + popust + "," + ukupnaCena + ",'" + status.toString() + "'," + kupac.getKupacID() + "," + administrator.getAdminID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "Status='" + status.toString() + "'";
    }

    @Override
    public String id() {
        return "NarudzbenicaID=" + narudzbenicaID;
    }

    public int getNarudzbenicaID() {
        return narudzbenicaID;
    }

    public void setNarudzbenicaID(int narudzbenicaID) {
        this.narudzbenicaID = narudzbenicaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public ArrayList<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<Stavka> stavke) {
        this.stavke = stavke;
    }

}
