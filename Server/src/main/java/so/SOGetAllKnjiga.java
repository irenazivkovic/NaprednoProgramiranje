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
 * Sistemska operacija koja vraca sve knjige
 *
 * @author Irena Zivkovic
 */
public class SOGetAllKnjiga extends ApstraktnaSO {

    /**
     * Lista elemenata klase Knjiga
     */
    private ArrayList<Knjiga> lista;

    /**
     * Metoda vraca listu svih knjiga
     *
     * @return lista elemenata klase Knjiga
     */
    public ArrayList<Knjiga> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Knjiga)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> knjige = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Knjiga>) (ArrayList<?>) knjige;
    }

}
