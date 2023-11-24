/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Mesto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Sistemska operacija koja vraca sva mesta
 *
 * @author Irena Zivkovic
 */
public class SOGetAllMesto extends ApstraktnaSO {

    /**
     * Lista elemenata klase Mesto
     */
    private ArrayList<Mesto> lista;

    /**
     * Metoda vraca listu svih mesta
     *
     * @return lista elemenata klase Mesto
     */
    public ArrayList<Mesto> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Mesto)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> mesta = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Mesto>) (ArrayList<?>) mesta;
    }

}
