package so;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domenskeKlase.Adresa;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Knjiga;
import domenskeKlase.Kupac;
import domenskeKlase.Mesto;

class SOUpdateKupacTest {

	SOUpdateKupac soUpdateKupac;
	Mesto m;
	Kupac k;
	Adresa adress;
	
	@BeforeEach
	void setUp() throws Exception {
		soUpdateKupac = new SOUpdateKupac();
		adress = new Adresa(1, "Zicka"); 
		m = new Mesto(1,36210,"Vrnjacka Banja", adress);
		k = new Kupac(2, "Irena", "Zivkovic", 0, m);
	}

	@AfterEach
	void tearDown() throws Exception {
		soUpdateKupac = null;
		m = null;
		k = null;
		adress = null;
	}

    @Test
    public void testNevalidanObjekat() {
        ApstraktniObjekat nevalidanObjekat = new Knjiga(); 
        try {
            soUpdateKupac.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Kupac.");
        } catch (Exception e) {
            assertEquals("Nevalidan objekat!", e.getMessage());
        }
    }
    
    @Test
    public void testValidanObjekat() throws Exception {
        ApstraktniObjekat validanObjekat = new Kupac(); 
      
            soUpdateKupac.validate(validanObjekat);
          
            assertTrue(validanObjekat instanceof Kupac);
        
    }
    
    @Test
    public void testUspesnoAzuriranjeKupca() throws Exception {
		
        k.setIme("Ivana"); 

            soUpdateKupac.execute(k);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            
            String jsonString = gson.toJson(k);
            
            try (FileWriter writer = new FileWriter("izmenjen_kupac.json")) {
                writer.write(jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            assertTrue(soUpdateKupac.isUspesno());
        
    }

}
