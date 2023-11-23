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
 *
 * @author Irena
 */
public class SOUpdateKnjiga extends ApstraktnaSO {

    private boolean uspesno = false;

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
