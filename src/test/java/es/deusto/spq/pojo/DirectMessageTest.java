package es.deusto.spq.pojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DirectMessageTest {

    @Mock
    private UserData mockUserData;

    @Mock
    private MessageData mockMessageData;

    @Test
    public void testSetAndGetUserData() {
        DirectMessage directMessage = new DirectMessage();
        directMessage.setUserData(mockUserData);

        assertEquals(mockUserData, directMessage.getUserData());
    }

    @Test
    public void testSetAndGetMessageData() {
        DirectMessage directMessage = new DirectMessage();
        directMessage.setMessageData(mockMessageData);

        assertEquals(mockMessageData, directMessage.getMessageData());
    }
}
