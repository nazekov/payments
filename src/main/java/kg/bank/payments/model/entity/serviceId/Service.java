package kg.bank.payments.model.entity.serviceId;

import kg.bank.payments.model.entity.ServiceDetail;
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
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<BalanceService> balances;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<StatusService> statuses;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<ServiceDetail> serviceDetails;
}
