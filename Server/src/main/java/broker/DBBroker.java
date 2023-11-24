/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import domenskeKlase.ApstraktniObjekat;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja broker za pristup bazi podataka.
 *
 * @author Irena Zivkovic
 */
public class DBBroker {

    /**
     * Instanca DbBrokera
     */
    private static DBBroker instance;
    /**
     * Objekat kalse Connection
     */
    private static Connection connection;

    /**
     * Metoda za otvaranje konekcije sa bazom podataka.
     *
     */
    public DBBroker() {

        //Properties properties =new Properties();
        try {
            //properties.load(new FileInputStream("dbconfig.properties"));
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/knjige", "root", "");
            connection.setAutoCommit(false);

        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metoda koja vraca instancu klase Connection
     *
     * @return instanca klase Connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Metoda koja vraca instancu klase DbBroker.
     *
     * @return instanca klase DbBroker
     */
    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    /**
     * Metoda koja selektuje elemente iz baze podataka.
     *
     * @param ado Objekat klase ApstraktniObjekat.
     * @return Lista objekata klase ApstraktniObjekat.
     * @throws SQLException Ukoliko se ne uspostavi konekcija sa bazom podataka.
     */
    public ArrayList<ApstraktniObjekat> select(ApstraktniObjekat ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.spajanje() + " " + ado.id() + " ";
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.selectLista(rs);
    }

    /**
     * Metoda za cuvanje objekta u bazi podataka
     *
     * @param ado objekat koji se cuva.
     * @return ID novog objekta
     * @throws SQLException Ukoliko se ne uspostavi konekcija sa bazom podataka.
     */
    public PreparedStatement insert(ApstraktniObjekat ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    /**
     * Metoda za izmenu objekta u bazi podataka.
     *
     * @param ado objekat koji se menja
     * @throws SQLException Ukoliko se ne uspostavi konekcija sa bazom podataka.
     */
    public void update(ApstraktniObjekat ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.id();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    /**
     * Metoda za brisanje objekta iz baze podataka.
     *
     * @param ado objekat koji se brise
     * @throws SQLException Ukoliko se ne uspostavi konekcija sa bazom podataka.
     */
    public void delete(ApstraktniObjekat ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.id();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    /**
     * Metoda koja selektuje elemente iz baze podataka ali kada nema dodatni
     * uslov.
     *
     * @param ado objekat po kojem se vrsi pretraga
     * @return objekat koji je izabran
     * @throws SQLException Ukoliko se ne uspostavi konekcija sa bazom podataka.
     */
    public ArrayList<ApstraktniObjekat> selectBezUslova(ApstraktniObjekat ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.spajanje();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.selectLista(rs);
    }

}
