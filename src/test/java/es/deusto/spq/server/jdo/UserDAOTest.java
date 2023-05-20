package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.ClientController;

public class UserDAOTest {



	@After
	public void tearDown() throws Exception {
	}


    private UserDAO userDAO;
    private UserDAO u1;
    private UserDAO u2;

    @Before
    public void setUp() {
        userDAO = new UserDAO(); // Crear una instancia del DAO
        // Inicializar la base de datos o configurar las dependencias necesarias
        u1 = UserDAO.getInstance();
        u2 = UserDAO.getInstance(); 
    }

//    @Test
//    public void testDeleteUser() {
//        // Crear un usuario de prueba y guardarlo en la base de datos
//        User user = new User("Imanol", "Imanol");
//        // Configurar los atributos del usuario, si es necesario
//
//        userDAO.Save(user);
//
//        // Eliminar el usuario de la base de datos
//        userDAO.delete(user);
//
//        // Verificar que el usuario se haya eliminado correctamente
//        User deletedUser = userDAO.find(user.getLogin());
//        assertNull(deletedUser);
//    }

	@Test
	public void testInst() {
		u1 = UserDAO.getInstance();
		assertEquals(u2, u1);
	}

	@Test
	public void testInstError() {
		u1 = null;
		u1 = UserDAO.getInstance();
		assertEquals(u2, u1);
	}
    
}
