package so;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Status;

class SOAddNarudzbenicaTest {

	private SOAddNarudzbenica soAddNarudzbenica;
	Narudzbenica n;
	Kupac k;
	Mesto m;
	//Administrator a;
	 
	@BeforeEach
	void setUp() throws Exception {
		soAddNarudzbenica = new SOAddNarudzbenica();
		m = new Mesto(1,36210,"Vrnjacka Banja");
		k = new Kupac(2, "Irena", "Zivkovic", "ZIcka", 0, m);
		//a = new Administrator(2, "Pera", "Peric");
		String datumStr = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datum = null;
        try {
            datum = sdf.parse(datumStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		n = new Narudzbenica(1, datum, 2, 1200, 
				Status.KREIRANA, k, null, null);
	}

	@AfterEach
	void tearDown() throws Exception {
		soAddNarudzbenica = null;
		n = null;
		k = null;
//		a = null;
		m = null;
	}

	/*@Test
    public void testUspesnoDodavanjeNarudzbenice() throws Exception {    
		soAddNarudzbenica.execute(n);

	    assertTrue(soAddNarudzbenica.isUspesno());
         
    }
*/
    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Kupac(); // Klasa koja nije Narudzbenica
        try {
            soAddNarudzbenica.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Narudzbenica.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }

   /* @Test
    public void testNeuspesnoDodavanjeNarudzbenice() throws SQLException {
        Narudzbenica narudzbenica = new Narudzbenica();

            soAddNarudzbenica.execute(narudzbenica);
            assertFalse(soAddNarudzbenica.isUspesno());
       
    }
    */
    
    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Narudzbenica(); 
      
            soAddNarudzbenica.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Narudzbenica);
        
    }

}
