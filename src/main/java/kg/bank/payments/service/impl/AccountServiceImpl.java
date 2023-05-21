package kg.bank.payments.service.impl;

import kg.bank.payments.enums.AccountStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.SubPayment;
import kg.bank.payments.repository.AccountRepository;
import kg.bank.payments.service.AccountService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccountBalance(SubPayment subPayment) {
        Account account = subPayment.getAccount();
        BigDecimal newBalance = account.getBalance().add(subPayment.getSum());
        account.setBalance(newBalance);
        accountRepository.save(account);
        return account;
    }

    @Override
    public List<Account> getAllActiveAccounts() {
        return accountRepository.findByStatus(AccountStatus.ACTIVE);
    }
}
