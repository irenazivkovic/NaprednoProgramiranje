package domenskeKlase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AdministratorTest {
	
	Administrator admin;

	@BeforeEach
	void setUp() throws Exception {
		admin = new Administrator();
	}

	@AfterEach
	void tearDown() throws Exception {
		admin = null;
	}
	
	@Test
    void konstruktorTest() {
        int id = 1;
        String username = "irena";
        String passwoerd = "irena";

        Administrator admin = new Administrator(id, username, passwoerd);

        assertEquals(id, admin.getAdminID());
        assertEquals(username, admin.getUsername());
        assertEquals(passwoerd, admin.getPassword());
    }
	
	@Test
	@DisplayName ("Test za proveru toString metode")
	void testToString() {
		admin.setUsername("zika");

		String s = admin.toString();
		
		assertTrue( s.contains("zika") );
	}
	
	@Test
	void testSetId() {
		admin.setAdminID(1);
		
		assertEquals(1, admin.getAdminID());
	}
	
	@ParameterizedTest
	@CsvSource ({
		"0",
		"-1",
		"-55"
	})
	void testSetIdNedozvoljeno(int id) {
		assertThrows(IllegalArgumentException.class,
				() -> admin.setAdminID(id));
	}


    @Test
	void testSetUsernameSveOk() {
		admin.setUsername("pera");
		
		assertEquals("pera", admin.getUsername() );
	}
    
    @Test
	void testSetUsernameNull() {
		Exception e = assertThrows(NullPointerException.class,
				() -> admin.setUsername(null)  );
		
		assertEquals("Username ne sme biti null", e.getMessage());
	}

    @Test
	void testSetUsernamePrazanString() {
		assertThrows(IllegalArgumentException.class,
				() -> admin.setUsername("")  );
	}
    
    @Test
   	void testSetPasswordSveOk() {
   		admin.setPassword("pera");
   		
   		assertEquals("pera", admin.getPassword() );
   	}
       
       @Test
   	void testSetpasswordNull() {
   		Exception e = assertThrows(NullPointerException.class,
   				() -> admin.setPassword(null)  );
   		
   		assertEquals("Password ne sme biti null", e.getMessage());
   	}

       @Test
   	void testSetPasswordPrazanString() {
   		assertThrows(IllegalArgumentException.class,
   				() -> admin.setPassword("")  );
   	}

}
