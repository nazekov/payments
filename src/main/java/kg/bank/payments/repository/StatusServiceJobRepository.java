package kg.bank.payments.repository;

import kg.bank.payments.model.entity.serviceId.StatusServiceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.Optional;

@Repository
public interface StatusServiceJobRepository extends JpaRepository<StatusServiceJob, Long> {

    @Query("FROM StatusServiceJob s " +
            "WHERE s.serviceJob.id = ?1 and s.endDate = ?2 ")
    Optional<StatusServiceJob> findByServiceIdAndEndDate(Long id, Date date);
}
