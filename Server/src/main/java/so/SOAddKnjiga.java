/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Sistemska operacija koja dodaje knjigu
 *
 * @author Irena Zivkovic
 */
public class SOAddKnjiga extends ApstraktnaSO {

    /**
     * boolean vrednost za uspesno koji je postavljen na pocetku na false
     */
    private boolean uspesno = false;

    /**
     * Metoda pokazuje da li operacija uspesna.
     *
     * @return true ako je uspesna operacija, ili false ukoliko nije
     */
    public boolean isUspesno() {
        return uspesno;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Knjiga)) {
            throw new Exception("Nevalidan objekat!");
        }
        Knjiga k = (Knjiga) ado;

        if (k.getCena() <= 0 || k.getStanje() <= 0) {
            throw new Exception("Cena i stanje ne mogu biti 0 ili manji od 0. Unesite validan broj!");
        }
        ArrayList<ApstraktniObjekat> knjige = DBBroker.getInstance().selectBezUslova(ado);
        ArrayList<Knjiga> lista = (ArrayList<Knjiga>) (ArrayList<?>) knjige;

        for (Knjiga knjiga : lista) {
            if (knjiga.getPisac().equals(k.getPisac()) && knjiga.getNaslov().equals(k.getNaslov())) {
                throw new Exception("Knjiga sa ovim piscem vec postoji u bazi!");
            }
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
        uspesno = true;
    }

}
