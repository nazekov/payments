package kg.bank.payments.service;

import kg.bank.payments.model.entity.serviceId.StatusServiceJob;
import java.util.Date;
import java.util.Optional;

public interface StatusServJobService {

    StatusServiceJob findByIdAndEndDate(Long id, Date date);

    boolean isActiveNow(Long id);
}
