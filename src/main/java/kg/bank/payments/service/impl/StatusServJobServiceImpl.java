package kg.bank.payments.service.impl;

import kg.bank.payments.enums.ServiceJobState;
import kg.bank.payments.model.entity.serviceId.StatusServiceJob;
import kg.bank.payments.repository.StatusServiceJobRepository;
import kg.bank.payments.service.StatusServJobService;
import kg.bank.payments.utils.DateUtil;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class StatusServJobServiceImpl implements StatusServJobService {

    private final StatusServiceJobRepository statusServiceJobRepository;

    public StatusServJobServiceImpl(StatusServiceJobRepository statusServiceJobRepository) {
        this.statusServiceJobRepository = statusServiceJobRepository;
    }

    @Override
    public StatusServiceJob findByIdAndEndDate(Long id, Date date) {
        return statusServiceJobRepository.findByServiceIdAndEndDate(id, date)
                .orElseThrow(
        () -> new IllegalArgumentException("Status not found")
                );
    }

    @Override
    public boolean isActiveNow(Long id) {
        StatusServiceJob statusServiceJob
            = findByIdAndEndDate(id, DateUtil.getInstance().getEndDate());
        return statusServiceJob.getState() == ServiceJobState.ACTIVE;
    }
}
