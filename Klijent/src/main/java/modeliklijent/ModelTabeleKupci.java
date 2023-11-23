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
 *
 * @author PC
 */
public class ModelTabeleKupci extends AbstractTableModel {

    private ArrayList<Kupac> lista;
    private String[] kolone = {"Ime i prezime", "Adresa stanovanja", "Mesto", "Poeni za popust"};
    private String parametar = "";

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
                return k.getAdresa();
            case 2:
                return k.getMesto().getNaziv();
            case 3:
                return k.getPoeni();
            default:
                return null;
        }
    }

    public Kupac getSelectedKupac(int row) {
        return lista.get(row);
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

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
