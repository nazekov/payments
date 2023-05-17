package kg.bank.payments.model.entity.serviceId;

import kg.bank.payments.enums.ServiceJobState;
import kg.bank.payments.utils.DateUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_service_statuses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusServiceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    ServiceJobState state;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "start_date", nullable = false)
    Date startDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "end_date", nullable = false)
    Date endDate;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    ServiceJob serviceJob;

    @PrePersist
    private void setDates() {
        setStartDate(new Date());
        setEndDate(DateUtil.getInstance().getEndDate());
    }
}
