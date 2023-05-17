package es.deusto.spq.pojo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioTest {

  
    private Usuario usuario;

    private String testName = "Test Name";
    private String testPassword = "Test Password";

    @Before
    public void setUp() {
        usuario = new Usuario(testName, testPassword);
    }
    @Test
    public void testUSU() {
        assertNotNull(new Usuario());
    }
    @Test
    public void testGetName() {
        assertEquals(testName, usuario.getName());
    }

    @Test
    public void testGetPassword() {
        assertEquals(testPassword, usuario.getPassword());
    }

    @Test
    public void testSetName() {
        String newName = "New Test Name";
        usuario.setName(newName);
        assertEquals(newName, usuario.getName());
    }

    @Test
    public void testSetPassword() {
        String newPassword = "New Test Password";
        usuario.setPassword(newPassword);
        assertEquals(newPassword, usuario.getPassword());
    }
}
