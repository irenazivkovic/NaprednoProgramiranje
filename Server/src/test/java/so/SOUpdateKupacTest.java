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

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;

class SOUpdateKupacTest {

	SOUpdateKupac soUpdateKupac;
	Mesto m;
	Kupac k;
	
	@BeforeEach
	void setUp() throws Exception {
		soUpdateKupac = new SOUpdateKupac();
		m = new Mesto(3,33000,"Mesto 3");
		k = new Kupac(2, "Ivan", "Ivanovic", "Ljubice Stanisavljevic 15", 10, m);
	}

	@AfterEach
	void tearDown() throws Exception {
		soUpdateKupac = null;
		m = null;
		k = null;
	}

    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Knjiga(); 
        try {
            soUpdateKupac.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Kupac.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }
    
    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Kupac(); 
      
            soUpdateKupac.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Kupac);
        
    }

}