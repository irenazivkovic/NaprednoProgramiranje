/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer_operacije.StatusOdgovora;

/**
 * Klasa koja predstavlja odgovor servera na zahtev klijenta.
 * 
 * <p>Odgovor sadrzi podatke o rezultatu zahteva, poruku i informaciju o uspsnosti zahteva.
 * Moze se koristiti za prenos objekata sa servera na klijenta i obrnuto.</p>
 * <p> Klasa implementira interfejs Serializable, sto omogucava da se objekti klase Response serijalizuju i deserijlizuju.
 * Sto je neophodno, ukoliko koristimo prenos podataka izmedju procesa, putem soketa.</p>
 * 
 * @author Irena Zivkovic
 */
public class ServerskiOdgovor implements Serializable {

    /**
     * atribut kolase Object
     */
    private Object data;
    /**
     * greska klase Exception
     */
    private Exception error;
    /**
     * status odgovora koji moze da bude prihvacen ili da vrati gresku
     */
    private StatusOdgovora responseStatus;

    /**
     * Prazan konstruktor koji inicijalizuje objekat Odgovor.
     */
    public ServerskiOdgovor() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat Odgovor sa prosledjenim parametrima.
     * 
     * @param data rezultat zahteva
     * @param error Grska koja moze da se desi
     * @param responseStatus informacija da li je zahtev uspesno izvrsen
     */
    public ServerskiOdgovor(Object data, Exception error, StatusOdgovora responseStatus) {
        this.data = data;
        this.error = error;
        this.responseStatus = responseStatus;
    }

    /**
     * Vraca rezultat zahteva.
     * 
     * @return odgovor zahteva
     */
    public Object getData() {
        return data;
    }

    /**
     * Postavlja rezultat zahteva.
     * 
     * @param data rezultat zahteva koji treba postaviti
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Vraca gresku koja nastaje.
     * 
     * @return greska koja se desila
     */
    public Exception getError() {
        return error;
    }

    /**
     * Postavlja exception.
     * 
     * @param error exception koju treba postaviti
     */
    public void setError(Exception error) {
        this.error = error;
    }

    /**
     * Proverava da li je zahtev uspesno izvrsen.
     * 
     * @return true ako je zahtev uspesno izvrsen, false inace
     */
    public StatusOdgovora getResponseStatus() {
        return responseStatus;
    }

    /**
     * Postavlja informaciju da li je status uspesno prihvacen.
     * 
     * @param responseStatus true ako je status uspesno prihvacen, false inace
     */
    public void setResponseStatus(StatusOdgovora responseStatus) {
        this.responseStatus = responseStatus;
    }

}
