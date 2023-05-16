package kg.bank.payments.model.entity.account;

import kg.bank.payments.model.entity.ServiceDetail;
import kg.bank.payments.model.entity.SubTransfer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<BalanceAccount> balanceList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<StatusAccount> statuseList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<ServiceDetail> serviceDetailList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<SubTransfer> subTransferList;
}
