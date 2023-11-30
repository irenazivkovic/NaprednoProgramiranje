package so;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Mesto;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Pisac;

class SOGetAllPisacTest {

	SOGetAllPisac soGetAllPisac;
	ApstraktniObjekat p;
	
	@BeforeEach
	void setUp() throws Exception {
		soGetAllPisac= new SOGetAllPisac();
		p = new Pisac();
	}

	@AfterEach
	void tearDown() throws Exception {
		soGetAllPisac = null;
		p = null;
	}

	@Test
    public void testGetAllMesto() throws SQLException {
        Pisac p = new Pisac();
        soGetAllPisac.execute(p);

        ArrayList<Pisac> lista = soGetAllPisac.getLista();
        assertNotNull(lista);
        assertTrue(lista.size() > 0); // Proverite da li lista sadrži bar jedno mesto
    }

	@Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Narudzbenica(); // Klasa koja nije Knjiga
        try {
            soGetAllPisac.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Pisac.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }

	@Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Pisac(); 
      
            soGetAllPisac.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Pisac);
        
    }

}
