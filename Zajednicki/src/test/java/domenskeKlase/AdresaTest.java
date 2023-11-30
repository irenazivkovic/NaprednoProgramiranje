package domenskeKlase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AdresaTest {

	Adresa a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Adresa();
	}

	@AfterEach
	void tearDown() throws Exception {
		a= null;
	}


	@Test
    public void testKonstruktorSaParametrima() {
        int id = a.getAdresaID();
        String naziv = a.getNaziv();
        
        assertNotNull(a);
        Assertions.assertEquals(id, a.getAdresaID());
        Assertions.assertEquals(naziv, a.getNaziv());
    }
	
	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		a.setNaziv("Adresa 1");
		
		String s = a.toString();
		
		assertTrue( s.contains("Adresa 1") );
	}
	
	@Test
	void testSetId() {
		a.setAdresaID(1);
		
		assertEquals(1, a.getAdresaID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> a.setAdresaID(id));
	}


    @Test
	void testSetNazivSveOk() {
		a.setNaziv("Adresa 1");
		
		assertEquals("Adresa 1", a.getNaziv() );
	}
    
    @Test
	void testSetNazivNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> a.setNaziv(null)  );
		
		assertEquals("Naziv ne sme biti null", e.getMessage());
	}

    @Test
	void testSetNazivPrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> a.setNaziv("")  );
	}

}
