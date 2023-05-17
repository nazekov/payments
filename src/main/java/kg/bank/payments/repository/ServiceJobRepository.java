package kg.bank.payments.repository;

import kg.bank.payments.model.entity.ServiceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceJobRepository extends JpaRepository<ServiceJob, Long> {

}
