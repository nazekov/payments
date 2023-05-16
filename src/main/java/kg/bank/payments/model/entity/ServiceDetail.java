package kg.bank.payments.model.entity;

import kg.bank.payments.model.entity.account.Account;
import kg.bank.payments.model.entity.serviceId.Service;
import kg.bank.payments.utils.DateUtil;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_service_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    Service service;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    @Column(name = "percent_price")
    BigDecimal percentPrice;

    @Column(name = "fix_price")
    BigDecimal fixPrice;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "start_date", nullable = false)
    Date startDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "end_date", nullable = false)
    Date endDate;

    @PrePersist
    private void setDates() {
        setStartDate(new Date());
        setEndDate(DateUtil.getInstance().getEndDate());
    }
}
