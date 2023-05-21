package kg.bank.payments.service.impl;

import kg.bank.payments.enums.PaymentStatus;
import kg.bank.payments.model.entity.Account;
import kg.bank.payments.model.entity.SubPayment;
import kg.bank.payments.service.AccountService;
import kg.bank.payments.service.ScheduledService;
import kg.bank.payments.service.SubPaymentService;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        for (Account account : accountService.getAllActiveAccounts()) {
            List<SubPayment> subPaymentList = account.getSubPaymentList();
            for (SubPayment subPayment : subPaymentList) {
                if (subPayment.getStatus() == PaymentStatus.CREATED) {
                    subPaymentService.processSubPayment(subPayment);
                }
            }
        }
//        Hibernate.initialize(accountService.getAllActiveAccounts());
//        accountService.getAllActiveAccounts()
//            .stream()
//            .flatMap(account -> account.getSubPaymentList().stream())
//            .filter(subPayment -> subPayment.getStatus() == PaymentStatus.CREATED)
//            .forEach(subPaymentService::processSubPayment);
        log.info("-------Finish Scheduled subPayment--------");
    }
}
