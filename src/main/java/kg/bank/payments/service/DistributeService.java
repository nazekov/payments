package kg.bank.payments.service;

import kg.bank.payments.model.entity.Payment;
import java.math.BigDecimal;

public interface DistributeService {

    void distributePaymentToAccounts(Long id, BigDecimal sum, Payment payment);
}
