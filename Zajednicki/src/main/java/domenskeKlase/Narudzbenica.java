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
 * Predstavlja narudzbenicu kada kupac zeli da kupi neku knjigu. Implementira
 * klasu ApstraktniObjekat
 *
 * Moze da ima id narudzbenice, datum, popust, ukupnu cenu, status, kupca,
 * stavke narudzbenice i administratora.
 *
 * @author Irena
 */
public class Narudzbenica extends ApstraktniObjekat implements Serializable {

    /**
     * Id narudzbenice kao int
     */
    private int narudzbenicaID;
    /**
     * Datum narucivanja knjiga
     */
    private Date datum;
    /**
     * Cena popust kao double
     */
    private double popust;
    /**
     * Ukupna cena kao double
     */
    private double ukupnaCena;
    /**
     * Status narudzbenice kao enum vrednost
     */
    private Status status;
    /**
     * Kupac kao objekat klase Kupac
     */
    private Kupac kupac;
    /**
     * Lista stavki narudzbenice.
     *
     * Lista moze biti i prazna ili null u slucajevima da nema stavki
     * narudzbenice
     *
     */
    private ArrayList<Stavka> stavke;
    /**
     * Administrator koji je ulogovan na sistem
     */
    private Administrator administrator;

    /**
     * Bezparametarski konstruktor
     */
    public Narudzbenica() {
    }

    /**
     * Parametarski konstruktor koji postavlja novu vrednost za id narudzbenice,
     * datum, popust, ukupnu cenu, status, kupca, stavke narudzbenice i
     * administratora.
     *
     * @param narudzbenicaID nova vrednost za id narudzbenice
     * @param datum nova vrednost za datum
     * @param popust nova vrednost za popust
     * @param ukupnaCena nova vrednost za ukupnu cenu
     * @param status nova vrednost za status
     * @param kupac nova vrednost za kupca
     * @param stavke nova vrednost za stavke narudzbenice
     * @param administrator nova vrednost za administratora
     */
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

    /**
     * Vraca ulogovanig administratora
     *
     * @return administrator kao objekat klase Administrator
     */
    public Administrator getAdministrator() {
        return administrator;
    }

    /**
     * Postavlja vrednost atributa administrator.
     *
     * Administrator ne sme biti null.
     *
     * @param administrator nova vrednost za administratora
     *
     * @throws NullPointerException ako se unese null vrednost za administrator
     */
    public void setAdministrator(Administrator administrator) {
        if (administrator == null) {
            throw new NullPointerException("Administrator ne sme biti null");
        }

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
            Adresa adress = new Adresa(rs.getInt("AdresaID"), rs.getString("Naziv"));
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getInt("PTT"), rs.getString("Naziv"), adress);
            Kupac k = new Kupac(rs.getInt("KupacID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getInt("Poeni"), m);
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

    /**
     * Vraca id narudzbenice
     *
     * @return narudzbenicaID kao int
     */
    public int getNarudzbenicaID() {
        return narudzbenicaID;
    }

    /**
     * Postavlja vrednost za id narudzbenice.
     *
     * Id mora biti veci od nule.
     *
     * @param narudzbenicaID id narudzbenice kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setNarudzbenicaID(int narudzbenicaID) {
        if (narudzbenicaID <= 0) {
            throw new IllegalArgumentException("ID narudzbenice ne sme biti nula niti manji");
        }

        this.narudzbenicaID = narudzbenicaID;
    }

    /**
     * Vraca datum
     *
     * @return datum kao Date
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja vrednost atributa datum.
     *
     * Datum ne sme biti null.
     *
     * @param datum nova vrednost za datum
     *
     * @throws NullPointerException ako se unese null vrednost za datum
     */
    public void setDatum(Date datum) {
        if (datum == null) {
            throw new NullPointerException("Datum ne sme biti null");
        }

        this.datum = datum;
    }

    /**
     * Vraca popust
     *
     * @return popust kao double
     */
    public double getPopust() {
        return popust;
    }

    /**
     * Postavlja vrednost za popust.
     *
     * Popust mora biti veci ili jednak nuli.
     *
     * @param popust popust kao double
     * @throws IllegalArgumentException ako se unese popust koji je manji od 0
     */
    public void setPopust(double popust) {
        if (popust < 0) {
            throw new IllegalArgumentException("Popust ne sme biti manji od nula");
        }

        this.popust = popust;
    }

    /**
     * Vraca ukupna cena
     *
     * @return ukupnaCena kao double
     */
    public double getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * Postavlja vrednost za ukupnu cenu.
     *
     * Ukupna cena mora biti veca od nule.
     *
     * @param ukupnaCena ukupna cena kao double
     * @throws IllegalArgumentException ako se unese cenu koja je manja od 1
     */
    public void setUkupnaCena(double ukupnaCena) {
        if (ukupnaCena <= 0) {
            throw new IllegalArgumentException("Ukupna cena ne sme biti nula niti manji");
        }

        this.ukupnaCena = ukupnaCena;
    }

    /**
     * Vraca status narudzbenice
     *
     * @return status kao enum onjekat Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Postavlja vrednost atributa status.
     *
     * Status ne sme biti null.
     *
     * @param status nova vrednost za status narudzbenice
     *
     * @throws NullPointerException ako se unese null vrednost za status
     */
    public void setStatus(Status status) {
        if (status == null) {
            throw new NullPointerException("Status ne sme biti null");
        }

        this.status = status;
    }

    /**
     * Vraca kupca
     *
     * @return kupac kao objekat klase Kupac
     */
    public Kupac getKupac() {
        return kupac;
    }

    /**
     * Postavlja vrednost atributa kupac.
     *
     * Kupac ne sme biti null.
     *
     * @param kupac nova vrednost za kupca
     *
     * @throws NullPointerException ako se unese null vrednost za kupca
     */
    public void setKupac(Kupac kupac) {
        if (kupac == null) {
            throw new NullPointerException("Kupac ne sme biti null");
        }

        this.kupac = kupac;
    }

    /**
     * Vraca listu stavki narudzbenice
     *
     * @return stavke Listu sa stavkamanarudzbenice, ili null ako narudzbenica
     * nema stavke.
     */
    public ArrayList<Stavka> getStavke() {
        return stavke;
    }

    /**
     * Postavlja listu sa stavkama narudzbenice.
     *
     * Lista sme biti null ili prazna ako narudzbenica nema stavke.
     *
     * @param stavke lista sa stavkama narudzbenice.
     */
    public void setStavke(ArrayList<Stavka> stavke) {
        this.stavke = stavke;
    }

}
