package kg.bank.payments.repository;

import kg.bank.payments.model.entity.serviceId.StatusServiceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusServiceJobRepository extends JpaRepository<StatusServiceJob, Long> {


}
