package kg.bank.payments.service.impl;

import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.service.AccountService;
import kg.bank.payments.service.ScheduledService;
import kg.bank.payments.service.SubPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledServiceImpl.class);
    private final AccountService accountService;
    private final SubPaymentService subPaymentService;

    public ScheduledServiceImpl(AccountService accountService,
                                SubPaymentService subPaymentService) {
        this.accountService = accountService;
        this.subPaymentService = subPaymentService;
    }

    @Scheduled(fixedDelay = 5000)
    @Override
    public void checkSubPayments() {
        log.info("-------Start Scheduled subPayment--------");
        accountService.getAllActiveAccounts()
            .stream()
            .flatMap(account -> account.getSubPaymentList().stream())
            .filter(subPayment -> subPayment.getStatus() == PaymentStatus.CREATED)
            .peek(subPayment ->  subPaymentService.processSubPayment(subPayment));
        log.info("-------Start Scheduled subPayment--------");
    }
}
