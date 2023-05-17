package kg.bank.payments.service.impl;

import kg.bank.payments.model.entity.serviceId.ServiceJob;
import kg.bank.payments.model.xml.Body;
import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.repository.ServiceJobRepository;
import kg.bank.payments.service.PaymentService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final ServiceJobRepository serviceJobRepository;

    public PaymentServiceImpl(ServiceJobRepository serviceJobRepository) {
        this.serviceJobRepository = serviceJobRepository;
    }

    @Override
    public XmlData checkPayment(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = serviceJobRepository.findById(serviceId);
        return optionalServiceJob.isPresent() ?
                            getResponseOk(request) :
                            getResponseBad(request);
    }

    private XmlData getResponseBad(XmlData request) {
        return XmlData.builder()
                .head(request.getHead())
                .body(Body.builder()
                        .status("420")
                        .errMsg("Лицевой счет не найден")
                        .build())
                .build();
    }

    private XmlData getResponseOk(XmlData request) {
        return XmlData.builder()
                .head(request.getHead())
                .body(Body.builder().status("200").build())
                .build();
    }
}
