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

class KnjigaTest {

   Knjiga k;
   Pisac p;
	
	@BeforeEach
	void setUp() throws Exception {
		p = new Pisac(1, "Lav", "Tolstoj");
		k = new Knjiga(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
		k = null;
	}
	
	@Test
    public void testKonstruktorSaParametrima() {
        int id = k.getKnjigaID();
        String naslov = k.getNaslov();
        Pisac pisac = k.getPisac();
        double cena = k.getCena();
        int stanje = k.getStanje();
        
        assertNotNull(k);
        Assertions.assertEquals(id, k.getKnjigaID());
        Assertions.assertEquals(naslov, k.getNaslov());
        Assertions.assertEquals(pisac, k.getPisac());
        Assertions.assertEquals(cena, k.getCena());
        Assertions.assertEquals(stanje, k.getStanje());
    }
	
	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		k.setNaslov("Knjiga");
		k.setPisac(p);
                
		String s = k.toString();
		
		assertTrue( s.contains("Knjiga") );
	}
	
	@Test
	void testSetId() {
		k.setKnjigaID(1);
		
		assertEquals(1, k.getKnjigaID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> k.setKnjigaID(id));
	}


    @Test
	void testSetNaslovSveOk() {
		k.setNaslov("Ana Karenjina");
		
		assertEquals("Ana Karenjina", k.getNaslov() );
	}
    
    @Test
	void testSetNaslovNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> k.setNaslov(null)  );
		
		assertEquals("Naslov ne sme biti null", e.getMessage());
	}

    @Test
	void testSetNaslovPrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> k.setNaslov("")  );
	}
    
    @Test
   	void testSetPisacSveOk() {
   		k.setPisac(p);
   		
   		assertEquals("Lav", k.getPisac().getIme() );
   		assertEquals("Tolstoj", k.getPisac().getPrezime() );
   	}
       
       @Test
   	void testSetPisacNull() {
   		Exception e = assertThrows(NullPointerException.class,
   				() -> k.setPisac(null)  );
   		
   		assertEquals("Pisac ne sme biti null", e.getMessage());
   	}

       
    @Test
   	void testSetCena() {
   		k.setCena(1000);
   		
   		assertEquals(1000, k.getCena());
   	}
   	
   	@ParameterizedTest
   	@CsvSource ({
   		"0.00",
   		"-1",
   		"-55"
   	})
   	void testSetCenaNedozvoljeno(double cena) {
   		assertThrows(IllegalArgumentException.class,
   				() -> k.setCena(cena));
   	}

   	@Test
	void testSetStanje() {
		k.setKnjigaID(3);
		
		assertEquals(3, k.getKnjigaID());
	}
   	
	@Test
	void testSetStanje0() {
		k.setStanje(0);
		
		assertEquals(0, k.getStanje());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"-1",
		"-55"
	})
	void testSetSTanjeNedozvoljeno(int stanje) {
		assertThrows(IllegalArgumentException.class,
				() -> k.setStanje(stanje));
	}

	@Test
	void testSetPisac() {
		Pisac novPisac = new Pisac(2, "Robert", "Kiosaky");
		k.setPisac(novPisac);
		
		assertEquals(novPisac, k.getPisac());
	}
	
}
