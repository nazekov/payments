package kg.bank.payments.service;

import kg.bank.payments.model.xml.XmlData;

public interface PaymentService {

    XmlData checkPayment(XmlData request);
}
