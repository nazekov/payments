package kg.bank.payments.repository;

import kg.bank.payments.enums.AccountStatus;
import kg.bank.payments.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByStatus(AccountStatus active);
}
