package kg.bank.payments.model.entity;

import kg.bank.payments.enums.PaymentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_sub_payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SubPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "sum")
    BigDecimal sum;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    PaymentStatus status;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "created_date", nullable = false)
    Date created;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    Payment payment;
}
