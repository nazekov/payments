package kg.bank.payments.repository;

import kg.bank.payments.model.entity.ServiceJobDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceJobDetailRepository extends JpaRepository<ServiceJobDetail, Long> {

}
