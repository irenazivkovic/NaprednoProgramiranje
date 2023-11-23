/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import java.sql.SQLException;

/**
 *
 * @author Irena
 */
public abstract class ApstraktnaSO {

    public void templateExecute(ApstraktniObjekat ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    protected abstract void validate(ApstraktniObjekat ado) throws Exception;

    protected abstract void execute(ApstraktniObjekat ado) throws SQLException;

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
