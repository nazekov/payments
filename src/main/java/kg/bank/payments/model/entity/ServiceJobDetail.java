package kg.bank.payments.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_service_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ServiceJobDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    ServiceJob serviceJob;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    @Column(name = "percent_sum")
    BigDecimal percentSum;

    @Column(name = "fix_sum")
    BigDecimal fixSum;
}
