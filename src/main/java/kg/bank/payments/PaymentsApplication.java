package kg.bank.payments;

import kg.bank.payments.enums.AccountState;
import kg.bank.payments.enums.ServiceState;
import kg.bank.payments.model.entity.ServiceDetail;
import kg.bank.payments.model.entity.account.BalanceAccount;
import kg.bank.payments.model.entity.account.StatusAccount;
import kg.bank.payments.model.entity.serviceId.StatusService;
import kg.bank.payments.repository.*;
import kg.bank.payments.utils.DateUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

//	@Bean
	public CommandLineRunner run(ServiceRepository serviceRepository,
								 StatusServiceRepository statusServiceRepository,
								 AccountRepository accountRepository,
								 StatusAccountRepository statusAccountRepository,
								 ServiceDetailRepository serviceDetailRepository,
								 BalanceAccountRepository balanceAccountRepository) {
		return args -> {
//			extracted1(statusServiceRepository, serviceRepository);
//			extracted2(accountRepository, statusAccountRepository);
//			extracted3(serviceRepository, accountRepository, serviceDetailRepository);
//			extracted4(serviceRepository, accountRepository, serviceDetailRepository);
//			extracted5(serviceRepository, accountRepository, serviceDetailRepository);
//			extracted6(accountRepository, balanceAccountRepository);
		};
	}

	private static void extracted6(AccountRepository accountRepository,
								   BalanceAccountRepository balanceAccountRepository) {
		for (long i = 1; i <= 10; i++) {
			BalanceAccount balanceAccount = new BalanceAccount();
			balanceAccount.setAccount(accountRepository.findById(i).get());
			balanceAccount.setBalance(new BigDecimal(0));
			balanceAccountRepository.save(balanceAccount);
		}
	}

	private static void extracted5(ServiceRepository serviceRepository,
								   AccountRepository accountRepository,
								   ServiceDetailRepository serviceDetailRepository) {
		ServiceDetail serviceDetail3_1 = new ServiceDetail();
		serviceDetail3_1.setService(serviceRepository.findById(3L).get());
		serviceDetail3_1.setAccount(accountRepository.findById(1L).get());
		serviceDetail3_1.setPercentSum(new BigDecimal(15));
		serviceDetail3_1.setStartDate(new Date());
		serviceDetail3_1.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail3_2 = new ServiceDetail();
		serviceDetail3_2.setService(serviceRepository.findById(3L).get());
		serviceDetail3_2.setAccount(accountRepository.findById(2L).get());
		serviceDetail3_2.setPercentSum(new BigDecimal(15));
		serviceDetail3_2.setStartDate(new Date());
		serviceDetail3_2.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail3_3 = new ServiceDetail();
		serviceDetail3_3.setService(serviceRepository.findById(3L).get());
		serviceDetail3_3.setAccount(accountRepository.findById(3L).get());
		serviceDetail3_3.setPercentSum(new BigDecimal(7));
		serviceDetail3_3.setStartDate(new Date());
		serviceDetail3_3.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail3_4 = new ServiceDetail();
		serviceDetail3_4.setService(serviceRepository.findById(3L).get());
		serviceDetail3_4.setAccount(accountRepository.findById(4L).get());
		serviceDetail3_4.setPercentSum(new BigDecimal(12));
		serviceDetail3_4.setStartDate(new Date());
		serviceDetail3_4.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail3_5 = new ServiceDetail();
		serviceDetail3_5.setService(serviceRepository.findById(3L).get());
		serviceDetail3_5.setAccount(accountRepository.findById(9L).get());
		serviceDetail3_5.setPercentSum(new BigDecimal(33));
		serviceDetail3_5.setStartDate(new Date());
		serviceDetail3_5.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail3_6 = new ServiceDetail();
		serviceDetail3_6.setService(serviceRepository.findById(3L).get());
		serviceDetail3_6.setAccount(accountRepository.findById(10L).get());
		serviceDetail3_6.setPercentSum(new BigDecimal(18));
		serviceDetail3_6.setStartDate(new Date());
		serviceDetail3_6.setEndDate(DateUtil.getInstance().getEndDate());

		List<ServiceDetail> list3 = Arrays.asList(
				serviceDetail3_1, serviceDetail3_2, serviceDetail3_3,
				serviceDetail3_4, serviceDetail3_5, serviceDetail3_6
		);

		serviceDetailRepository.saveAll(list3);
	}

	private static void extracted4(ServiceRepository serviceRepository,
								   AccountRepository accountRepository,
								   ServiceDetailRepository serviceDetailRepository) {
		ServiceDetail serviceDetail2_1 = new ServiceDetail();
		serviceDetail2_1.setService(serviceRepository.findById(2L).get());
		serviceDetail2_1.setAccount(accountRepository.findById(1L).get());
		serviceDetail2_1.setPercentSum(new BigDecimal(10));
		serviceDetail2_1.setStartDate(new Date());
		serviceDetail2_1.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail2_2 = new ServiceDetail();
		serviceDetail2_2.setService(serviceRepository.findById(2L).get());
		serviceDetail2_2.setAccount(accountRepository.findById(2L).get());
		serviceDetail2_2.setPercentSum(new BigDecimal(11));
		serviceDetail2_2.setStartDate(new Date());
		serviceDetail2_2.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail2_3 = new ServiceDetail();
		serviceDetail2_3.setService(serviceRepository.findById(2L).get());
		serviceDetail2_3.setAccount(accountRepository.findById(3L).get());
		serviceDetail2_3.setPercentSum(new BigDecimal(5));
		serviceDetail2_3.setStartDate(new Date());
		serviceDetail2_3.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail2_4 = new ServiceDetail();
		serviceDetail2_4.setService(serviceRepository.findById(2L).get());
		serviceDetail2_4.setAccount(accountRepository.findById(4L).get());
		serviceDetail2_4.setPercentSum(new BigDecimal(8));
		serviceDetail2_4.setStartDate(new Date());
		serviceDetail2_4.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail2_5 = new ServiceDetail();
		serviceDetail2_5.setService(serviceRepository.findById(2L).get());
		serviceDetail2_5.setAccount(accountRepository.findById(7L).get());
		serviceDetail2_5.setPercentSum(new BigDecimal(33));
		serviceDetail2_5.setStartDate(new Date());
		serviceDetail2_5.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail2_6 = new ServiceDetail();
		serviceDetail2_6.setService(serviceRepository.findById(2L).get());
		serviceDetail2_6.setAccount(accountRepository.findById(8L).get());
		serviceDetail2_6.setPercentSum(new BigDecimal(33));
		serviceDetail2_6.setStartDate(new Date());
		serviceDetail2_6.setEndDate(DateUtil.getInstance().getEndDate());

		List<ServiceDetail> list2 = Arrays.asList(
				serviceDetail2_1, serviceDetail2_2, serviceDetail2_3,
				serviceDetail2_4, serviceDetail2_5, serviceDetail2_6
		);

		serviceDetailRepository.saveAll(list2);
	}

	private static void extracted3(ServiceRepository serviceRepository,
								   AccountRepository accountRepository,
								   ServiceDetailRepository serviceDetailRepository) {
		ServiceDetail serviceDetail1_1 = new ServiceDetail();
		serviceDetail1_1.setService(serviceRepository.findById(1L).get());
		serviceDetail1_1.setAccount(accountRepository.findById(1L).get());
		serviceDetail1_1.setPercentSum(new BigDecimal(13));
		serviceDetail1_1.setStartDate(new Date());
		serviceDetail1_1.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail1_2 = new ServiceDetail();
		serviceDetail1_2.setService(serviceRepository.findById(1L).get());
		serviceDetail1_2.setAccount(accountRepository.findById(2L).get());
		serviceDetail1_2.setPercentSum(new BigDecimal(5));
		serviceDetail1_2.setStartDate(new Date());
		serviceDetail1_2.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail1_3 = new ServiceDetail();
		serviceDetail1_3.setService(serviceRepository.findById(1L).get());
		serviceDetail1_3.setAccount(accountRepository.findById(3L).get());
		serviceDetail1_3.setPercentSum(new BigDecimal(2));
		serviceDetail1_3.setStartDate(new Date());
		serviceDetail1_3.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail1_4 = new ServiceDetail();
		serviceDetail1_4.setService(serviceRepository.findById(1L).get());
		serviceDetail1_4.setAccount(accountRepository.findById(4L).get());
		serviceDetail1_4.setPercentSum(new BigDecimal(20));
		serviceDetail1_4.setStartDate(new Date());
		serviceDetail1_4.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail1_5 = new ServiceDetail();
		serviceDetail1_5.setService(serviceRepository.findById(1L).get());
		serviceDetail1_5.setAccount(accountRepository.findById(5L).get());
		serviceDetail1_5.setPercentSum(new BigDecimal(30));
		serviceDetail1_5.setStartDate(new Date());
		serviceDetail1_5.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceDetail serviceDetail1_6 = new ServiceDetail();
		serviceDetail1_6.setService(serviceRepository.findById(1L).get());
		serviceDetail1_6.setAccount(accountRepository.findById(6L).get());
		serviceDetail1_6.setPercentSum(new BigDecimal(30));
		serviceDetail1_6.setStartDate(new Date());
		serviceDetail1_6.setEndDate(DateUtil.getInstance().getEndDate());

		List<ServiceDetail> list1 = Arrays.asList(
				serviceDetail1_1, serviceDetail1_2, serviceDetail1_3,
				serviceDetail1_4, serviceDetail1_5, serviceDetail1_6
		);

		serviceDetailRepository.saveAll(list1);
	}

	private static void extracted2(AccountRepository accountRepository,
								   StatusAccountRepository statusAccountRepository) {
		for (long i = 1; i <= 10; i++) {
			StatusAccount statusAccount = new StatusAccount();
			statusAccount.setAccountState(AccountState.ACTIVE);
			statusAccount.setStartDate(new Date());
			statusAccount.setEndDate(DateUtil.getInstance().getEndDate());
			statusAccount.setAccount(accountRepository.findById(i).get());
			statusAccountRepository.save(statusAccount);
		}
	}

	private static void extracted1(StatusServiceRepository statusServiceRepository,
								   ServiceRepository serviceRepository) {
		for (long i = 1; i <= 3; i++) {
			StatusService statusService = new StatusService();
			statusService.setState(ServiceState.ACTIVE);
			statusService.setStartDate(new Date());
			statusService.setEndDate(DateUtil.getInstance().getEndDate());
			statusService.setService(serviceRepository.findById(i).get());
			statusServiceRepository.save(statusService);
		}
	}


}
