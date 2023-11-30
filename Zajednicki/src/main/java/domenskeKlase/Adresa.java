package domenskeKlase;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja adresu mesta koja Implementira klasu ApstraktniObjekat
 *
 * Adresa ima sopsteveni Id i naziv
 *
 * @author Irena
 */
public class Adresa extends ApstraktniObjekat implements Serializable {

    /**
     * ID adrese kao int
     */
    private int adresaID;
    /**
     * Naziv adrese koan String
     */
    private String naziv;

    /**
     * Bezparametarski konstruktor
     */
    public Adresa() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Parametarski konstruktor koji postavlja nove vrednosti za id i naziv
     * adrese
     *
     * @param adresaID nova vrednost za id adrese
     * @param naziv nova vrednost za naziv adrese
     */
    public Adresa(int adresaID, String naziv) {
        this.adresaID = adresaID;
        this.naziv = naziv;
    }

    @Override
    public String nazivTabele() {
        return "Adresa";
    }

    @Override
    public String alijas() {
        return "adress";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Adresa a = new Adresa(rs.getInt( rs.getInt("AdresaID")), rs.getString("Naziv"));
            lista.add(a);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String primarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraca id adrese
     *
     * @return adresaID kao int
     */
    public int getAdresaID() {
        return adresaID;
    }

    /**
     * Postavlja vrednost za id adrese.
     *
     * Id mora biti veci od nule.
     *
     * @param adresaID id adrese kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setAdresaID(int adresaID) {
        if (adresaID <= 0) {
            throw new IllegalArgumentException("ID adrese ne sme biti nula niti manji");
        }
        this.adresaID = adresaID;
    }

    /**
     * Vraca naziv adrese
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
     * @param naziv nova vrednost za naziv administratora
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

    @Override
    public String toString() {
        return naziv;
    }

    
}
