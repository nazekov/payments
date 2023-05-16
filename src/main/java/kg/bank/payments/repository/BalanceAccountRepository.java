package kg.bank.payments.repository;

import kg.bank.payments.model.entity.account.BalanceAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceAccountRepository extends JpaRepository<BalanceAccount, Long> {

}
