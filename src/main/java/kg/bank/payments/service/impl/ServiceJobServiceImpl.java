package kg.bank.payments.service.impl;

import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.repository.ServiceJobRepository;
import kg.bank.payments.service.ServiceJobService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceJobServiceImpl implements ServiceJobService {

    private final ServiceJobRepository serviceJobRepository;

    public ServiceJobServiceImpl(ServiceJobRepository serviceJobRepository) {
        this.serviceJobRepository = serviceJobRepository;
    }

    @Override
    public Optional<ServiceJob> findById(Long id) {
        return serviceJobRepository.findById(id);
    }
}
