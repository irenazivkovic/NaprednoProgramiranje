/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import klijentkontroler.KlijentKontroler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz kupca.
 * Klasa nasledjuje apstraktnu klasu AbstractTableModel i 
 * implementira njene apstraktne metode.
 * 
 * @author Irena Zivkovic
 */
public class ModelTabeleKupci extends AbstractTableModel {

    /**
	 * lista kupac
	 */
    private ArrayList<Kupac> lista;
    /**
     * Naziv kolona tabele kao String
     */
    private String[] kolone = {"Ime i prezime", "Mesto", "Poeni za popust"};
    /**
     * Parametar kao String
     */
    private String parametar = "";

    /**
     * Konstruktor koji inicijalizuje model tabele kupac.
     */
    public ModelTabeleKupci() {
        try {
            lista = KlijentKontroler.getInstance().getAllKupac();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleKupci.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        Kupac k = lista.get(row);

        switch (column) {
            case 0:
                return k.toString();
            case 1:
                return k.getMesto().getNaziv();
            case 2:
                return k.getPoeni();
            default:
                return null;
        }
    }

    /**
     * Metoda koja vraca kupca datog indexa.
     * @param row Indeks kupca.
     * @return Kupac sa datog indexa
     */
    public Kupac getSelectedKupac(int row) {
        return lista.get(row);
    }

    /**
     * Postavlja parametar.
     * @param parametar Nova vrednost parametra koji se postavlja.
     */
    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    /**
     * Metoda koja sluzi za osvezavanje tabele
     */
    public void refreshTable() {
        try {
            lista = KlijentKontroler.getInstance().getAllKupac();
            if (!parametar.equals("")) {
                ArrayList<Kupac> novaLista = new ArrayList<>();
                for (Kupac kupac : lista) {
                    if (kupac.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || kupac.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(kupac);
                    }
                }
                lista = novaLista;
            }
            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
