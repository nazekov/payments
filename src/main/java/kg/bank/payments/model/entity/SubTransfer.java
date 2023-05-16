package kg.bank.payments.model.entity;

import kg.bank.payments.enums.PaymentState;
import kg.bank.payments.enums.ServiceState;
import kg.bank.payments.model.entity.account.Account;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_sub_transfers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "money")
    BigDecimal money;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    PaymentState paymentState;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "created_date", nullable = false)
    Date created;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    Transfer transfer;
}
