/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Stavka;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Irena
 */
public class SOAddNarudzbenica extends ApstraktnaSO {

    private boolean uspesno = false;
    
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
        Narudzbenica n = (Narudzbenica) ado;
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        int narID = tableKeys.getInt(1);
        n.setNarudzbenicaID(narID);
        
        for (Stavka stavka : n.getStavke()) {
            stavka.setNarudzbenica(n);
            DBBroker.getInstance().insert(stavka);
        }
        uspesno=true;
    }
    
}
