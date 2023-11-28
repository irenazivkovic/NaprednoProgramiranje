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
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;

class SOAddKnjigaTest {

	private SOAddKnjiga soAddKnjiga;
	ApstraktniObjekat k;
	
	@BeforeEach
	void setUp() throws Exception {
		soAddKnjiga = new SOAddKnjiga();
		k = new Knjiga();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		soAddKnjiga = null;
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
        Knjiga knjiga = new Knjiga(1, "Knjiga 1", "Pisac 1", 0, -1);

        try {
            soAddKnjiga.validate(knjiga);
        } catch (Exception e) {
            assertEquals("Cena i stanje ne mogu biti 0 ili manji od 0. Unesite validan broj!", e.getMessage());
        }
    }
	
	@Test
	public void testExecute() throws Exception {

        Knjiga knjiga = new Knjiga();
        knjiga.setKnjigaID(5);
        knjiga.setNaslov("Ana Karenjina");
        knjiga.setPisac("Lav Tolstoj");
        knjiga.setCena(50); 
        
        
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
        postojecaKnjiga.setPisac("Autor");
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
