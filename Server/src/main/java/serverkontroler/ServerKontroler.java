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
import domenskeKlase.Pisac;
import java.util.ArrayList;
import so.ApstraktnaSO;
import so.SOAddKnjiga;
import so.SOAddKupac;
import so.SOAddNarudzbenica;
import so.SOGetAllKnjiga;
import so.SOGetAllKupac;
import so.SOGetAllMesto;
import so.SOGetAllNarudzbenica;
import so.SOGetAllPisac;
import so.SOLogin;
import so.SOUpdateKnjiga;
import so.SOUpdateKupac;
import so.SOUpdateNarudzbenica;

/**
 * Kontroler klasa koja upravlja poslovnim logikama servera.
 *
 * @author Irena Zivkovic
 */
public class ServerKontroler {

    /**
     * Instanca kontrolera
     */
    private static ServerKontroler instance;

    /**
     * Prazan konstruktor
     */
    public ServerKontroler() {
    }

    /**
     * Metoda koja vraca instancu kontrolera. Implementirana je kao Singleton
     * kako bi se osiguralo da postoji samo jedna instanca kontrolera.
     *
     * @return instanca kontrolera
     */
    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za login Administratora.
     *
     * @param administrator Administrator koji se loguje na sistem
     * @return Vraca ulogovanog administratora.
     * @throws Exception Ukoliko je ulogovni admin null
     */
    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getA();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za dodavanje knjige.
     *
     * @param knjiga knjiga koja treba da se doda
     * @return vraca odgovor da li je uspesno dodata ili ne
     * @throws Exception ukoliko nije knjiga uspesno dodata
     */
    public boolean addKnjiga(Knjiga knjiga) throws Exception {
        SOAddKnjiga so = new SOAddKnjiga();
        so.templateExecute(knjiga);
        return so.isUspesno();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracnje liste knjiga
     *
     * @return lista knjiga
     * @throws Exception ukoliko ne moze da vrati listu
     */
    public ArrayList<Knjiga> getAllKnjiga() throws Exception {
        SOGetAllKnjiga so = new so.SOGetAllKnjiga();
        so.templateExecute(new Knjiga());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za ucitavanje knjiga.
     *
     * @param knjiga Knjiga koja se pretrazuje
     * @return Vraca odgovor da li je uspesno dodata ili ne.
     * @throws Exception Ukoliko ne moze da izvrsi update.
     */
    public boolean updateKnjiga(Knjiga knjiga) throws Exception {
        SOUpdateKnjiga so = new SOUpdateKnjiga();
        so.templateExecute(knjiga);
        return so.isUspesno();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste mesta.
     *
     * @return Lista objekata klase Mesto.
     * @throws Exception Ukoliko ne moze da se vrate mesta.
     */
    public ArrayList<Mesto> getAllMesto() throws Exception {
        SOGetAllMesto so = new SOGetAllMesto();
        so.templateExecute(new Mesto());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za dodavanje kupca.
     *
     * @param kupac Kupac koji treba da se doda.
     * @return Odgovor sa servera.
     * @throws Exception Ukoliko se ne doda kupac.
     */
    public boolean addKupac(Kupac kupac) throws Exception {
        SOAddKupac so = new SOAddKupac();
        so.templateExecute(kupac);
        return so.isUspesno();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za vracanje liste kupaca.
     *
     * @return Lista objekata klase Kupac.
     * @throws Exception Ukoliko ne moze da se vrate kupci.
     */
    public ArrayList<Kupac> getAllKupac() throws Exception {
        SOGetAllKupac so = new SOGetAllKupac();
        so.templateExecute(new Kupac());
        return so.getLista();
    }

    /**
     * Metoda koja izvrsava poslovnu logiku za ponovo ucitavanje kupaca.
     *
     * @param kupac Kupac koji se pretrazuje
     * @return Vraca odgovor da li je uspesno dodat ili ne.
     * @throws Exception Ukoliko ne moze da izvrsi update.
     */
    public boolean updateKupac(Kupac kupac) throws Exception {
        SOUpdateKupac so = new SOUpdateKupac();
        so.templateExecute(kupac);
        return so.isUspesno();
    }

    /**
     * Metoda za izvrsavanje poslovne logike za dodavanje objekta klase
     * Narudzbenica.
     *
     * @param narudzbenica Narudzbenica koja treba da se doda.
     * @return Odgovor sa servera.
     * @throws Exception Ukoliko se ne doda narudzbenica.
     */
    public boolean addNarudzbenica(Narudzbenica narudzbenica) throws Exception {
        SOAddNarudzbenica so = new SOAddNarudzbenica();
        so.templateExecute(narudzbenica);
        return so.isUspesno();
    }

    /**
     * Metoda za izvrsavanje poslocne logike koja vraca listu objketa klase
     * Narudzbenica.
     *
     * @return Lista objekata klase Naruzbenica.
     * @throws Exception Ukoliko ne moze da se vrate narudzbenice.
     */
    public ArrayList<Narudzbenica> getAllNarudzbenica() throws Exception {
        SOGetAllNarudzbenica so = new SOGetAllNarudzbenica();
        so.templateExecute(new Narudzbenica());
        return so.getLista();
    }

    /**
     * Metoda za izvrsavanje poslovne logike koja ponovo ucitavanje objekta
     * klase Narudzbenica.
     *
     * @param narudzbenica Narudzbenica koja se pretrazuje.
     * @return Odgovor sa servera.
     * @throws Exception Ukoliko se ne izvrsi update narudzbenica.
     */
    public boolean updateNarudzbenica(Narudzbenica narudzbenica) throws Exception {
        SOUpdateNarudzbenica so = new SOUpdateNarudzbenica();
        so.templateExecute(narudzbenica);
        return so.isUspesno();
    }

    public ArrayList<Pisac> getAllPisci() throws Exception {
        SOGetAllPisac so = new SOGetAllPisac();
        so.templateExecute(new Pisac());
        return so.getLista();
    }

}
