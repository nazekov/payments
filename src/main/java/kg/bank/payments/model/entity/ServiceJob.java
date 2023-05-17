package kg.bank.payments.model.entity;

import kg.bank.payments.enums.ServiceJobStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ServiceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    ServiceJobStatus status;

    @OneToMany(mappedBy = "serviceJob", cascade = CascadeType.ALL)
    List<ServiceJobDetail> serviceJobDetailList;

    @OneToMany(mappedBy = "serviceJob", cascade = CascadeType.ALL)
    List<Payment> paymentList;
}
