package so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domenskeKlase.Administrator;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;

class SOAddKupacTest {

	private SOAddKupac soAddKupac;
	ApstraktniObjekat k;
	Mesto m;
	
	@BeforeEach
	void setUp() throws Exception {
		soAddKupac = new SOAddKupac();
		m = new Mesto(1,36210,"Vrnjacka Banja");
		k = new Kupac(2, "Irena", "Zivkovic", "ZIcka", 0, m);
	}

	@AfterEach
	void tearDown() throws Exception {
		soAddKupac = null;
		m = null;
		k = null;
	}

	@Test
    public void testUspesnoDodavanjeKupca() throws Exception {
        
        soAddKupac.execute(k);
        assertTrue(soAddKupac.isUspesno());
        
    }

    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Administrator(); 
        try {
            soAddKupac.validate(nevalidanObjekat);
  
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }
    
    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Kupac(); 
      
            soAddKupac.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Kupac);
        
    }

}
