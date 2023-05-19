package kg.bank.payments.service.impl;

import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.model.entity.SubPayment;
import kg.bank.payments.repository.AccountRepository;
import kg.bank.payments.repository.PaymentRepository;
import kg.bank.payments.repository.ServiceJobRepository;
import kg.bank.payments.repository.SubPaymentRepository;
import kg.bank.payments.service.DistributeService;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class DistributeServiceImpl implements DistributeService {

    private final ServiceJobRepository serviceJobRepository;
    private final AccountRepository accountRepository;
    private final SubPaymentRepository subPaymentRepository;

    public DistributeServiceImpl(ServiceJobRepository serviceJobRepository,
                                 AccountRepository accountRepository,
                                 SubPaymentRepository subPaymentRepository) {
        this.serviceJobRepository = serviceJobRepository;
        this.accountRepository = accountRepository;
        this.subPaymentRepository = subPaymentRepository;
    }

    @Transactional
    @Async
    @SneakyThrows
    @Override
    public void distributePaymentToAccounts(Long id, BigDecimal sum, Payment payment) {
        System.out.println("Start distributePaymentToAccounts ");
        ServiceJob serviceJob = serviceJobRepository.findById(id)
            .orElseThrow(
                    () -> new IllegalArgumentException("Сервис не найден.")
            );
        System.out.println("============To do Async============");
        long start = System.currentTimeMillis();

        serviceJob.getServiceJobDetailList().forEach(serviceJobDetail -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
        System.out.println("=========Elapsed time Async: " + (System.currentTimeMillis() - start));
        System.out.println("Finish distributePaymentToAccounts ");
    }
}
