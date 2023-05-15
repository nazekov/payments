package kg.bank.payments.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
}
