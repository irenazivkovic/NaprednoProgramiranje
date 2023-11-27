package so;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domenskeKlase.Administrator;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Kupac;

class SOLoginTest {

	private SOLogin soLogin;

	@BeforeEach
	void setUp() throws Exception {
		 soLogin = new SOLogin();
	}

	@AfterEach
	void tearDown() throws Exception {
		soLogin = null;
	}
	
    @Test
    public void testUspesnaPrijava() throws SQLException {
	     Administrator validniAdministrator = new Administrator(1,"luka", "luka123"); 

	       soLogin.execute(validniAdministrator);
	       assertNotNull(soLogin.getA());
	        
	    }

	    @Test
	    public void testNevalidanObjekat() {
	        ApstraktniObjekat nevalidanObjekat = new Kupac(); // Klasa koja nije Administrator
	        try {
	            soLogin.validate(nevalidanObjekat);
	            fail("Izuzetak trebao biti bačen jer objekat nije tipa Administrator.");
	        } catch (Exception e) {
	            assertEquals("Nevalidan objekat!", e.getMessage());
	        }
	    }
	    
	    @Test
	    public void testValidanObjekat() throws Exception {
	        ApstraktniObjekat validanObjekat = new Administrator(); 
	      
	            soLogin.validate(validanObjekat);
	          
	            assertTrue(validanObjekat instanceof Administrator);
	        
	    }

	    @Test
	    public void testNeuspesnaPrijava() {
	        Administrator pogresniPodaci = new Administrator(); // Postavite podatke koji ne odgovaraju ispravnim podacima za prijavu
	        // Simulirajte situaciju u kojoj prijava nije uspela (npr. pogrešno korisničko ime ili lozinka)

	        try {
	            soLogin.execute(pogresniPodaci);
	            assertNull(soLogin.getA());
	        } catch (Exception e) {
	            fail("Izuzetak nije trebao biti bačen.");
	        }
	    }

}
