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
 * Sistemska operacija koja vrsi izmenu knjiga
 *
 * @author Irena Zivkovic
 */
public class SOUpdateKnjiga extends ApstraktnaSO {

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

        if (k.getCena() <= 0) {
            throw new Exception("Cena ne moze biti manja od 0!");
        }

    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        DBBroker.getInstance().update(ado);
        uspesno = true;
    }

}
