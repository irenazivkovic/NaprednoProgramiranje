/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import form.ServerskaForma;

/**
 * Glavna klasa za pokretanje servera.
 *
 * Klasa Start sadrzi staticku metodu main() koja se koristi za pokretanje
 * serverske forme. Instancira se objekat ServerskaForma i postavlja na vidljiv,
 * cime se prikazuje prozor serverske forme na ekranu.
 *
 * Ova klasa se koristi za pokretanje servera i prikazivanje korisnickog
 * interfejsa za upravljanje serverom.
 *
 * @author Irena Zivkovic
 */
public class Start {

    /**
     * Glavna metoda za pokretanje servera.
     *
     * @param args argumenti komandne linije (ne koriste se)
     */
    public static void main(String[] args) {
        new ServerskaForma().setVisible(true);
    }
}
