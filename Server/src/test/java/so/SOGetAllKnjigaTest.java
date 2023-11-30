package so;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Narudzbenica;
import domenskeKlase.Pisac;

class SOGetAllKnjigaTest {

	SOGetAllKnjiga soGetAllKnjiga;
	Knjiga k;
	Pisac p;
	
	@BeforeEach
	void setUp() throws Exception {
		soGetAllKnjiga = new SOGetAllKnjiga();
		p = new Pisac(1, "Lav", "Tolstoj");
		k = new Knjiga(1, "Ana Karenjina", p, 2000, 20); 
	}

	@AfterEach
	void tearDown() throws Exception {
		soGetAllKnjiga = null;
		p = null;
		k = null;
	}

    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Narudzbenica(); // Klasa koja nije Knjiga
        try {
            soGetAllKnjiga.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Knjiga.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Knjiga(); 
      
            soGetAllKnjiga.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Knjiga);
        
    }
    
    @Test
    public void testUspesnoDohvatanjeSvihKnjiga() throws SQLException {
       // Knjiga k = new Knjiga(5, "Ana Karenjina", "Lav Tolstoj", 1000, 30); 
        
		k.setNaslov("Knjiga");
	
		k.setPisac(p);
		
            soGetAllKnjiga.execute(k);
            List<Knjiga> lista = soGetAllKnjiga.getLista();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            
            String jsonString = gson.toJson(lista);
            
            try (FileWriter writer = new FileWriter("knjige.json")) {
                writer.write(jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assertNotNull(lista);
	        assertTrue(lista.size() > 0); 
        
    }

}
