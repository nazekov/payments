package kg.bank.payments.service;

import kg.bank.payments.model.entity.ServiceJob;

import java.util.Optional;

public interface ServiceJobService {

    Optional<ServiceJob> findById(Long id);
}
