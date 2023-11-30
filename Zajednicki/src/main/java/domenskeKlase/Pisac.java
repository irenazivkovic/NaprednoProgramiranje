package domenskeKlase;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja pisca knjige
 *
 * Pisac ima sopsteveni Id, ime i prezime
 *
 * @author Irena
 */
public class Pisac extends ApstraktniObjekat implements Serializable{

	/**
	 * Id pisca kao int
	 */
	private int pisacID;
	/**
	 * Ime pisca kao String
	 */
	private String ime;
	/**
	 * Prezime pisca kao String
	 */
	private String prezime;
	
	/**
	 * Bez parametarski konstruktor
	 */
	public Pisac() {
	}

	/**
	 * Parametarski konstruktor koji postavlja atribute za id, ime i prezime
	 * 
	 * @param pisacID nova vrednost za id pisca
	 * @param ime nova vrednost za ime pisca
	 * @param prezime nova vrednost za preizme pisca
	 */
	public Pisac(int pisacID, String ime, String prezime) {
		super();
		this.pisacID = pisacID;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	@Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String nazivTabele() {
        return "Pisac";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {

        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Pisac p = new Pisac(rs.getInt("PisacID"), rs.getString("Ime"), rs.getString("Prezime"));
            lista.add(p);
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
	 * Vraca id pisca
	 * @return pisacID kao int
	 */
	public int getPisacID() {
		return pisacID;
	}

	/**
     * Postavlja vrednost za id pisca.
     *
     * Id mora biti veci od nule.
     *
     * @param pisacID id pisac kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
	public void setPisacID(int pisacID) {
		if (pisacID <= 0) {
            throw new IllegalArgumentException("ID pisca ne sme biti nula niti manji");
        }
		this.pisacID = pisacID;
	}

	/**
     * Vraca ime pisca
     *
     * @return ime kao String
     */
	public String getIme() {
		return ime;
	}

	/**
     * Postavlja vrednost atributa ime.
     *
     * Ime ne sme biti null niti prazan String.
     *
     * @param ime nova vrednost za ime pisca
     *
     * @throws NullPointerException ako se unese null vrednost za ime
     * @throws IllegalArgumentException ako se unese prazan String kao ime
     */
	public void setIme(String ime) {
		if (ime == null) {
            throw new NullPointerException("Ime ne sme biti null");
        }

        if (ime.isEmpty()) {
            throw new IllegalArgumentException("Ime ne sme biti prazno");
        }
        
		this.ime = ime;
	}

	/**
     * Vraca prezime pisca
     *
     * @return prezime kao String
     */
	public String getPrezime() {
		return prezime;
	}

	/**
     * Postavlja vrednost atributa prezime.
     *
     * Prezime ne sme biti null niti prazan String.
     *
     * @param prezime nova vrednost za prezime pisca
     *
     * @throws NullPointerException ako se unese null vrednost za prezime
     * @throws IllegalArgumentException ako se unese prazan String kao prezime
     */
	public void setPrezime(String prezime) {
		if (prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null");
        }

        if (prezime.isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazno");
        }
		this.prezime = prezime;
	}
	
	
}
