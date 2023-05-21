package kg.bank.payments.service.impl;

import kg.bank.payments.enums.AccountStatus;
import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.SubPayment;
import kg.bank.payments.repository.SubPaymentRepository;
import kg.bank.payments.service.AccountService;
import kg.bank.payments.service.SubPaymentService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubPaymentServiceImpl implements SubPaymentService {

    private static final Logger log = LoggerFactory.getLogger(SubPaymentServiceImpl.class);
    private final SubPaymentRepository subPaymentRepository;
    private final AccountService accountService;

    public SubPaymentServiceImpl(SubPaymentRepository subPaymentRepository,
                                 AccountService accountService) {
        this.subPaymentRepository = subPaymentRepository;
        this.accountService = accountService;
    }

    @SneakyThrows
    @Override
    public void processSubPayment(SubPayment subPayment) {
        log.info("-----Start to Changing Status subPayment to PROCESSING");
        subPayment.setStatus(PaymentStatus.PROCESSING);
        subPayment = subPaymentRepository.save(subPayment);
        log.info("-----Changed Status subPayment to PROCESSING");

        //исскусственная задержка времени для примера долгого обновления баланса аккаунта
        Thread.sleep(5000L);

        Account account = accountService.updateAccountBalance(subPayment);
        if (account.getStatus() == AccountStatus.ACTIVE) {
            subPayment.setStatus(PaymentStatus.DONE);
            subPaymentRepository.save(subPayment);
            log.info("-----Changed Status subPayment to DONE");
        }
    }

    @Override
    public SubPayment save(SubPayment subPayment) {
        return subPaymentRepository.save(subPayment);
    }
}
