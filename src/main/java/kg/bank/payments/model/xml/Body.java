package kg.bank.payments.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Body {

    @XmlAttribute(name = "SERVICE_ID")
    String serviceId;

    @XmlAttribute(name = "PARAM1")
    String param1;

    @XmlAttribute(name = "STATUS")
    String status;

    @XmlAttribute(name = "MSG")
    String msg;

    @XmlAttribute(name = "ERR_MSG")
    String errMsg;

    @XmlAttribute(name = "SUM")
    String sum;
}
