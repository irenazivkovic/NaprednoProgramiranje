/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Narudzbenica;
import java.sql.SQLException;

/**
 * Sistemska operacija koja vrsi izmenu narudzbenice
 *
 * @author Irena Zivkovic
 */
public class SOUpdateNarudzbenica extends ApstraktnaSO {

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
        if (!(ado instanceof Narudzbenica)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        DBBroker.getInstance().update(ado);
        uspesno = true;
    }

}
