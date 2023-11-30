package domenskeKlase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StavkaTest {

	Stavka s;
	Narudzbenica n;
	Knjiga k;
	Kupac kup;
	Administrator a;
	Mesto m;
	Adresa adress;
	Pisac p;
	
	
	@BeforeEach
	void setUp() throws Exception {
		int redniBorj = 1;
		int kolicina = 5;
		double cenaKom = 500;
		double pdv = 25;
		 adress = new Adresa(1, "Zicka 3");
		m = new Mesto(1,36210,"Vrnjacka Banja",adress);
		kup = new Kupac(2, "Irena", "Zivkovic", 0, m);
		a = new Administrator(2, "Pera", "Peric");
		n = new Narudzbenica(1, new Date(), 2, 1200, 
				Status.KREIRANA, kup, null, a);
		p = new Pisac(1, "Lav", "Tolstoj");
		k = new Knjiga(1, "Ana Karenjina",p, 1000, 30);
		
		s = new Stavka(n, k, redniBorj, kolicina, cenaKom, pdv);
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
		m = null;
		kup = null;
		a = null;
		n = null;
		k = null;
		adress = null;
		p = null;
	}

	@Test
    public void testKonstruktorSaParametrima() {
		Narudzbenica n = s.getNarudzbenica();
		Knjiga k = s.getKnjiga();
		int rb = s.getRedniBroj();
		int kolicina = s.getKolicina();
		double cenaKom = s.getCenaKom();
		double pdv = s.getPDV();
		
		assertNotNull(s);
        Assertions.assertEquals(n, s.getNarudzbenica());
        Assertions.assertEquals(k, s.getKnjiga());
        Assertions.assertEquals(rb, s.getRedniBroj());
        Assertions.assertEquals(kolicina, s.getKolicina());
        Assertions.assertEquals(cenaKom, s.getCenaKom());
        Assertions.assertEquals(pdv, s.getPDV());
    }

	@Test
	void testSetNarudzbenicaOk() {
		Kupac kup1 = new Kupac(2, "Irena", "Zivkovic", 0, m);
		Administrator a1 = new Administrator(2, "Pera", "Peric");
		Narudzbenica n1 = new Narudzbenica(1, new Date(), 2, 1200, 
				Status.KREIRANA, kup1, null, a1);
		s.setNarudzbenica(n1);
		
		assertEquals(n1, s.getNarudzbenica());
	}
	
    @Test
	void testSetNarudzbenicaNull() {
    	Stavka s = new Stavka();
    	
        assertThrows(NullPointerException.class, 
        		() -> s.setNarudzbenica(null));
	}
    
    @Test
	void testSetKnjigaOk() {
		Knjiga novaKnjiga = new Knjiga(1, "Ana Karenjina",p, 1000, 30);
		s.setKnjiga(novaKnjiga);
		
		assertEquals(novaKnjiga, s.getKnjiga());
	}
	
    @Test
	void testSetKnjigaNull() {
    	Stavka s = new Stavka();
    	
        assertThrows(NullPointerException.class, 
        		() -> s.setKnjiga(null));
	}

    @Test
    void testSetRb() {
        int rb = 2;

        s.setRedniBroj(rb);

        assertEquals(rb, s.getRedniBroj());
    }
    
    
    @Test
    void setNegativanRb() {
    	Stavka s = new Stavka();
    	
        assertThrows(IllegalArgumentException.class, 
        		() -> s.setRedniBroj(-1));
    }

    @Test
    void testSetKolicina() {
        int kol = 2;

        s.setKolicina(kol);

        assertEquals(kol, s.getKolicina());
    }
    
    @Test
    void setNegativnaKol() {
    	Stavka s = new Stavka();
    	
        assertThrows(IllegalArgumentException.class, 
        		() -> s.setKolicina(-1));
    }

    @Test
    void testSetCena() {
        double cena = 30.0;

        s.setCenaKom(cena);

        assertEquals(cena, s.getCenaKom());
    }
    
    @Test
    void setNegativnaCena() {
    	Stavka s = new Stavka();
    	
        assertThrows(IllegalArgumentException.class, 
        		() -> s.setCenaKom(-1));
    }
    
    @Test
    void testSetPDV() {
        double pdv = 12.5;

        s.setPDV(pdv);

        assertEquals(pdv, s.getPDV());
    }
    
    @Test
    void setNegativanPDV() {
    	Stavka s = new Stavka();
    	
        assertThrows(IllegalArgumentException.class, 
        		() -> s.setPDV(-1));
    }


    

}
