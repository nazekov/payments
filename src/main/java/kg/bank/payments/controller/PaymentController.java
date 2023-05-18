package kg.bank.payments.controller;

import kg.bank.payments.model.entity.Payment;
import kg.bank.payments.model.xml.Body;
import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/pay",
                produces = {"application/xml"},
                consumes = {"application/xml"})
    public ResponseEntity<XmlData> pay(@RequestBody XmlData request) {
        String op = request.getHead().getOp();
        XmlData response = null;
        if (op.equals("QE11")) {
            response = paymentService.check(request);
        } else if (op.equals("QE10")) {
//            return pay(request);
            BigDecimal sum = new BigDecimal(request.getBody().getSum());
//            String phone = request.getBody().getParam1();

            Payment payment = paymentService.pay(request);
            try {
                paymentService.distributePaymentToAccounts(
                        payment.getServiceJob().getId(),
                        sum, payment);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            response = XmlData.builder()
                    .head(request.getHead())
                    .body(Body.builder()
                            .status("250")
                            .msg("Платеж успешно проведен")
                            .build())
                    .build();
        }
//        XmlData response = paymentService.execute(request);
        return ResponseEntity.ok(response);
    }
}
