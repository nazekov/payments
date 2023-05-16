package kg.bank.payments.repository;

import kg.bank.payments.model.entity.ServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Long> {


}
