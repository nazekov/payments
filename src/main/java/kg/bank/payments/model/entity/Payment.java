package kg.bank.payments.model.entity;

import kg.bank.payments.enums.PaymentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "post_money", nullable = false)
    BigDecimal postMoney;

    @Column(name = "distributed_money")
    BigDecimal distributedMoney;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss:S")
    @Column(name = "created_date", nullable = false)
    Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    PaymentStatus status;

    @Column(name = "phone", nullable = false)
    String phone;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    ServiceJob serviceJob;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    List<SubPayment> subPaymentList;
}
