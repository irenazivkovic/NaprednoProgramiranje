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

class SOGetAllMestoTest {

	SOGetAllMesto soGetAllMesto;
	ApstraktniObjekat m;
	
	@BeforeEach
	void setUp() throws Exception {
		soGetAllMesto = new SOGetAllMesto();
		m = new Mesto();
	}

	@AfterEach
	void tearDown() throws Exception {
		soGetAllMesto = null;
		m = null;
	}

	@Test
    public void testGetAllMesto() throws SQLException {
        Mesto m = new Mesto();
        soGetAllMesto.execute(m);

        ArrayList<Mesto> lista = soGetAllMesto.getLista();
        assertNotNull(lista);
        assertTrue(lista.size() > 0); // Proverite da li lista sadrži bar jedno mesto
    }

	@Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Narudzbenica(); // Klasa koja nije Knjiga
        try {
            soGetAllMesto.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Knjiga.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }

	@Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Mesto(); 
      
            soGetAllMesto.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Mesto);
        
    }
	

}
