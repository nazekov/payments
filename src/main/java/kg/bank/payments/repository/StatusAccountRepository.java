package kg.bank.payments.repository;

import kg.bank.payments.model.entity.account.StatusAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusAccountRepository extends JpaRepository<StatusAccount, Long> {

}
