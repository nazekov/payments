package kg.bank.payments.service;

import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.xml.XmlData;

import java.math.BigDecimal;

public interface PaymentService {

    XmlData check(XmlData request);

    Payment pay(XmlData request);

//    XmlData execute(XmlData request);
    void distributePaymentToAccounts(Long id, BigDecimal sum, Payment payment) throws InterruptedException;
}
