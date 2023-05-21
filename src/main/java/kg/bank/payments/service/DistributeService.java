package kg.bank.payments.service;

import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.entity.ServiceJob;
import java.math.BigDecimal;

public interface DistributeService {

    void distributePaymentToAccounts(ServiceJob serviceJob, BigDecimal sum, Payment payment);
}
