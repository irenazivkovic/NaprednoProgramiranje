/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 * Klasa koja predstavlja zahtev klijentaka serveru.
 * 
 * <p>Zahtev moze sadrzati objekat i operaciju.
 * Koristi se za komunikaciju izmedju klijenta i servera u sistemu E-Knjizara-a-Car.</p>
 * <p> Klasa implementira interfejs Serializable, sto omogucava da se objekti klase Response serijalizuju i deserijlizuju.
 * Sto je neophodno, ukoliko koristimo prenos podataka izmedju procesa, putem soketa.</p>
 * 
 * @author Irena Zivkovic
 */
public class KlijentskiZahtev implements Serializable {

    /**
     * operacija koja treba da se izvrsi kao ceo broj
     */
    private int operation;
    /**
     * prametar koji se salje kao Object
     */
    private Object data;

    /**
     * Prazan konstruktor koji inicijalizuje objekat Zahtev.
     */
    public KlijentskiZahtev() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat KlijentskiZahtev sa prosledjenim objektom i operacijom.
     * 
     * @param data objekat koji se salje uz zahtev
     * @param operation operacija koja se salje uz zahtev
     */
    public KlijentskiZahtev(int operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    /**
     * Vraca objekat koji je sadrzan u zahtevu.
     * 
     * @return data koji je sadrzan u zahtevu
     */
    public Object getData() {
        return data;
    }

    /**
     * Vraca operaciju koja je sadrzana u zahtevu.
     * 
     * @return operacija koja je sadrzana u zahtevu
     */
    public int getOperation() {
        return operation;
    }

    /**
     * Postavlja objekat koji se salje uz zahtev.
     * 
     * @param data objekat koji treba postaviti
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Postavlja operaciju koja se salje uz zahtev.
     * 
     * @param operation operacija koju treba postaviti
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

}
