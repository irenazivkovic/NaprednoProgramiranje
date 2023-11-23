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
 *
 * @author PC
 */
public class ModelTabeleStavke extends AbstractTableModel {

    private ArrayList<Stavka> lista;
    private String[] kolone = {"Redni broj", "Naziv knjige", "Cena", "Kolicina", "PDV"};
    int rb = 1;

    public ModelTabeleStavke() {
        try {
            lista = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleStavke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ModelTabeleStavke(ArrayList<Stavka> lista) {
        this.lista = lista;
    }

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

    public boolean postoji(Stavka s) {
        for (Stavka stavka : lista) {
            if (stavka.getKnjiga().getKnjigaID() == s.getKnjiga().getKnjigaID()) {
                return true;
            }
        }
        return false;
    }

    public void dodaj(Stavka s) {
        s.setRedniBroj(rb++);
        lista.add(s);
        fireTableDataChanged();
    }

    public double vratiUkupnuCenu() {
        double ukupnaCena = 0;
        for (Stavka stavka : lista) {
            ukupnaCena += (stavka.getKolicina() * stavka.getKnjiga().getCena() + ((stavka.getKolicina() * stavka.getKnjiga().getCena() * stavka.getPDV()) / 100));
        }
        return ukupnaCena;
    }

    public void obrisi(int row) {
        lista.remove(row);
        rb=1;
        for (Stavka stavka : lista) {
            stavka.setRedniBroj(rb++);
        }
        fireTableDataChanged();
    }

}
