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
 *
 * @author PC
 */
public class KlijentKontroler {

    private static KlijentKontroler instance;

    public KlijentKontroler() {
    }

    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }

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

    public Administrator login(Administrator a) throws Exception {
        return (Administrator) sendRequest(Operacije_radna_memorija.LOGIN, a);
    }

    public boolean addKnjiga(Knjiga k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.ADD_KNJIGA, k);
    }

    public ArrayList<Knjiga> getAllKnjiga() throws Exception {
        return (ArrayList<Knjiga>) sendRequest(Operacije_radna_memorija.GET_ALL_KNJIGA, null);
    }

    public boolean updateKnjiga(Knjiga k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.UPDATE_KNJIGA, k);
    }

    public ArrayList<Mesto> getAllMesto() throws Exception {
        return (ArrayList<Mesto>)sendRequest(Operacije_radna_memorija.GET_ALL_MESTO, null);
    }

    public boolean addKupac(Kupac k) throws Exception {
        return(boolean) sendRequest(Operacije_radna_memorija.ADD_KUPAC, k);
    }

    public ArrayList<Kupac> getAllKupac() throws Exception {
        return (ArrayList<Kupac>)sendRequest(Operacije_radna_memorija.GET_ALL_KUPAC, null);
    }

    public boolean updateKupac(Kupac k) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.UPDATE_KUPAC, k);
    }

    public boolean addNarudzbenica(Narudzbenica n) throws Exception {
        return (boolean) sendRequest(Operacije_radna_memorija.ADD_NARUDZBENICA, n);
    }

    public ArrayList<Narudzbenica> getAllNarudzbenica() throws Exception {
        return (ArrayList<Narudzbenica>) sendRequest(Operacije_radna_memorija.GET_ALL_NARUDZBENICA, null);
    }

    public boolean updateNarudzbenica(Narudzbenica n) throws Exception {
        return (boolean)sendRequest(Operacije_radna_memorija.UPDATE_NARUDZBENICA, n);
    }


}
