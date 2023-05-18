package kg.bank.payments.service.impl;

import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.enums.ServiceJobStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.model.entity.SubPayment;
import kg.bank.payments.model.xml.Body;
import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.repository.AccountRepository;
import kg.bank.payments.repository.PaymentRepository;
import kg.bank.payments.repository.ServiceJobRepository;
import kg.bank.payments.repository.SubPaymentRepository;
import kg.bank.payments.service.PaymentService;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final ServiceJobRepository serviceJobRepository;
    private final PaymentRepository paymentRepository;
    private final AccountRepository accountRepository;
    private final SubPaymentRepository subPaymentRepository;

    public PaymentServiceImpl(ServiceJobRepository serviceJobRepository,
                              PaymentRepository paymentRepository,
                              AccountRepository accountRepository,
                              SubPaymentRepository subPaymentRepository) {
        this.serviceJobRepository = serviceJobRepository;
        this.paymentRepository = paymentRepository;
        this.accountRepository = accountRepository;
        this.subPaymentRepository = subPaymentRepository;
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
    public Payment pay(XmlData request) {
        Long serviceId = Long.parseLong(request.getBody().getServiceId());
        Optional<ServiceJob> optionalServiceJob = serviceJobRepository.findById(serviceId);

        if (optionalServiceJob.isEmpty()) {
//            return getResponse(request, "420", null,"Лицевой счет не найден");
            return null;
        }

        ServiceJob serviceJob = optionalServiceJob.get();

        if (serviceJob.getStatus() == ServiceJobStatus.ACTIVE) {
            //To do async
            System.out.println("============To do async============");
            BigDecimal sum = new BigDecimal(request.getBody().getSum());
            String phone = request.getBody().getParam1();

            // Start the clock
            long start = System.currentTimeMillis();

            Payment payment = acceptPayment(serviceId, sum, phone, request);// 0ms
//                distributePaymentToAccounts(serviceId, sum, payment);
//                distributePaymentToAccounts(serviceId, sum, phone); // 10ms

            System.out.println("=========Elapsed time: " + (System.currentTimeMillis() - start));
//                XmlData response = XmlData.builder()
//                        .head(request.getHead())
//                        .body(Body.builder()
//                                .status("250")
//                                .msg("Платеж успешно проведен")
//                                .build())
//                        .build();
//                return response;
//            }
//            catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
            return payment;
//        return getResponse(request, "424", null, "Сервис временно недоступен");
        }
        return null;
    }

//    @Override
//    public XmlData execute(XmlData request) {
//        String op = request.getHead().getOp();
//        if (op.equals("QE11")) {
//            return check(request);
//        } else if (op.equals("QE10")) {
//            return pay(request);
//        }
//        return null;
//    }

//    private XmlData getResponsePayment(XmlData request, ServiceJob serviceJob) {
//
//        /*
//            Весь этот код перенести в  pay()
//         */
//        if (serviceJob.getStatus() == ServiceJobStatus.ACTIVE) {
//            //To do async
//            System.out.println("============To do async============");
//            long serviceId = Long.parseLong(request.getBody().getServiceId());
//            BigDecimal sum = new BigDecimal(request.getBody().getSum());
//            String phone = request.getBody().getParam1();
//
//            // Start the clock
//            long start = System.currentTimeMillis();
//
//            try {
//                XmlData response = acceptPayment(serviceId, sum, phone, request);// 0ms
////                distributePaymentToAccounts(serviceId, sum, phone); // 10ms
//                System.out.println("=========Elapsed time: " + (System.currentTimeMillis() - start));
//                return response;
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return getResponse(request, "424", null, "Сервис временно недоступен");
//    }
    public Payment acceptPayment(Long id, BigDecimal sum,
                                 String phone,
                                 XmlData request) {

        // Обработка оплаты
        System.out.println("Start acceptPayment ");

        Payment payment = Payment.builder()
                .postMoney(sum)
                .distributedMoney(sum)
                .phone(phone)
                .status(PaymentStatus.OK)
                .created(new Date())
                .serviceJob(serviceJobRepository.findById(id).get())
                .build();

        payment = paymentRepository.save(payment);

        System.out.println("Finish acceptPayment ");
//        return response;
        return payment;
    }

    @Async
    public void distributePaymentToAccounts(Long id, BigDecimal sum, Payment payment) throws InterruptedException {
        // Распределение суммы на несколько аккаунтов
        System.out.println("Start distributePaymentToAccounts ");

        ServiceJob serviceJob = serviceJobRepository.findById(id)
            .orElseThrow(
    () -> new IllegalArgumentException("Сервис не найден.")
            );

        Thread.sleep(3000L);
        serviceJob.getServiceJobDetailList()
            .forEach(serviceJobDetail -> {
                Account account = serviceJobDetail.getAccount();

                BigDecimal percentSum = serviceJobDetail.getPercentSum();
                BigDecimal percentUnit = percentSum.divide(new BigDecimal(100));
                BigDecimal calcSum = sum.multiply(percentUnit);
                account.setBalance(account.getBalance().add(calcSum));
                account = accountRepository.save(account);

                SubPayment subPayment = SubPayment.builder()
                        .account(account)
                        .payment(payment)
                        .sum(calcSum)
                        .status(PaymentStatus.OK)
                        .created(new Date())
                        .build();

                subPaymentRepository.save(subPayment);
            });


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
