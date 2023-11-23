/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Kupac;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Irena
 */
public class SOGetAllKupac extends ApstraktnaSO {

    private ArrayList<Kupac> lista;

    public ArrayList<Kupac> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if(!(ado instanceof Kupac)){
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> kupci=DBBroker.getInstance().selectBezUslova(ado);
        lista=(ArrayList<Kupac>)(ArrayList<?>) kupci;
    }

}
