/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domenskeKlase.Administrator;
import java.awt.RadialGradientPaint;
import java.io.IOException;
import java.net.Socket;

/**
 * Klasa Sesija omogucava komunikaciju sa serverom putem soketa.
 * Implementira Singleton obrazac dizajna kako bi se obezbedila samo jedna instanca klase za celu aplikaciju.
 * 
 * @author Irena Zivkovic
 */
public class Sesija {

    /**
	 * instanca klase Sesija
	 */
    private static Sesija instance;
    /**
     * socket za komunikaciju
     */
    private Socket socket;
    /**
     * Ulogovani administrator
     */
    private Administrator ulogovani;

    /**
     * Konstruktor klase Sesija.
     * Inicijalizuje socket i povezuje se sa serverom na zadatoj adresi i portu.
     * U slucaju da server nije pokrenut, prikazuje se odgovarajuca poruka korisniku.
     */
    public Sesija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Vraca instancu klase Sesija.
     *
     * @return instanca klase Sesija.
     */
    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    /**
     * Vraca adresu i port soketa koji se koristi
     * @return socket koji se koristi.
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * Postavlja ulogovanog administratora.
     * @param a2 Admnistrator koji se ulogovao na sistem.
     */
    public void setUlogovani(Administrator a2) {
        this.ulogovani = a2;
    }

    /**
     * Vraca ulogovanog Administratora.
     * @return ulogovani Administrator.
     */
    public Administrator getUlogovani() {
        return ulogovani;
    }

}
