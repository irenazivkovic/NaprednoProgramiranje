package domenskeKlase;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NarudzbenicaTest {

	Narudzbenica n;
	Kupac k;
	Mesto m;
	Administrator a;
	
	@BeforeEach
	void setUp() throws Exception {
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
		n = null;
		k = null;
		a = null;
		m = null;
	}
	
	@Test
    public void testKonstruktorSaParametrima() {
		int id = n.getNarudzbenicaID();
		Date datum = n.getDatum();
		double popust = n.getPopust();
		double ukCena = n.getUkupnaCena();
		Status s = n.getStatus();
		Kupac k = n.getKupac();
		
		assertNotNull(n);
        Assertions.assertEquals(id, n.getNarudzbenicaID());
        Assertions.assertEquals(datum, n.getDatum());
        Assertions.assertEquals(popust, n.getPopust());
        Assertions.assertEquals(ukCena, n.getUkupnaCena());
        Assertions.assertEquals(s, n.getStatus());
        Assertions.assertEquals(k, n.getKupac());
    }
	
	@Test
	void testSetId() {
		n.setNarudzbenicaID(1);
		
		assertEquals(1, n.getNarudzbenicaID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> n.setNarudzbenicaID(id));
	}

	 @Test
	   	void testSetCena() {
	   		n.setUkupnaCena(1000);
	   		
	   		assertEquals(1000, n.getUkupnaCena());
	   	}
	   	
	   	@ParameterizedTest
	   	@CsvSource ({
	   		"0.00",
	   		"-1",
	   		"-55"
	   	})
	   	void testSetCenaNedozvoljeno(double cena) {
	   		assertThrows(IllegalArgumentException.class,
	   				() -> n.setUkupnaCena(cena));
	   	}
	   	
	    @Test
	   	void testSetPopust() {
	   		n.setPopust(10);
	   		
	   		assertEquals(10, n.getPopust());
	   	}
	   	
	   	@ParameterizedTest
	   	@CsvSource ({
	   		"-1",
	   		"-55"
	   	})
	   	void testSetPopustNedozvoljeno(double p) {
	   		assertThrows(IllegalArgumentException.class,
	   				() -> n.setPopust(p));
	   	}

	@Test
	void testSetStatus() {
		n.setStatus(Status.KREIRANA);
		
		assertEquals(Status.KREIRANA, n.getStatus());
	}
	
	 @Test
		void testSetStatusNull() {
			Exception e = assertThrows(NullPointerException.class,
					() -> n.setStatus(null)  );
			
			assertEquals("Status ne sme biti null", e.getMessage());
		}
	 
	 @Test
		void testSetKupac() {
			Kupac novKupac = new Kupac(1, "Irena", "Zivkovic", "Zicka", 0, m);
			n.setKupac(novKupac);
			
			assertEquals(novKupac, n.getKupac());
		}
		
		 @Test
			void testSetKupacNull() {
				Exception e = assertThrows(NullPointerException.class,
						() -> n.setKupac(null)  );
				
				assertEquals("Kupac ne sme biti null", e.getMessage());
			}

}
