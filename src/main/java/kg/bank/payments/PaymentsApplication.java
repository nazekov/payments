package kg.bank.payments;

import kg.bank.payments.enums.AccountStatus;
import kg.bank.payments.enums.ServiceJobStatus;
import kg.bank.payments.model.entity.ServiceJob;
import kg.bank.payments.model.entity.ServiceJobDetail;
import kg.bank.payments.repository.*;
import kg.bank.payments.utils.DateUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
								 AccountRepository accountRepository,
								 ServiceJobDetailRepository serviceJobDetailRepository
								 ) {
		return args -> {
			extracted1(serviceJobRepository);
//			extracted2(accountRepository);
//			extracted3(serviceJobRepository, accountRepository, serviceJobDetailRepository);
//			extracted4(serviceJobRepository, accountRepository, serviceJobDetailRepository);
//			extracted5(serviceJobRepository, accountRepository, serviceJobDetailRepository);
		};
	}

	private static void extracted6(AccountRepository accountRepository) {
		for (long i = 1; i <= 10; i++) {

		}
	}

	private static void extracted5(ServiceJobRepository serviceJobRepository,
								   AccountRepository accountRepository,
								   ServiceJobDetailRepository serviceJobDetailRepository) {
		ServiceJobDetail serviceJobDetail3_1 = new ServiceJobDetail();
		serviceJobDetail3_1.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_1.setAccount(accountRepository.findById(1L).get());
		serviceJobDetail3_1.setPercentSum(new BigDecimal(15));


		ServiceJobDetail serviceJobDetail3_2 = new ServiceJobDetail();
		serviceJobDetail3_2.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_2.setAccount(accountRepository.findById(2L).get());
		serviceJobDetail3_2.setPercentSum(new BigDecimal(15));

		ServiceJobDetail serviceJobDetail3_3 = new ServiceJobDetail();
		serviceJobDetail3_3.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_3.setAccount(accountRepository.findById(3L).get());
		serviceJobDetail3_3.setPercentSum(new BigDecimal(7));

		ServiceJobDetail serviceJobDetail3_4 = new ServiceJobDetail();
		serviceJobDetail3_4.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_4.setAccount(accountRepository.findById(4L).get());
		serviceJobDetail3_4.setPercentSum(new BigDecimal(12));

		ServiceJobDetail serviceJobDetail3_5 = new ServiceJobDetail();
		serviceJobDetail3_5.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_5.setAccount(accountRepository.findById(9L).get());
		serviceJobDetail3_5.setPercentSum(new BigDecimal(33));

		ServiceJobDetail serviceJobDetail3_6 = new ServiceJobDetail();
		serviceJobDetail3_6.setServiceJob(serviceJobRepository.findById(3L).get());
		serviceJobDetail3_6.setAccount(accountRepository.findById(10L).get());
		serviceJobDetail3_6.setPercentSum(new BigDecimal(18));

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

		ServiceJobDetail serviceJobDetail2_2 = new ServiceJobDetail();
		serviceJobDetail2_2.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_2.setAccount(accountRepository.findById(2L).get());
		serviceJobDetail2_2.setPercentSum(new BigDecimal(11));

		ServiceJobDetail serviceJobDetail2_3 = new ServiceJobDetail();
		serviceJobDetail2_3.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_3.setAccount(accountRepository.findById(3L).get());
		serviceJobDetail2_3.setPercentSum(new BigDecimal(5));

		ServiceJobDetail serviceJobDetail2_4 = new ServiceJobDetail();
		serviceJobDetail2_4.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_4.setAccount(accountRepository.findById(4L).get());
		serviceJobDetail2_4.setPercentSum(new BigDecimal(8));

		ServiceJobDetail serviceJobDetail2_5 = new ServiceJobDetail();
		serviceJobDetail2_5.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_5.setAccount(accountRepository.findById(7L).get());
		serviceJobDetail2_5.setPercentSum(new BigDecimal(33));

		ServiceJobDetail serviceJobDetail2_6 = new ServiceJobDetail();
		serviceJobDetail2_6.setServiceJob(serviceJobRepository.findById(2L).get());
		serviceJobDetail2_6.setAccount(accountRepository.findById(8L).get());
		serviceJobDetail2_6.setPercentSum(new BigDecimal(33));

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

		ServiceJobDetail serviceJobDetail1_2 = new ServiceJobDetail();
		serviceJobDetail1_2.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_2.setAccount(accountRepository.findById(2L).get());
		serviceJobDetail1_2.setPercentSum(new BigDecimal(5));

		ServiceJobDetail serviceJobDetail1_3 = new ServiceJobDetail();
		serviceJobDetail1_3.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_3.setAccount(accountRepository.findById(3L).get());
		serviceJobDetail1_3.setPercentSum(new BigDecimal(2));

		ServiceJobDetail serviceJobDetail1_4 = new ServiceJobDetail();
		serviceJobDetail1_4.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_4.setAccount(accountRepository.findById(4L).get());
		serviceJobDetail1_4.setPercentSum(new BigDecimal(20));

		ServiceJobDetail serviceJobDetail1_5 = new ServiceJobDetail();
		serviceJobDetail1_5.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_5.setAccount(accountRepository.findById(5L).get());
		serviceJobDetail1_5.setPercentSum(new BigDecimal(30));

		ServiceJobDetail serviceJobDetail1_6 = new ServiceJobDetail();
		serviceJobDetail1_6.setServiceJob(serviceJobRepository.findById(1L).get());
		serviceJobDetail1_6.setAccount(accountRepository.findById(6L).get());
		serviceJobDetail1_6.setPercentSum(new BigDecimal(30));

		List<ServiceJobDetail> list1 = Arrays.asList(
				serviceJobDetail1_1, serviceJobDetail1_2, serviceJobDetail1_3,
				serviceJobDetail1_4, serviceJobDetail1_5, serviceJobDetail1_6
		);

		serviceJobDetailRepository.saveAll(list1);
	}

	private static void extracted2(AccountRepository accountRepository) {
		for (long i = 1; i <= 10; i++) {

		}
	}

	private static void extracted1(ServiceJobRepository serviceJobRepository) {
		for (long i = 1; i <= 3; i++) {
			ServiceJob.builder()
					.name("")
					.status(ServiceJobStatus.ACTIVE);
		}
	}
}
