/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Narudzbenica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Sistemska operacija koja vraca sve narudzbenice
 *
 * @author Irena Zivkovic
 */
public class SOGetAllNarudzbenica extends ApstraktnaSO {

    /**
     * Lista elemenata klase Narudzbenica
     */
    private ArrayList<Narudzbenica> lista;

    /**
     * Metoda vraca listu svih narudzbenica
     *
     * @return lista elemenata klase Narudzbenica
     */
    public ArrayList<Narudzbenica> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Narudzbenica)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> naru = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Narudzbenica>) (ArrayList<?>) naru;
    }

}
