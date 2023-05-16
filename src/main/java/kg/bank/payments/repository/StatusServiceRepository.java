package kg.bank.payments.repository;

import kg.bank.payments.model.entity.serviceId.StatusService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusServiceRepository extends JpaRepository<StatusService, Long> {


}
