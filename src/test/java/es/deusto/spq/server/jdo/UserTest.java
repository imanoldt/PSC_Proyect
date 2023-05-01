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

import es.deusto.spq.pojo.Compra;
import es.deusto.spq.pojo.Libro;

public class UserTest {
	
	@Mock
	User u;
	
	@Before
	public void setUp() {
		u = new User("user", "pass");
	}
    @Test
    public void testAddMessage() {
        // Creamos un mock de la clase Message
        Message message = mock(Message.class);
        // Creamos un usuario
        User user = new User("test", "password");
        // Añadimos el mensaje al usuario
        user.addMessage(message);
        // Comprobamos que el mensaje se ha añadido correctamente
        assertEquals(1, user.getMessages().size());
        assertEquals(true, user.getMessages().contains(message));
    }

    @Test
    public void testRemoveMessage() {
        // Creamos un mock de la clase Message
        Message message = mock(Message.class);
        // Creamos un usuario y le añadimos el mensaje
        User user = new User("test", "password");
        user.addMessage(message);
        // Comprobamos que el mensaje se ha añadido correctamente
        assertEquals(1, user.getMessages().size());
        assertEquals(true, user.getMessages().contains(message));
        // Eliminamos el mensaje del usuario
        user.removeMessage(message);
        // Comprobamos que el mensaje se ha eliminado correctamente
        assertEquals(0, user.getMessages().size());
        assertEquals(false, user.getMessages().contains(message));
    }

    @Test
    public void testGetMessages() {
        // Creamos dos mock de la clase Message
        Message message1 = mock(Message.class);
        Message message2 = mock(Message.class);
        // Creamos un usuario y le añadimos los mensajes
        User user = new User("test", "password");
        user.addMessage(message1);
        user.addMessage(message2);
        // Comprobamos que se han añadido los dos mensajes correctamente
        assertEquals(2, user.getMessages().size());
        assertEquals(true, user.getMessages().contains(message1));
        assertEquals(true, user.getMessages().contains(message2));
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
    	Set<Message> messages = new HashSet<>();
    	StringBuilder messagesStr = new StringBuilder();
		for (Message message: messages) {
			messagesStr.append(message.toString() + " - ");
		}
		assertEquals(messagesStr, messagesStr);
    	assertEquals("User: login --> " + u.getLogin() + ", password -->  " + u.getPassword() + ", messages --> [" + messagesStr + "]", "User: login --> " + u.getLogin() + ", password -->  " + u.getPassword() + ", messages --> [" + messagesStr + "]");
    }
    @Test
    public void testNotToString() {
    	Set<Message> messages = new HashSet<>();
    	StringBuilder messagesStr = new StringBuilder();
		for (Message message: messages) {
			messagesStr.append(message.toString() + " - ");
		}
    	assertNotEquals("User: login --> " + u.getLogin() + ", password -->  " + u.getPassword() + ", messages --> [" + messagesStr + "]", "User: login --> " + u.getLogin() + ", password -->  " + u.getPassword() + ", messages --> [" + messagesStr +"asd"+ "]");
    }
}
