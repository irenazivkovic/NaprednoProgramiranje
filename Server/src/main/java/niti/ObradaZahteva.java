/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domenskeKlase.Administrator;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Pisac;
import serverkontroler.ServerKontroler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer_operacije.StatusOdgovora;
import transfer_operacije.Operacije_radna_memorija;

/**
 * Klasa predstavlja serversku nit koja obradjuje zahteve klijenta.
 *
 * ObradaZahteva je klasa koja nasledjuje Thread i predstavlja serversku nit
 * koja se pokrece za svakog klijenta koji se poveze sa serverom. Svaka instanca
 * ove klase ima svoj socket preko kojeg komunicira sa klijentom.
 *
 * Nit u petlji ceka na pristizanje zahteva od klijenta, obradjuje ih koristeci
 * odgovarajuce metode iz Kontrolera i salje odgovor klijentu.
 *
 * @see KontrolerBaza
 * @see Socket
 * @see KlijentskiZahtev
 * @see ServerskiOdgovor
 * @see Thread
 *
 * @author Irena Zivkovic
 */
public class ObradaZahteva extends Thread {

    /**
     * Socket koji se koristi za komunikaciju sa klijentom.
     */
    private Socket socket;

    /**
     * Konstruktor klase KlijentskaNit.
     *
     * @param socket Socket preko kojeg se komunicira sa klijentom
     */
    ObradaZahteva(Socket socket) {
        this.socket = socket;
    }

    /**
     * Metoda prima zahtev od klijenta preko ObjectInputStream-a, cita ga i
     * vraca kao objekat klase Zahtev.
     *
     * Zatim metoda salje odgovor klijentu preko ObjectOutputStream-a.
     *
     */
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev req = (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda koja se izvrsava prilikom pokretanja niti.
     *
     * Metoda ceka na pristizanje zahteva od klijenta, obraduje ih koristeci
     * odgovarajuce metode iz Kontrolera i salje odgovor klijentu.
     *
     * @param req Zahtev koji je klijent poslao
     * @return serverski odgovor sistema.
     */
    private ServerskiOdgovor handleRequest(KlijentskiZahtev req) {
        ServerskiOdgovor res = new ServerskiOdgovor(null, null, StatusOdgovora.Success);

        try {
            switch (req.getOperation()) {
                case Operacije_radna_memorija.LOGIN:
                    Administrator a = ServerKontroler.getInstance().login((Administrator) req.getData());
                    res.setData(a);
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji admin!");
                    } else {
                        break;

                    }
                case Operacije_radna_memorija.ADD_KNJIGA:
                    boolean uspesno = ServerKontroler.getInstance().addKnjiga((Knjiga) req.getData());
                    res.setData(uspesno);
                    break;
                case Operacije_radna_memorija.GET_ALL_KNJIGA:
                    ArrayList<Knjiga> listaknjiga = ServerKontroler.getInstance().getAllKnjiga();
                    res.setData(listaknjiga);
                    break;
                case Operacije_radna_memorija.UPDATE_KNJIGA:
                    boolean uspesno2 = ServerKontroler.getInstance().updateKnjiga((Knjiga) req.getData());
                    res.setData(uspesno2);
                    break;
                case Operacije_radna_memorija.GET_ALL_MESTO:
                    ArrayList<Mesto> mesto = ServerKontroler.getInstance().getAllMesto();
                    res.setData(mesto);
                    break;
                case Operacije_radna_memorija.ADD_KUPAC:
                    boolean uspesno3 = ServerKontroler.getInstance().addKupac((Kupac) req.getData());
                    res.setData(uspesno3);
                    break;
                case Operacije_radna_memorija.GET_ALL_KUPAC:
                    ArrayList<Kupac> kupci = ServerKontroler.getInstance().getAllKupac();
                    res.setData(kupci);
                    break;
                case Operacije_radna_memorija.UPDATE_KUPAC:
                    boolean uspesno4 = ServerKontroler.getInstance().updateKupac((Kupac) req.getData());
                    res.setData(uspesno4);
                    break;
                case Operacije_radna_memorija.ADD_NARUDZBENICA:
                    boolean uspesno5 = ServerKontroler.getInstance().addNarudzbenica((Narudzbenica) req.getData());
                    res.setData(uspesno5);
                    break;
                case Operacije_radna_memorija.GET_ALL_NARUDZBENICA:
                    ArrayList<Narudzbenica> narudzbenice = ServerKontroler.getInstance().getAllNarudzbenica();
                    res.setData(narudzbenice);
                    break;
                case Operacije_radna_memorija.UPDATE_NARUDZBENICA:
                    boolean uespesno6 = ServerKontroler.getInstance().updateNarudzbenica((Narudzbenica) req.getData());
                    res.setData(uespesno6);
                    break;
                case Operacije_radna_memorija.GET_ALL_PISAC:
                    ArrayList<Pisac> pisci = ServerKontroler.getInstance().getAllPisci();
                    res.setData(pisci);
                    break; 
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setResponseStatus(StatusOdgovora.Error);
        }
        return res;
    }
}
