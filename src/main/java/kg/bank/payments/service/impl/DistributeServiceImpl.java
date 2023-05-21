package kg.bank.payments.service.impl;

import kg.bank.payments.enums.AccountStatus;
import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.model.entity.SubPayment;
import kg.bank.payments.service.AccountService;
import kg.bank.payments.service.DistributeService;
import kg.bank.payments.service.ServiceJobService;
import kg.bank.payments.service.SubPaymentService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class DistributeServiceImpl implements DistributeService {

    private static final Logger log = LoggerFactory.getLogger(DistributeServiceImpl.class);
    private final AccountService accountService;
    private final SubPaymentService subPaymentService;
    private final ServiceJobService jobService;

    public DistributeServiceImpl(
            AccountService accountService,
            SubPaymentService subPaymentService,
            ServiceJobService jobService) {
        this.accountService = accountService;
        this.subPaymentService = subPaymentService;
        this.jobService = jobService;
    }

    @Transactional
    @Async
    @SneakyThrows
    @Override
    public void distributePaymentToAccounts(ServiceJob serviceJob, BigDecimal sum, Payment payment) {
        log.info("Start distributePaymentToAccounts ");
        log.info("============To do Async============");
        long start = System.currentTimeMillis();

        serviceJob.getServiceJobDetailList().forEach(serviceJobDetail -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Account account = serviceJobDetail.getAccount();

            PaymentStatus paymentStatus = PaymentStatus.CREATED;

            BigDecimal percentSum = serviceJobDetail.getPercentSum();
            BigDecimal percentUnit = percentSum.divide(new BigDecimal(100));
            BigDecimal calcSum = sum.multiply(percentUnit);

            if (account.getStatus() == AccountStatus.ACTIVE) {
                account.setBalance(account.getBalance().add(calcSum));
                account = accountService.save(account);
                paymentStatus = PaymentStatus.DONE;
            }

            SubPayment subPayment = SubPayment.builder()
                    .account(account)
                    .payment(payment)
                    .sum(calcSum)
                    .status(paymentStatus)
                    .created(new Date())
                    .build();

            subPaymentService.save(subPayment);
        });
        log.info("=========Elapsed time Async: " + (System.currentTimeMillis() - start));
        log.info("Finish distributePaymentToAccounts ");
    }
}
