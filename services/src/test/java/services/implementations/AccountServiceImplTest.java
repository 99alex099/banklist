package services.implementations;

import dao.interfaces.AccountDAO;
import dto.TotalAccount;
import dto.UserDTO;
import entities.Account;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {
    @Mock
    AccountDAO accountDAO;
    @InjectMocks
    AccountServiceImpl accountService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findUserAccounts() {
        List<Account> expectedAccounts = new LinkedList<>();
        expectedAccounts.add(new Account());

        User user = new User();

        when(accountDAO.findAccountsByUser(user)).thenReturn(expectedAccounts);
        assertEquals(accountService.findUserAccounts(user), expectedAccounts);
    }

    @Test
    public void findMaxTotalAccountSum() {
        TotalAccount expectedTotalAccount = new TotalAccount(111, new UserDTO());

        List<Account> accounts = new LinkedList<>();
        accounts.add(new Account(11, new User()));
        accounts.add(new Account(111, new User()));
        accounts.add(new Account(22, new User()));

        when(accountDAO.findTotalSumOfUserAccount()).thenReturn(accounts);
        assertEquals(accountService.findMaxTotalAccountSum().toString(),
                expectedTotalAccount.toString());
    }
}