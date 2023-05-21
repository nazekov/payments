package kg.bank.payments.service;

import kg.bank.payments.model.entity.SubPayment;

public interface SubPaymentService {

    void processSubPayment(SubPayment subPayment);

    SubPayment save(SubPayment subPayment);
}
