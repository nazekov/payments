package kg.bank.payments.service;

import kg.bank.payments.model.xml.XmlData;

public interface PaymentService {

    XmlData check(XmlData request);

    XmlData pay(XmlData request);
}
