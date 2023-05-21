package kg.bank.payments.service.impl;

import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.enums.ServiceJobStatus;
import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.model.xml.Body;
import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.repository.PaymentRepository;
import kg.bank.payments.service.DistributeService;
import kg.bank.payments.service.PaymentService;
import kg.bank.payments.service.ServiceJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private final ServiceJobService jobService;
    private final PaymentRepository paymentRepository;
    private final DistributeService distributeService;

    public PaymentServiceImpl(ServiceJobService jobService,
                                PaymentRepository paymentRepository,
                                DistributeService distributeService) {
        this.jobService = jobService;
        this.paymentRepository = paymentRepository;
        this.distributeService = distributeService;
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

    @Override
    public XmlData check(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = jobService.findById(serviceId);
        return optionalServiceJob.isPresent() ?
                getResponse(request, "200", null, null) :
                getResponse(request, "420", null, "Лицевой счет не найден");
    }

    @Override
    public XmlData pay(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = jobService.findById(serviceId);

        if (optionalServiceJob.isEmpty()) {
            return getResponse(request, "420", null,"Лицевой счет не найден");
        }
        //ServiceJob serviceJob = optionalServiceJob.get();

       // if (serviceJob.getStatus() == ServiceJobStatus.ACTIVE) {
            log.info("============To do pay(============");
            BigDecimal sum = new BigDecimal(request.getBody().getSum());
            String phone = request.getBody().getParam1();

            // Start the clock
            long start = System.currentTimeMillis();

            Payment payment = acceptPayment(serviceId, sum, phone);// 10ms
            distributeService.distributePaymentToAccounts(serviceId, sum, payment);

            log.info("=========Elapsed time: " + (System.currentTimeMillis() - start));

            return XmlData.builder()
                    .head(request.getHead())
                    .body(Body.builder()
                            .status("250")
                            .msg("Платеж успешно проведен")
                            .build())
                    .build();
        //}
//        return getResponse(request, "424", null, "Сервис временно недоступен");
    }

    // Обработка оплаты
    public Payment acceptPayment(Long id, BigDecimal sum, String phone) {
        Payment payment = Payment.builder()
                .postMoney(sum)
                .distributedMoney(sum)
                .phone(phone)
                .status(PaymentStatus.DONE)
                .created(new Date())
                .serviceJob(jobService.findById(id).get())
                .build();
        return paymentRepository.save(payment);
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
