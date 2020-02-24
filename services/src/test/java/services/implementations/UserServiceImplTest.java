package services.implementations;

import dao.interfaces.UserDAO;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.interfaces.UserService;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Mock
    UserDAO userDAO;
    @InjectMocks
    UserServiceImpl userService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllUsers() {
        List<User> expectedUsers = new LinkedList<User>();
        when(userDAO.findAll()).thenReturn(expectedUsers);
        assertEquals(userService.findAllUsers(), expectedUsers);
    }
}