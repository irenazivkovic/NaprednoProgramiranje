/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.Administrator;
import domenskeKlase.ApstraktniObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Irena
 */
public class SOLogin extends ApstraktnaSO {

    private Administrator a;

    public Administrator getA() {
        return a;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        Administrator admin = (Administrator) ado;
        ArrayList<ApstraktniObjekat> admini = DBBroker.getInstance().selectBezUslova(ado);
        ArrayList<Administrator> lista = (ArrayList<Administrator>) (ArrayList<?>) admini;
        for (Administrator administrator : lista) {
            if (administrator.getUsername().equals(admin.getUsername())
                    && administrator.getPassword().equals(admin.getPassword())) {
                a = administrator;
            }
        }
    }

}
