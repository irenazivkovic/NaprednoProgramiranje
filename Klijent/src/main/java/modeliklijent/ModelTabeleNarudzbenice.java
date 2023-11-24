/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Narudzbenica;
import java.text.SimpleDateFormat;
import klijentkontroler.KlijentKontroler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz narudzbenica. Klasa nasledjuje apstraktnu klasu
 * AbstractTableModel i implementira njene apstraktne metode.
 *
 * @author Irena Zivkovic
 */
public class ModelTabeleNarudzbenice extends AbstractTableModel {

    /**
     * lista narudzbenica
     */
    private ArrayList<Narudzbenica> lista;
    /**
     * Naziv kolona tabele kao String
     */
    private String[] kolone = {"Sifra narudzbenice", "Admin kreirao", "Ime i prezime kupca", "Datum narudzbenice", "Status"};
    /**
     * Parametar kao String
     */
    private String parametar = "";

    /**
     * Konstruktor koji inicijalizuje model tabele narudzbenica.
     */
    public ModelTabeleNarudzbenice() {
        try {
            lista = KlijentKontroler.getInstance().getAllNarudzbenica();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleNarudzbenice.class.getName()).log(Level.SEVERE, null, ex);
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
        Narudzbenica n = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        switch (column) {
            case 0:
                return n.getNarudzbenicaID();
            case 1:
                return n.getAdministrator().toString();
            case 2:
                return n.getKupac().toString();
            case 3:
                return sdf.format(n.getDatum());
            case 4:
                return n.getStatus().toString();
            default:
                return null;
        }
    }

    /**
     * Metoda koja vraca narudzbenicu datog indexa.
     *
     * @param row Indeks narudzbenice.
     * @return Narudzbenica sa datog indexa.
     */
    public Narudzbenica getSelectedNarudzbenica(int row) {
        return lista.get(row);
    }

    /**
     * Postavlja parametar.
     *
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
            lista = KlijentKontroler.getInstance().getAllNarudzbenica();
            if (!parametar.equals("")) {
                ArrayList<Narudzbenica> novaLista = new ArrayList<>();
                for (Narudzbenica narudzbenica : lista) {
                    if (narudzbenica.getKupac().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || narudzbenica.getKupac().getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(narudzbenica);
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
