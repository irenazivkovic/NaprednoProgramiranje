/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Knjiga;
import klijentkontroler.KlijentKontroler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class ModelTabeleKnjige extends AbstractTableModel {

    private ArrayList<Knjiga> lista;
    private String[] kolone = {"Naslov", "Pisac", "Trenutno raspolozivo stanje", "Cena"};
    private String parametar = "";

    public ModelTabeleKnjige() {
        try {
            lista = KlijentKontroler.getInstance().getAllKnjiga();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleKnjige.class.getName()).log(Level.SEVERE, null, ex);
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
        Knjiga k = lista.get(row); 

        switch (column) {
            case 0:
                return k.getNaslov();
            case 1:
                return k.getPisac();
            case 2:
                return k.getStanje();
            case 3:
                return k.getCena();
            default:
                return null;
        }
    }

    public Knjiga getSelectedKnjiga(int row) {
        return lista.get(row);
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentKontroler.getInstance().getAllKnjiga();
            if (!parametar.equals("")) {
                ArrayList<Knjiga> novaLista = new ArrayList<>();
                for (Knjiga knjiga : lista) {
                    if (knjiga.getNaslov().toLowerCase().contains(parametar.toLowerCase())
                            || knjiga.getPisac().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(knjiga);
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
