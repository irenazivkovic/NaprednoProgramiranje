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
 *
 * @author Irena
 */
public class SOGetAllNarudzbenica extends ApstraktnaSO {

    private ArrayList<Narudzbenica> lista;

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
