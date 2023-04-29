package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UserTest {

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

}
