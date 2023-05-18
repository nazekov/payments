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
        return ResponseEntity.ok(paymentService.execute(request));
    }
}
