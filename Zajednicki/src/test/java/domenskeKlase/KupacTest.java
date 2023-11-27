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

class KupacTest {

	 Kupac k;
	 Mesto m;
	 
	@BeforeEach
	void setUp() throws Exception {
		int id = 1;
        String ime = "Irena";
        String prezime = "Zivkovic";
        String adresa = "Madridska";
        int poeni = 2;
		m = new Mesto(1,36210,"Vrnjacka Banja");
		
		k = new Kupac(id, ime, prezime, adresa, poeni, m);
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
		m = null;
	}


	@Test
    public void testKonstruktorSaParametrima() {
        int id = k.getKupacID();
        String ime = k.getIme();
        String prezime = k.getPrezime();
        String adresa = k.getAdresa();
        int poeni = k.getPoeni();
        Mesto m = k.getMesto();
        
        assertNotNull(k);
        Assertions.assertEquals(id, k.getKupacID());
        Assertions.assertEquals(ime, k.getIme());
        Assertions.assertEquals(prezime, k.getPrezime());
        Assertions.assertEquals(adresa, k.getAdresa());
        Assertions.assertEquals(poeni, k.getPoeni());
        Assertions.assertEquals(m, k.getMesto());
    }
	
	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		k.setIme("Zika");
		k.setPrezime("Zikic");
		
		String s = k.toString();
		
		assertTrue( s.contains("Zika") );
		assertTrue( s.contains("Zikic") );
	}
	
	@Test
	void testSetId() {
		k.setKupacID(1);
		
		assertEquals(1, k.getKupacID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> k.setKupacID(id));
	}


    @Test
	void testSetImeSveOk() {
		k.setIme("Irena");
		
		assertEquals("Irena", k.getIme() );
	}
    
    @Test
	void testSetImeNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> k.setIme(null)  );
		
		assertEquals("Ime ne sme biti null", e.getMessage());
	}

    @Test
	void testSetImePrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> k.setIme("")  );
	}
    
    @Test
   	void testSetPrezimeSveOk() {
   		k.setPrezime("Zivkovic");
   		
   		assertEquals("Zivkovic", k.getPrezime() );
   	}
       
       @Test
   	void testSetPrezimeNull() {
   		Exception e = assertThrows(NullPointerException.class,
   				() -> k.setPrezime(null)  );
   		
   		assertEquals("Prezime ne sme biti null", e.getMessage());
   	}

       @Test
   	void testSetPrezimePrazanString() {
   		assertThrows(IllegalArgumentException.class,
   				() -> k.setPrezime("")  );
   	}
       
       @Test
      	void testSetAdresaSveOk() {
      		k.setAdresa("Zicka");
      		
      		assertEquals("Zicka", k.getAdresa() );
      	}
          
          @Test
      	void testSetAdresaNull() {
      		Exception e = assertThrows(NullPointerException.class,
      				() -> k.setAdresa(null)  );
      		
      		assertEquals("Adresa ne sme biti null", e.getMessage());
      	}

          @Test
      	void testSetAdresaPrazanString() {
      		assertThrows(IllegalArgumentException.class,
      				() -> k.setAdresa("")  );
      	}
             
       
    @Test
   	void testSetPoeni() {
   		k.setPoeni(5);
   		
   		assertEquals(5, k.getPoeni());
   	}
    
    @Test
   	void testSetPoeni0() {
   		k.setPoeni(0);
   		
   		assertEquals(0, k.getPoeni());
   	}
   	
   	@ParameterizedTest
   	@CsvSource ({
   		"-1",
   		"-55"
   	})
   	void testSetPoeniNedozvoljeno(int poeni) {
   		assertThrows(IllegalArgumentException.class,
   				() -> k.setPoeni(poeni));
   	}

   	@Test
  	void testSetMestoSveOk() {
  		k.setMesto(m);
  		assertEquals("Vrnjacka Banja", m.getNaziv() );
  	}
      
      @Test
  	void testSetMestoNull() {
  		Exception e = assertThrows(NullPointerException.class,
  				() -> k.setMesto(null)  );
  		
  		assertEquals("Mesto ne sme biti null", e.getMessage());
  	}
   	
}
