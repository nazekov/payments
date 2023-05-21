package kg.bank.payments.model.entity;

import kg.bank.payments.enums.AccountStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    AccountStatus status;

    @Column(name = "balance")
    BigDecimal balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<ServiceJobDetail> serviceJobDetailList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<SubPayment> subPaymentList;
}
