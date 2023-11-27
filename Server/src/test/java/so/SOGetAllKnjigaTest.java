package so;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Narudzbenica;

class SOGetAllKnjigaTest {

	SOGetAllKnjiga soGetAllKnjiga;
	Knjiga k;
	
	@BeforeEach
	void setUp() throws Exception {
		soGetAllKnjiga = new SOGetAllKnjiga();
		k = new Knjiga(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		soGetAllKnjiga = null;
		k = null;
	}

    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Narudzbenica(); // Klasa koja nije Knjiga
        try {
            soGetAllKnjiga.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Knjiga.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Knjiga(); 
      
            soGetAllKnjiga.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Knjiga);
        
    }

}
