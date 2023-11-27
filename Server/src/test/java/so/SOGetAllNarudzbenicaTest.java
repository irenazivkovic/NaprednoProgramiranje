package so;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domenskeKlase.Administrator;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Status;

class SOGetAllNarudzbenicaTest {

	private SOGetAllNarudzbenica soGetAllNarudz;
	Narudzbenica n;
	Kupac k;
	Mesto m;
	Administrator a;
	
	@BeforeEach
	void setUp() throws Exception {
		soGetAllNarudz = new SOGetAllNarudzbenica();
		m = new Mesto(1,36210,"Vrnjacka Banja");
		k = new Kupac(2, "Irena", "Zivkovic", "ZIcka", 0, m);
		a = new Administrator(2, "Pera", "Peric");
		String datumStr = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datum = null;
        try {
            datum = sdf.parse(datumStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		n = new Narudzbenica(1, datum, 2, 1200, 
				Status.KREIRANA, k, null, a);
	}

	@AfterEach
	void tearDown() throws Exception {
		soGetAllNarudz = null;
		n = null;
		k = null;
		a = null;
		m = null;
	}

	 @Test
	    public void testNevalidanObjekat() {
	        ApstraktniObjekat nevalidanObjekat = new Knjiga(); 
	        try {
	        	soGetAllNarudz.validate(nevalidanObjekat);
	            fail("Izuzetak trebao biti bačen jer objekat nije tipa Knjiga.");
	        } catch (Exception e) {
	            assertEquals("Nevalidan objekat!", e.getMessage());
	        }
	    }

	 @Test
	    public void testValidanObjekat() throws Exception {
	        ApstraktniObjekat validanObjekat = new Narudzbenica(); 
	      
	        soGetAllNarudz.validate(validanObjekat);
	          
	            assertTrue(validanObjekat instanceof Narudzbenica);
	        
	    }

}
