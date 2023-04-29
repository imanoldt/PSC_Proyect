package es.deusto.spq.server.jdo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageTest {

    private Message message;
    private User mockUser;
    private String text = "Test message";

    @Before
    public void setUp() {
        mockUser = mock(User.class);
        message = new Message(text);
        message.setUser(mockUser);
    }

    @Test
    public void testGetUser() {
        assertEquals(mockUser, message.getUser());
    }

    @Test
    public void testGetText() {
        assertEquals(text, message.getText());
    }

}
