package so;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;

class SOGetAllKupacTest {

	SOGetAllKupac soGetAllKupac;
	Kupac k;
	
	@BeforeEach
	void setUp() throws Exception {
		soGetAllKupac = new SOGetAllKupac();
		k = new Kupac(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		soGetAllKupac = null;
		k = null;
	}

	 @Test
	    public void testNevalidanObjekat() {
	        ApstraktniObjekat nevalidanObjekat = new Narudzbenica(); 
	        try {
	            soGetAllKupac.validate(nevalidanObjekat);
	            fail("Izuzetak trebao biti bačen jer objekat nije tipa Knjiga.");
	        } catch (Exception e) {
	            assertEquals("Nevalidan objekat!", e.getMessage());
	        }
	    }

	 @Test
	    public void testValidanObjekat() throws Exception {
	        ApstraktniObjekat validanObjekat = new Kupac(); 
	      
	            soGetAllKupac.validate(validanObjekat);
	          
	            assertTrue(validanObjekat instanceof Kupac);
	        
	    }

}
