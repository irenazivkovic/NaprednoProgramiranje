/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenskeKlase;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja apstraktni objekat za implementaciju odredjenih metoda, u kojoj
 * moze da se da naziv tabeli, odredi alijas, napise kod za soajanje, vrati
 * listu elemenata, vrate kolone za insert, vrati primarni kljuc i id, i da se
 * posalju vrednosti za update i insert
 *
 * @author PC
 */
public abstract class ApstraktniObjekat implements Serializable {

    /**
     * Vraca naziv tabele
     *
     * @return naziv tabele kao String
     */
    public abstract String nazivTabele();

    /**
     * Vraca alijas ya tu klasu koja implementira metodu Pseudonim olakšava
     * nalaženje i pretragu datoteka.
     *
     * @return skarceni naziv klase kao String
     */
    public abstract String alijas();

    /**
     * Definise nacin spajanja u SQL upitu Metoda moze da vraca ili prayan
     * String ili neki dodatni upit koji mora da se izvrsi da bi se iz baze
     * povukli odredjeni podaci
     *
     * @return SQL upit kao String
     */
    public abstract String spajanje();

    /**
     * Metoda vraca listu objekata iz baze podataka Prvo se inicijalizuje lista,
     * zatim se prolazi kroz bazu i na osnovu ulaznog parametara i trazi se
     * objekat. Nakon toga, objekat se dodaje u listu
     *
     * @param rs ResultSet parametar preko koga se pretrazuje objekat i dodaje u
     * listu
     * @return listu objekata
     * @throws SQLException ukoloko je pogresno napisan SQL upit
     */
    public abstract ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException;

    /**
     * Vraca kolone koje su za insert
     *
     * @return kolone kao String
     * @throws UnsupportedOperationException ukoliko nije izmenjena metoda
     */
    public abstract String koloneZaInsert();

    /**
     * Vraca primarni kljuc te klase
     *
     * @return primarni kljuc klase kao String
     * @throws UnsupportedOperationException ukoliko nije izmenjena metoda
     */
    public abstract String primarniKljuc();

    /**
     * Vraca String koji predstavlja vrednosti koje su neophodne za Insert
     *
     * @return String vrednosti
     * @throws UnsupportedOperationException ukoliko nije izmenjena metoda
     */
    public abstract String vrednostiZaInsert();

    /**
     * Vraca String koji predstavlja vrednosti koje su neophodne za Update
     *
     * @return String vrednosti
     * @throws UnsupportedOperationException ukoliko nije izmenjena metoda
     */
    public abstract String vrednostiZaUpdate();

    /**
     * Vraca id klase
     *
     * @return id klase kao String
     * @throws UnsupportedOperationException ukoliko nije izmenjena metoda
     */
    public abstract String id();

}
