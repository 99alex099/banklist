package services.implementations;

import dao.implementations.AccountDAOImpl;
import dao.interfaces.AccountDAO;
import dto.TotalAccount;
import dto.UserDTO;
import entities.Account;
import entities.User;
import services.interfaces.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static final int FIRST_ELEMENT = 1;

    private AccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
    }

    @Override
    public List<Account> findUserAccounts(User user) {
        return accountDAO.findAccountsByUser(user);
    }

    @Override
    public TotalAccount findMaxTotalAccountSum() {
        //final Account TOTAL_ACCOUNT = accountDAO.findTotalSumOfUserAccount();
        List<Account> accounts = accountDAO.findTotalSumOfUserAccount();

        Account maxAccount = accounts.get(FIRST_ELEMENT);

        for (Account account : accounts) {
            if (account.getAccount() > maxAccount.getAccount()) {
                maxAccount = account;
            }
        }

        return new TotalAccount(
                maxAccount.getAccount(),
                new UserDTO(
                        maxAccount.getUser().getUserId(),
                        maxAccount.getUser().getName(),
                        maxAccount.getUser().getSureName()
                )
        );
    }
}
