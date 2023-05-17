package kg.bank.payments.service.impl;

import kg.bank.payments.model.entity.serviceId.ServiceJob;
import kg.bank.payments.model.xml.Body;
import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.repository.ServiceJobRepository;
import kg.bank.payments.service.PaymentService;
import kg.bank.payments.service.StatusServJobService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final ServiceJobRepository serviceJobRepository;

    private final StatusServJobService statusServJobService;

    public PaymentServiceImpl(ServiceJobRepository serviceJobRepository,
                              StatusServJobService statusServJobService) {
        this.serviceJobRepository = serviceJobRepository;
        this.statusServJobService = statusServJobService;
    }

    @Override
    public XmlData check(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = serviceJobRepository.findById(serviceId);
        return optionalServiceJob.isPresent() ?
                getResponseOk(request, "200", null) :
                getResponseBad(request, "420", "Лицевой счет не найден");
    }

    @Override
    public XmlData pay(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = serviceJobRepository.findById(serviceId);

        if (optionalServiceJob.isEmpty()) {
             return getResponseBad(request, "420", "Лицевой счет не найден");
        }

        getResponseTransfer(request, optionalServiceJob.get());
        return null;
    }

    private XmlData getResponseTransfer(XmlData request, ServiceJob serviceJob) {

        /*
            Весь этот код перенести в  pay()
         */

        if (statusServJobService.isActiveNow(serviceJob.getId())) {
            //To do async
            System.out.println("============To do async============");
            long serviceId = Long.parseLong(request.getBody().getServiceId());
            BigDecimal sum = new BigDecimal(request.getBody().getSum());
            String phone = request.getBody().getParam1();

            // Start the clock
            long start = System.currentTimeMillis();

            try {
                acceptPayment(sum); // 10ms
                distributePaymentToAccounts(sum); // 0ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("=========Elapsed time: " + (System.currentTimeMillis() - start));

            return null;
        }
        return getResponseBad(request, "424", "Сервис временно недоступен");
    }

    public void acceptPayment(BigDecimal amount) throws InterruptedException {

        // Обработка оплаты
        System.out.println("Start acceptPayment ");
        Thread.sleep(2000L);
        System.out.println("Finish acceptPayment ");
//        return CompletableFuture.completedFuture(null);
    }

    @Async //только этот метод асинхронный
    public void distributePaymentToAccounts(BigDecimal amount)
            throws InterruptedException {

        // Распределение суммы на несколько аккаунтов
        System.out.println("Start distributePaymentToAccounts ");
        Thread.sleep(5000L);
        System.out.println("Finish distributePaymentToAccounts ");
//        return CompletableFuture.completedFuture(null);
    }

    /**
     *
     * Объединить логику два метода getResponseBad и getResponseOk
     */
    private XmlData getResponseBad(XmlData request, String code, String msg) {
        return XmlData.builder()
                .head(request.getHead())
                .body(Body.builder()
                        .status(code)
                        .errMsg(msg)
                        .build())
                .build();
    }

    private XmlData getResponseOk(XmlData request, String code, String msg) {
        return XmlData.builder()
                .head(request.getHead())
                .body(Body.builder().status(code).msg(msg).build())
                .build();
    }
}
