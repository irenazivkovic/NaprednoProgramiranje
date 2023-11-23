/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverkontroler;

import domenskeKlase.Administrator;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import java.util.ArrayList;
import so.ApstraktnaSO;
import so.SOAddKnjiga;
import so.SOAddKupac;
import so.SOAddNarudzbenica;
import so.SOGetAllKnjiga;
import so.SOGetAllKupac;
import so.SOGetAllMesto;
import so.SOGetAllNarudzbenica;
import so.SOLogin;
import so.SOUpdateKnjiga;
import so.SOUpdateKupac;
import so.SOUpdateNarudzbenica;

/**
 *
 * @author PC
 */
public class ServerKontroler {

    private static ServerKontroler instance;

    public ServerKontroler() {
    }

    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getA();
    }

    public boolean addKnjiga(Knjiga knjiga) throws Exception {
        SOAddKnjiga so = new SOAddKnjiga();
        so.templateExecute(knjiga);
        return so.isUspesno();
    }

    public ArrayList<Knjiga> getAllKnjiga() throws Exception {
        SOGetAllKnjiga so = new so.SOGetAllKnjiga();
        so.templateExecute(new Knjiga());
        return so.getLista();
    }

    public boolean updateKnjiga(Knjiga knjiga) throws Exception {
        SOUpdateKnjiga so = new SOUpdateKnjiga();
        so.templateExecute(knjiga);
        return so.isUspesno();
    }

    public ArrayList<Mesto> getAllMesto() throws Exception {
        SOGetAllMesto so = new SOGetAllMesto();
        so.templateExecute(new Mesto());
        return so.getLista();
    }

    public boolean addKupac(Kupac kupac) throws Exception {
        SOAddKupac so = new SOAddKupac();
        so.templateExecute(kupac);
        return so.isUspesno();
    }

    public ArrayList<Kupac> getAllKupac() throws Exception {
        SOGetAllKupac so = new SOGetAllKupac();
        so.templateExecute(new Kupac());
        return so.getLista();
    }

    public boolean updateKupac(Kupac kupac) throws Exception {
        SOUpdateKupac so = new SOUpdateKupac();
        so.templateExecute(kupac);
        return so.isUspesno();
    }

    public boolean addNarudzbenica(Narudzbenica narudzbenica) throws Exception {
        SOAddNarudzbenica so = new SOAddNarudzbenica();
        so.templateExecute(narudzbenica);
        return so.isUspesno();
    }

    public ArrayList<Narudzbenica> getAllNarudzbenica() throws Exception {
        SOGetAllNarudzbenica so = new SOGetAllNarudzbenica();
        so.templateExecute(new Narudzbenica());
        return so.getLista();
    }

    public boolean updateNarudzbenica(Narudzbenica narudzbenica) throws Exception {
        SOUpdateNarudzbenica so = new SOUpdateNarudzbenica();
        so.templateExecute(narudzbenica);
        return so.isUspesno();
    }

}
