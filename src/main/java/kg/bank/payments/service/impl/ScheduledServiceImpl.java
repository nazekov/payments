package kg.bank.payments.service.impl;

import kg.bank.payments.service.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServiceImpl implements ScheduledService {



    private static final Logger log = LoggerFactory.getLogger(ScheduledServiceImpl.class);

    @Scheduled(fixedRate = 5000)
    @Override
    public void periodicTask() {

    }
}
