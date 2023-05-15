package kg.bank.payments.model.entity.serviceId;

import kg.bank.payments.enums.Status;
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
public class StatusService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ACTIVE")
    Status status;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(nullable = false)
    Date startDate;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(nullable = false)
    Date endDate;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    Service service;

    @PrePersist
    private void setDates() {
        setStartDate(new Date());
        setEndDate(DateUtil.getInstance().getEndDate());
    }
}
