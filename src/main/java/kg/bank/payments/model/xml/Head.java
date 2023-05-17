package kg.bank.payments.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HEAD")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Head {

    @XmlAttribute(name = "DTS")
    String dts;

    @XmlAttribute(name = "QM")
    String qm;

    @XmlAttribute(name = "QID")
    String qid;

    @XmlAttribute(name = "OP")
    String op;
}
