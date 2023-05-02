package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class UserTest {
	
	@Mock
	User u;
	
	@Before
	public void setUp() {
		u = new User("user", "pass");
	}

    @Test
    public void testGetLogin() {
    	assertEquals("user", u.getLogin());
    }
    @Test
    public void testGetPassword() {
    	assertEquals("pass", u.getPassword());
    }
    @Test
    public void testSetPassword() {
    	u.setPassword("word");
    	assertEquals("word", u.getPassword());
    }
    @Test
    public void testToString() {
    	
    	
    	assertEquals("User: login --> " + "user" + ", password -->  " + "pass" + "]",
    				 "User: login --> " + u.getLogin() + ", password -->  " + u.getPassword()  + "]");
    }
}
