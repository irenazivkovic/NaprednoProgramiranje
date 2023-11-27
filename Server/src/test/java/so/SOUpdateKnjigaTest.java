package so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;

class SOUpdateKnjigaTest {

SOUpdateKnjiga soUpdateKnjiga;
	
	@BeforeEach
	void setUp() throws Exception {
		soUpdateKnjiga = new SOUpdateKnjiga();
	}

	@AfterEach
	void tearDown() throws Exception {
		soUpdateKnjiga = null;
	}

	@Test
    public void testUspesnoAzuriranjeKnjige() {
        Knjiga validnaKnjiga = new Knjiga(); 
        validnaKnjiga.setCena(50); 

        try {
            soUpdateKnjiga.execute(validnaKnjiga);
            assertTrue(soUpdateKnjiga.isUspesno());
        } catch (Exception e) {
            fail("Izuzetak nije trebao biti bačen.");
        }
    }

    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Kupac(); 
        try {
            soUpdateKnjiga.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Knjiga.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }

    @Test
    public void testNeuspesnoAzuriranjeKnjige() {
    	Knjiga knjiga = new Knjiga(1, "Knjiga 1", "Pisac 1", -10, 1);
        
    	try {
            soUpdateKnjiga.validate(knjiga);
            assertFalse(soUpdateKnjiga.isUspesno());
        } catch (Exception e) {
        	assertEquals("Cena ne moze biti manja od 0!", e.getMessage());
        }
    }
    
}
