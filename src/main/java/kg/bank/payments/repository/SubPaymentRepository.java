package kg.bank.payments.repository;

import kg.bank.payments.model.entity.SubPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubPaymentRepository extends JpaRepository<SubPayment, Long> {

}
