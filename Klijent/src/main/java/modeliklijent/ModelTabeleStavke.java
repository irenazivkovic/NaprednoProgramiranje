/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Knjiga;
import domenskeKlase.Stavka;
import klijentkontroler.KlijentKontroler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz stavki narudzbenice. Klasa nasledjuje apstraktnu klasu
 * AbstractTableModel i implementira njene apstraktne metode.
 *
 * @author Irena Zivkovic
 */
public class ModelTabeleStavke extends AbstractTableModel {

    /**
     * lista stavki narudzbenice
     */
    private ArrayList<Stavka> lista;
    /**
     * Naziv kolona tabele kao String
     */
    private String[] kolone = {"Redni broj", "Naziv knjige", "Cena", "Kolicina", "PDV"};
    /**
     * Redni broj stavke.
     */
    int rb = 1;

    /**
     * Konstruktor koji inicijalizuje model tabele stavke.
     */
    public ModelTabeleStavke() {
        try {
            lista = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleStavke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Parametrizovani konstruktor koji inicijalizuje model tabele stavke.
     * @param lista Lista stavki
     */
    public ModelTabeleStavke(ArrayList<Stavka> lista) {
        this.lista = lista;
    }

    /**
     * Metoda koja vraca listu stavki.
     * @return Lista stavki.
     */
    public ArrayList<Stavka> getLista() {
        return lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Stavka s = lista.get(row);

        switch (column) {
            case 0:
                return s.getRedniBroj();
            case 1:
                return s.getKnjiga().getNaslov();
            case 2:
                return s.getKnjiga().getCena();
            case 3:
                return s.getKolicina();
            case 4:
                return s.getPDV();
            default:
                return null;
        }
    }

    /**
     * Metoda koja proverava da li postoji vec stavka u tabeli.
     * @param s Nova stavka koja se unosi.
     * @return Odgovor servera.
     */
    public boolean postoji(Stavka s) {
        for (Stavka stavka : lista) {
            if (stavka.getKnjiga().getKnjigaID() == s.getKnjiga().getKnjigaID()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Dodavanje stavke
     * @param s Nova stavka koja se dodaje u tabelu.
     */
    public void dodaj(Stavka s) {
        s.setRedniBroj(rb++);
        lista.add(s);
        fireTableDataChanged();
    }

    /**
     * Izracunavanje ukupne cene
     * @return Vraca ukupnu cenu stavki.
     */
    public double vratiUkupnuCenu() {
        double ukupnaCena = 0;
        for (Stavka stavka : lista) {
            ukupnaCena += (stavka.getKolicina() * stavka.getKnjiga().getCena() + ((stavka.getKolicina() * stavka.getKnjiga().getCena() * stavka.getPDV()) / 100));
        }
        return ukupnaCena;
    }

    /**
     * Brise stavku iz tabele.
     * @param row Indeks stavke koji se brise.
     */
    public void obrisi(int row) {
        lista.remove(row);
        rb = 1;
        for (Stavka stavka : lista) {
            stavka.setRedniBroj(rb++);
        }
        fireTableDataChanged();
    }

}
