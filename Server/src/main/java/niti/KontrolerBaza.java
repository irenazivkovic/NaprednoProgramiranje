/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Klasa koja predstavlja server i omogucava pokretanje servera i prihvatanje
 * klijentskih konekcija.
 *
 * @author Irena Zivkovic
 */
public class KontrolerBaza extends Thread {

    /**
     * ServerSocket koji se koristi za prihvatanje konekcija.
     */
    private ServerSocket serverSocket;

    /**
     * Konstruktor koji vrsi pokretanje servera i zauzimanje porta
     */
    public KontrolerBaza() {
        try {
            serverSocket = new ServerSocket(9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda run() klase Thread koja se izvrsava prilikom pokretanja niti. Vrsi
     * pokretanje servera i prihvatanje klijentskih konekcija.
     */
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ObradaZahteva oz = new ObradaZahteva(socket);
                oz.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
