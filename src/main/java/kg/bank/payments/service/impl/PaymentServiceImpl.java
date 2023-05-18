package kg.bank.payments.service.impl;

import kg.bank.payments.enums.ServiceJobStatus;
import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.model.xml.Body;
import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.repository.ServiceJobRepository;
import kg.bank.payments.service.PaymentService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final ServiceJobRepository serviceJobRepository;

    public PaymentServiceImpl(ServiceJobRepository serviceJobRepository) {
        this.serviceJobRepository = serviceJobRepository;
    }

    @Override
    public XmlData check(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = serviceJobRepository.findById(serviceId);
        return optionalServiceJob.isPresent() ?
                getResponse(request, "200", null, null) :
                getResponse(request, "420", null, "Лицевой счет не найден");
    }

    @Override
    public XmlData pay(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = serviceJobRepository.findById(serviceId);

        if (optionalServiceJob.isEmpty()) {
             return getResponse(request, "420", null,"Лицевой счет не найден");
        }

        return getResponsePayment(request, optionalServiceJob.get());
    }

    @Override
    public XmlData execute(XmlData request) {
        String op = request.getHead().getOp();
        if (op.equals("QE11")) {
            return check(request);
        } else if (op.equals("QE10")) {
            return pay(request);
        }
        return null;
    }

    private XmlData getResponsePayment(XmlData request, ServiceJob serviceJob) {

        /*
            Весь этот код перенести в  pay()
         */

        if (serviceJob.getStatus() == ServiceJobStatus.ACTIVE) {
            //To do async
            System.out.println("============To do async============");
            long serviceId = Long.parseLong(request.getBody().getServiceId());
            BigDecimal sum = new BigDecimal(request.getBody().getSum());
            String phone = request.getBody().getParam1();

            // Start the clock
            long start = System.currentTimeMillis();

            try {
                acceptPayment(serviceId, sum, phone); // 10ms
                distributePaymentToAccounts(serviceId, sum, phone); // 0ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("=========Elapsed time: " + (System.currentTimeMillis() - start));

            return null;
        }
        return getResponse(request, "424", null, "Сервис временно недоступен");
    }

    public void acceptPayment(Long id, BigDecimal sum, String phone)
                                                throws InterruptedException {

        // Обработка оплаты
        System.out.println("Start acceptPayment ");
//        Thread.sleep(2000L);

        System.out.println("Finish acceptPayment ");
//        return CompletableFuture.completedFuture(null);
    }

    @Async //только этот метод асинхронный
    public void distributePaymentToAccounts(Long id, BigDecimal sum, String phone)
            throws InterruptedException {

        // Распределение суммы на несколько аккаунтов
        System.out.println("Start distributePaymentToAccounts ");
        Thread.sleep(5000L);
        System.out.println("Finish distributePaymentToAccounts ");
    }

    private XmlData getResponse(XmlData request, String code,
                                String msg, String errMsg) {
        return XmlData.builder()
                .head(request.getHead())
                .body(Body.builder()
                        .status(code)
                        .msg(msg)
                        .errMsg(errMsg)
                        .build())
                .build();
    }
}
