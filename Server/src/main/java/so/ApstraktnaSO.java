/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import java.sql.SQLException;

/**
 * Apstraktna sistemska operacija koju sve konkretne sistemske operacije
 * nasledjuju.
 *
 * @author Irena Zivkovic
 */
public abstract class ApstraktnaSO {

    /**
     * Metoda u kojoj se radi validacija, ubacivanje i potvrdjivanje, odnosno
     * ponistavanje objekta
     *
     * @param ado apstraktni objekat koji se koristi
     * @throws Exception Ukoliko dodje do greske
     */
    public void templateExecute(ApstraktniObjekat ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    /**
     * Metoda za validiranje objekta.
     *
     * @param ado objekat koji treba da se validira
     * @throws Exception ukoliko nije validan objekat ili nisu zadovoljeni
     * uslovi
     */
    protected abstract void validate(ApstraktniObjekat ado) throws Exception;

    /**
     * Metoda za ubacivanje objekta
     *
     * @param ado apstraktni objekat koji se ubacuje
     * @throws SQLException Ukoliko je nevalidan sql upit
     */
    protected abstract void execute(ApstraktniObjekat ado) throws SQLException;

    /**
     * Metoda za potvrdjivanje da je uspesno dodat objekat
     *
     * @throws SQLException Ukoliko je nevalidan sql upit
     */
    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    /**
     * Potvrdjivanje da nije uspesno dodat objekat
     *
     * @throws SQLException Ukoliko je nevalidan sql upit
     */
    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
