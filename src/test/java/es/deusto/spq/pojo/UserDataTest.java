package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class UserDataTest {

    private UserData userData;

    @Before
    public void setUp() {
        userData = new UserData();
    }

    @Test
    public void testGetSetLogin() {
        String expected = "testLogin";
        userData.setLogin(expected);
        assertEquals(expected, userData.getLogin());
    }

    @Test
    public void testGetSetPassword() {
        String expected = "testPassword";
        userData.setPassword(expected);
        assertEquals(expected, userData.getPassword());
    }

    @Test
    public void testToString() {
        String expected = "[login=testLogin, password=testPassword]";
        userData.setLogin("testLogin");
        userData.setPassword("testPassword");
        assertEquals(expected, userData.toString());
    }

    @Test
    public void testMockito() {
        UserData mockedUserData = mock(UserData.class);
        when(mockedUserData.getLogin()).thenReturn("mockedLogin");
        when(mockedUserData.getPassword()).thenReturn("mockedPassword");
        assertEquals("mockedLogin", mockedUserData.getLogin());
        assertEquals("mockedPassword", mockedUserData.getPassword());
    }
}
