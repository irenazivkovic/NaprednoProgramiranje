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

class PisacTest {

	Pisac p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Pisac();
	}

	@AfterEach
	void tearDown() throws Exception {
		p= null;
	}


	@Test
    public void testKonstruktorSaParametrima() {
        int id = p.getPisacID();
        String ime = p.getIme();
        String prezime = p.getPrezime();
        
        assertNotNull(p);
        Assertions.assertEquals(id, p.getPisacID());
        Assertions.assertEquals(ime, p.getIme());
        Assertions.assertEquals(prezime, p.getPrezime());
    }
	
	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		p.setIme("Irena");
		p.setPrezime("Zivkovic");
		String s = p.toString();
		
		assertTrue( s.contains("Irena Zivkovic") );
	}
	
	@Test
	void testSetId() {
		p.setPisacID(1);
		
		assertEquals(1, p.getPisacID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> p.setPisacID(id));
	}


    @Test
	void testSetImeSveOk() {
		p.setIme("Irena");
		
		assertEquals("Irena", p.getIme() );
	}
    
    @Test
	void testSetImeNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> p.setIme(null)  );
		
		assertEquals("Ime ne sme biti null", e.getMessage());
	}

    @Test
	void testSetImePrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> p.setIme("")  );
	}
    
    @Test
	void testSetPrezimeSveOk() {
		p.setPrezime("Zivkovic");
		
		assertEquals("Zivkovic", p.getPrezime() );
	}
    
    @Test
	void testSetPrezimeNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> p.setPrezime(null)  );
		
		assertEquals("Prezime ne sme biti null", e.getMessage());
	}

    @Test
	void testSetPrezimePrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> p.setPrezime("")  );
	}
}
