package domenskeKlase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MestoTest {

	Mesto m;

	@BeforeEach
	void setUp() throws Exception {
		m = new Mesto();
	}

	@AfterEach
	void tearDown() throws Exception {
		m = null;
	}
	
	@Test
    void konstruktorTest() {
        int id = 1;
        int ptt = 1100;
        String naziv = "Beograd";

        Mesto m = new Mesto(id,ptt, naziv);

        assertEquals(id, m.getMestoID());
        assertEquals(ptt, m.getPTT());
        assertEquals(naziv, m.getNaziv());
    }
	
	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		m.setNaziv("Beograd");
		
		String s = m.toString();
		
		assertTrue( s.contains("Beograd") );
	}

	@Test
	void testSetId() {
		m.setMestoID(1);
		
		assertEquals(1, m.getMestoID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> m.setMestoID(id));
	}

	@Test
	void testSetPTT() {
		m.setPTT(11000);
		
		assertEquals(11000, m.getPTT());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetPTTNedozvoljeno(int ptt) {
		assertThrows(IllegalArgumentException.class,
				() -> m.setPTT(ptt));
	}

    @Test
	void testSetNazivSveOk() {
		m.setNaziv("Beograd");
		
		assertEquals("Beograd", m.getNaziv() );
	}
    
    @Test
	void testSetNazivNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> m.setNaziv(null)  );
		
		assertEquals("Naziv ne sme biti null", e.getMessage());
	}

    @Test
	void testSetNazivPrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> m.setNaziv("")  );
	}
    
}
