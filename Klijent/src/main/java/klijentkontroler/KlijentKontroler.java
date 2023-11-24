/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijentkontroler;

import domenskeKlase.Administrator;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sesija.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer_operacije.StatusOdgovora;
import transfer_operacije.Operacije_radna_memorija;

/**
 * Klasa Kontroler predstavlja glavni kontroler aplikacije. Sadrzi metode koje
 * komuniciraju sa serverom putem objekta Komunikacija, kao i metode za
 * manipulaciju podacima i prikaz korisniÄ�kog interfejsa.
 *
 * @author Irena Zivkovic
 */
public class KlijentKontroler {

    /**
     * instanca klase Kontroler
     */
    private static KlijentKontroler instance;

    /**
     * prazan konstruktor
     */
    public KlijentKontroler() {
    }

    /**
     * Metoda za dobijanje instance klase Kontroler.
     * Kreira novu instancu ukoliko veÄ‡ nije kreirana.
     * @return Instanca klase Kontroler.
     */
    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }

    /**
     * Metoda salje zahtev koji treba da se podradi na serverskoj strani
     * @param operation Operacija koja se izvrsava
     * @param data Parametar koji treba da se obradi
     * @return objekat koji se trazi.
     * @throws Exception ukoliko se ne posalje zahtev i desi se greska
     */
    private Object sendRequest(int operation, Object data) throws Exception {
        KlijentskiZahtev req = new KlijentskiZahtev(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor res = (ServerskiOdgovor) in.readObject();
        if (res.getResponseStatus().equals(StatusOdgovora.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }

    /**
     * Metoda za logovanje administratora
     * @param a podaci o Administratoru koji se loguje na sistem
     * @return Administratora iz baze podataka
     * @throws Exception ukoliko je administrator null
     */
    public Administrator login(Administrator a) throws Exception {
        return (Administrator) sendRequest(Operacije_radna_memorija.LOGIN, a);
    }

    /**
     * Metoda za dodavanje knjiga 
     * @param k knjiga koja treba da se doda
     * @return vraca odgovor da li je uspesno dodata ili ne
     * @throws Exception ukoliko nije knjiga uspesno dodata
     */
    public boolean addKnjiga(Knjiga k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.ADD_KNJIGA, k);
    }

    /**
     * Metoda vraca listu knjiga
     * @return lista knjiga
     * @throws Exception ukoliko ne moze da vrati listu
     */
    public ArrayList<Knjiga> getAllKnjiga() throws Exception {
        return (ArrayList<Knjiga>) sendRequest(Operacije_radna_memorija.GET_ALL_KNJIGA, null);
    }

    /**
     * Metoda za ponovo ucitavanje knjiga.
     * @param k Knjiga koja se pretrazuje
     * @return Vraca odgovor da li je uspesno dodata ili ne.
     * @throws Exception Ukoliko ne moze da izvrsi update.
     */
    public boolean updateKnjiga(Knjiga k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.UPDATE_KNJIGA, k);
    }

    /**
     * Metoda vraca listu mesta.
     * @return Lista objekata klase Mesto.
     * @throws Exception Ukoliko ne moze da se vrate mesta.
     */
    public ArrayList<Mesto> getAllMesto() throws Exception {
        return (ArrayList<Mesto>) sendRequest(Operacije_radna_memorija.GET_ALL_MESTO, null);
    }

    /**
     * Metoda za dodavanje kupca.
     * @param k Kupac koji treba da se doda.
     * @return Odgovor sa servera.
     * @throws Exception Ukoliko se ne doda kupac.
     */
    public boolean addKupac(Kupac k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.ADD_KUPAC, k);
    }

    /**
     * Metoda vraca listu kupaca.
     * @return Lista objekata klase Kupac.
     * @throws Exception Ukoliko ne moze da se vrate kupci.
     */
    public ArrayList<Kupac> getAllKupac() throws Exception {
        return (ArrayList<Kupac>) sendRequest(Operacije_radna_memorija.GET_ALL_KUPAC, null);
    }

    /**
     * Metoda za ponovo ucitavanje kupaca.
     * @param k Kupac koji se pretrazuje
     * @return Vraca odgovor da li je uspesno dodat ili ne.
     * @throws Exception Ukoliko ne moze da izvrsi update.
     */
    public boolean updateKupac(Kupac k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.UPDATE_KUPAC, k);
    }

    /**
     * Metoda za dodavanje objekta klase Narudzbenica.
     * @param n Narudzbenica koja treba da se doda.
     * @return Odgovor sa servera.
     * @throws Exception Ukoliko se ne doda narudzbenica.
     */
    public boolean addNarudzbenica(Narudzbenica n) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.ADD_NARUDZBENICA, n);
    }

    /**
     * Metoda vraca listu objketa klase Narudzbenica.
     * @return Lista objekata klase Naruzbenica.
     * @throws Exception Ukoliko ne moze da se vrate narudzbenice.
     */
    public ArrayList<Narudzbenica> getAllNarudzbenica() throws Exception {
        return (ArrayList<Narudzbenica>) sendRequest(Operacije_radna_memorija.GET_ALL_NARUDZBENICA, null);
    }

    /**
     * Metoda za ponovo ucitavanje objekta klase Narudzbenica. 
     * @param n Narudzbenica koja se pretrazuje.
     * @return Odgovor sa servera.
     * @throws Exception Ukoliko se ne izvrsi update narudzbenica.
     */
    public boolean updateNarudzbenica(Narudzbenica n) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.UPDATE_NARUDZBENICA, n);
    }

}
