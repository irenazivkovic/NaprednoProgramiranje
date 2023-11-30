package so;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domenskeKlase.Administrator;
import domenskeKlase.Adresa;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Status;

class SOUpdateNarudzbenicaTest {

	private SOUpdateNarudzbenica soUpdateNarudzbenica;
	Narudzbenica n;
	Kupac k;
	Mesto m;
	Adresa adress;
	Administrator a;
	
	@BeforeEach
	void setUp() throws Exception {
		soUpdateNarudzbenica = new SOUpdateNarudzbenica();
		adress = new Adresa(1, "Zicka"); 
		m = new Mesto(1,36210,"Vrnjacka Banja", adress);
		k = new Kupac(2, "Irena", "Zivkovic", 0, m);
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
		soUpdateNarudzbenica= null;
		adress = null;
		n = null;
		k = null;
		a = null;
		m = null;
	}

	@Test
    public void testUpdateNarudzbenica() throws SQLException {

        n.setNarudzbenicaID(1); 
        soUpdateNarudzbenica.execute(n);
        assertTrue(soUpdateNarudzbenica.isUspesno());
    }

	@Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Knjiga(); 
        try {
            soUpdateNarudzbenica.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Kupac.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }
    
    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Narudzbenica(); 
      
            soUpdateNarudzbenica.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Narudzbenica);
        
    }

   /* @Test
    public void testUpdateNarudzbenicaFalse() throws SQLException {
        //
        n.setNarudzbenicaID(12314234); 
        soUpdateNarudzbenica.execute(n);
        assertFalse(soUpdateNarudzbenica.isUspesno());
    }*/

}
