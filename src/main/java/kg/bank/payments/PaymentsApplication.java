package kg.bank.payments;

import kg.bank.payments.enums.AccountState;
import kg.bank.payments.enums.ServiceJobState;
import kg.bank.payments.model.entity.ServiceJobDetail;
import kg.bank.payments.model.entity.account.BalanceAccount;
import kg.bank.payments.model.entity.account.StatusAccount;
import kg.bank.payments.model.entity.serviceId.StatusServiceJob;
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
	public CommandLineRunner run(ServiceJobRepository serviceJobRepository,
								 StatusServiceJobRepository statusServiceJobRepository,
								 AccountRepository accountRepository,
								 StatusAccountRepository statusAccountRepository,
								 ServiceJobDetailRepository serviceJobDetailRepository,
								 BalanceAccountRepository balanceAccountRepository) {
		return args -> {
//			extracted1(statusServiceJobRepository, serviceJobRepository);
//			extracted2(accountRepository, statusAccountRepository);
//			extracted3(serviceJobRepository, accountRepository, serviceJobDetailRepository);
//			extracted4(serviceJobRepository, accountRepository, serviceJobDetailRepository);
//			extracted5(serviceJobRepository, accountRepository, serviceJobDetailRepository);
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

	private static void extracted5(ServiceJobRepository serviceJobRepository,
								   AccountRepository accountRepository,
								   ServiceJobDetailRepository serviceJobDetailRepository) {
		ServiceJobDetail serviceJobDetail3_1 = new ServiceJobDetail();
		serviceJobDetail3_1.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_1.setAccount(accountRepository.findById(1L).get());
		serviceJobDetail3_1.setPercentSum(new BigDecimal(15));
		serviceJobDetail3_1.setStartDate(new Date());
		serviceJobDetail3_1.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail3_2 = new ServiceJobDetail();
		serviceJobDetail3_2.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_2.setAccount(accountRepository.findById(2L).get());
		serviceJobDetail3_2.setPercentSum(new BigDecimal(15));
		serviceJobDetail3_2.setStartDate(new Date());
		serviceJobDetail3_2.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail3_3 = new ServiceJobDetail();
		serviceJobDetail3_3.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_3.setAccount(accountRepository.findById(3L).get());
		serviceJobDetail3_3.setPercentSum(new BigDecimal(7));
		serviceJobDetail3_3.setStartDate(new Date());
		serviceJobDetail3_3.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail3_4 = new ServiceJobDetail();
		serviceJobDetail3_4.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_4.setAccount(accountRepository.findById(4L).get());
		serviceJobDetail3_4.setPercentSum(new BigDecimal(12));
		serviceJobDetail3_4.setStartDate(new Date());
		serviceJobDetail3_4.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail3_5 = new ServiceJobDetail();
		serviceJobDetail3_5.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_5.setAccount(accountRepository.findById(9L).get());
		serviceJobDetail3_5.setPercentSum(new BigDecimal(33));
		serviceJobDetail3_5.setStartDate(new Date());
		serviceJobDetail3_5.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail3_6 = new ServiceJobDetail();
		serviceJobDetail3_6.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_6.setAccount(accountRepository.findById(10L).get());
		serviceJobDetail3_6.setPercentSum(new BigDecimal(18));
		serviceJobDetail3_6.setStartDate(new Date());
		serviceJobDetail3_6.setEndDate(DateUtil.getInstance().getEndDate());

		List<ServiceJobDetail> list3 = Arrays.asList(
				serviceJobDetail3_1, serviceJobDetail3_2, serviceJobDetail3_3,
				serviceJobDetail3_4, serviceJobDetail3_5, serviceJobDetail3_6
		);

		serviceJobDetailRepository.saveAll(list3);
	}

	private static void extracted4(ServiceJobRepository serviceJobRepository,
								   AccountRepository accountRepository,
								   ServiceJobDetailRepository serviceJobDetailRepository) {
		ServiceJobDetail serviceJobDetail2_1 = new ServiceJobDetail();
		serviceJobDetail2_1.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_1.setAccount(accountRepository.findById(1L).get());
		serviceJobDetail2_1.setPercentSum(new BigDecimal(10));
		serviceJobDetail2_1.setStartDate(new Date());
		serviceJobDetail2_1.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail2_2 = new ServiceJobDetail();
		serviceJobDetail2_2.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_2.setAccount(accountRepository.findById(2L).get());
		serviceJobDetail2_2.setPercentSum(new BigDecimal(11));
		serviceJobDetail2_2.setStartDate(new Date());
		serviceJobDetail2_2.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail2_3 = new ServiceJobDetail();
		serviceJobDetail2_3.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_3.setAccount(accountRepository.findById(3L).get());
		serviceJobDetail2_3.setPercentSum(new BigDecimal(5));
		serviceJobDetail2_3.setStartDate(new Date());
		serviceJobDetail2_3.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail2_4 = new ServiceJobDetail();
		serviceJobDetail2_4.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_4.setAccount(accountRepository.findById(4L).get());
		serviceJobDetail2_4.setPercentSum(new BigDecimal(8));
		serviceJobDetail2_4.setStartDate(new Date());
		serviceJobDetail2_4.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail2_5 = new ServiceJobDetail();
		serviceJobDetail2_5.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_5.setAccount(accountRepository.findById(7L).get());
		serviceJobDetail2_5.setPercentSum(new BigDecimal(33));
		serviceJobDetail2_5.setStartDate(new Date());
		serviceJobDetail2_5.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail2_6 = new ServiceJobDetail();
		serviceJobDetail2_6.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_6.setAccount(accountRepository.findById(8L).get());
		serviceJobDetail2_6.setPercentSum(new BigDecimal(33));
		serviceJobDetail2_6.setStartDate(new Date());
		serviceJobDetail2_6.setEndDate(DateUtil.getInstance().getEndDate());

		List<ServiceJobDetail> list2 = Arrays.asList(
				serviceJobDetail2_1, serviceJobDetail2_2, serviceJobDetail2_3,
				serviceJobDetail2_4, serviceJobDetail2_5, serviceJobDetail2_6
		);

		serviceJobDetailRepository.saveAll(list2);
	}

	private static void extracted3(ServiceJobRepository serviceJobRepository,
								   AccountRepository accountRepository,
								   ServiceJobDetailRepository serviceJobDetailRepository) {
		ServiceJobDetail serviceJobDetail1_1 = new ServiceJobDetail();
		serviceJobDetail1_1.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_1.setAccount(accountRepository.findById(1L).get());
		serviceJobDetail1_1.setPercentSum(new BigDecimal(13));
		serviceJobDetail1_1.setStartDate(new Date());
		serviceJobDetail1_1.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail1_2 = new ServiceJobDetail();
		serviceJobDetail1_2.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_2.setAccount(accountRepository.findById(2L).get());
		serviceJobDetail1_2.setPercentSum(new BigDecimal(5));
		serviceJobDetail1_2.setStartDate(new Date());
		serviceJobDetail1_2.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail1_3 = new ServiceJobDetail();
		serviceJobDetail1_3.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_3.setAccount(accountRepository.findById(3L).get());
		serviceJobDetail1_3.setPercentSum(new BigDecimal(2));
		serviceJobDetail1_3.setStartDate(new Date());
		serviceJobDetail1_3.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail1_4 = new ServiceJobDetail();
		serviceJobDetail1_4.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_4.setAccount(accountRepository.findById(4L).get());
		serviceJobDetail1_4.setPercentSum(new BigDecimal(20));
		serviceJobDetail1_4.setStartDate(new Date());
		serviceJobDetail1_4.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail1_5 = new ServiceJobDetail();
		serviceJobDetail1_5.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_5.setAccount(accountRepository.findById(5L).get());
		serviceJobDetail1_5.setPercentSum(new BigDecimal(30));
		serviceJobDetail1_5.setStartDate(new Date());
		serviceJobDetail1_5.setEndDate(DateUtil.getInstance().getEndDate());

		ServiceJobDetail serviceJobDetail1_6 = new ServiceJobDetail();
		serviceJobDetail1_6.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_6.setAccount(accountRepository.findById(6L).get());
		serviceJobDetail1_6.setPercentSum(new BigDecimal(30));
		serviceJobDetail1_6.setStartDate(new Date());
		serviceJobDetail1_6.setEndDate(DateUtil.getInstance().getEndDate());

		List<ServiceJobDetail> list1 = Arrays.asList(
				serviceJobDetail1_1, serviceJobDetail1_2, serviceJobDetail1_3,
				serviceJobDetail1_4, serviceJobDetail1_5, serviceJobDetail1_6
		);

		serviceJobDetailRepository.saveAll(list1);
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

	private static void extracted1(StatusServiceJobRepository statusServiceJobRepository,
								   ServiceJobRepository serviceJobRepository) {
		for (long i = 1; i <= 3; i++) {
			StatusServiceJob statusServiceJob = new StatusServiceJob();
			statusServiceJob.setState(ServiceJobState.ACTIVE);
			statusServiceJob.setStartDate(new Date());
			statusServiceJob.setEndDate(DateUtil.getInstance().getEndDate());
			statusServiceJob.setServiceJob(serviceJobRepository.findById(i).get());
			statusServiceJobRepository.save(statusServiceJob);
		}
	}


}
