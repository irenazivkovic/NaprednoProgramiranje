package so;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domenskeKlase.Administrator;
import domenskeKlase.Adresa;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Pisac;

class SOAddKnjigaTest {

	private SOAddKnjiga soAddKnjiga;
	Knjiga k;
	Pisac p;
	
	@BeforeEach
	void setUp() throws Exception {
		soAddKnjiga = new SOAddKnjiga();
        p = new Pisac(1, "Lav", "Tolstoj");
		k = new Knjiga(5, "Ana Karenjina", p, 1200, 2);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		soAddKnjiga = null;
		p = null;
		k = null;
	}

	@Test
	public void testNevalidanObjekat() throws Exception {
	    // Testiranje validate metode sa nevažećim objektom
		try {
	    ApstraktniObjekat invalidObj = new Administrator(); 
	    soAddKnjiga.validate(invalidObj);
		}
		catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
	}

	@Test
    public void testCenaIStanjeManjiIliJednakoNula() {
        Pisac pisac = new Pisac(1, "Ana", "Zivkovic");
        Knjiga knjiga = new Knjiga(1, "Knjiga 1", pisac, 0, -1);

        try {
            soAddKnjiga.validate(knjiga);
        } catch (Exception e) {
            assertEquals("Cena i stanje ne mogu biti 0 ili manji od 0. Unesite validan broj!", e.getMessage());
        }
    }
	
	
	@Test
	public void testExecute() throws Exception {


        Pisac novP = new Pisac(2, "Lav", "Tolstoj");
        Knjiga knjiga = new Knjiga(5, "Ana Karenjina", novP, 1200, 2);
        
        soAddKnjiga.execute(knjiga);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        
        String jsonString = gson.toJson(knjiga);
        
        try (FileWriter writer = new FileWriter("dodata_knjiga.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(soAddKnjiga.isUspesno());
    }
	
	
	/*
	@Test
	void testDodajKnjiguDuplikat() throws Exception {
		Knjiga knjiga1 = new Knjiga();
        knjiga1.setPisac("Autor");
        knjiga1.setNaslov("Naslov");

        ArrayList<ApstraktniObjekat> knjigeUBazi = new ArrayList<>();
        
        Knjiga postojecaKnjiga = new Knjiga();
        postojecaKnjiga.setPisac(p);
        postojecaKnjiga.setNaslov("Naslov");
        knjigeUBazi.add(postojecaKnjiga);

        try {
            soAddKnjiga.validate(knjiga1);
            fail("Izuzetak trebao biti bačen jer knjiga sa istim piscem i naslovom već postoji u bazi.");
        } catch (Exception e) {
            assertEquals("Knjiga sa ovim piscem vec postoji u bazi!", e.getMessage());
        }
	}
	*/

}
