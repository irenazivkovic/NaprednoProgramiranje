/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer_operacije;

/**
 * Enumeracija koja predstavlja operacije u sistemu E-Knjizara.
 *
 * @author Irena Zivkovic
 */
public interface Operacije_radna_memorija {

    /**
     * operacija za login administratora u bazi podataka
     */
    public static final int LOGIN = 0;
    /**
     * operacija za dodavanje knjiga u bazu podataka
     */
    public static final int ADD_KNJIGA = 1;
    /**
     * operacija za dodavanje narudzbenice u bazu podataka
     */
    public static final int ADD_NARUDZBENICA = 2;
    /**
     * operacija za vracanje svih knjiga iz baze podataka
     */
    public static final int GET_ALL_KNJIGA = 3;
    /**
     * operacija za dodavanje kupca u bazu podataka
     */
    public static final int ADD_KUPAC = 4;
    /**
     * operacija za izmenu knjiga u bazi podataka
     */
    public static final int UPDATE_KNJIGA = 5;
    /**
     * operacija za vracanje svih mesta iz baze podataka
     */
    public static final int GET_ALL_MESTO = 6;
    /**
     * operacija za vracanje svih kupaca iz baze podataka
     */
    public static final int GET_ALL_KUPAC = 7;
    /**
     * operacija za izmenu kupca u bazi podataka
     */
    public static final int UPDATE_KUPAC = 8;
    /**
     * operacija za vracanje svih narudzbenica iz baze podataka
     */
    public static final int GET_ALL_NARUDZBENICA = 9;
    /**
     * operacija za izmenu narudzbenice u bazi podataka
     */
    public static final int UPDATE_NARUDZBENICA = 10;

}
