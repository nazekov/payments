package kg.bank.payments.service;

import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.SubPayment;
import java.util.List;

public interface AccountService {

    Account save(Account account);

    Account updateAccountBalance(SubPayment subPayment);

    List<Account> getAllActiveAccounts();
}
