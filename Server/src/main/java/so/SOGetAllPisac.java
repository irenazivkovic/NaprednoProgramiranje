/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Pisac;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Sistemska operacija koja vraca sve pisce
 *
 * @author Irena Zivkovic
 */
public class SOGetAllPisac extends ApstraktnaSO {

    /**
     * Lista elemenata klase Pisac
     */
    private ArrayList<Pisac> lista;

    /**
     * Metoda vraca listu svih pisaca
     *
     * @return lista elemenata klase Knjiga
     */
    public ArrayList<Pisac> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Pisac)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> pisci = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Pisac>) (ArrayList<?>) pisci;
    }

}
