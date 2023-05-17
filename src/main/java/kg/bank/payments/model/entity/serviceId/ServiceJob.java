package kg.bank.payments.model.entity.serviceId;

import kg.bank.payments.model.entity.ServiceJobDetail;
import kg.bank.payments.model.entity.Transfer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class ServiceJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

//    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
//    List<BalanceService> balanceList;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<StatusServiceJob> statuseList;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<ServiceJobDetail> serviceJobDetailList;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<Transfer> transferList;
}
