package kg.bank.payments.controller;

import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/checkPayment", produces = {"application/xml"})
    public ResponseEntity<XmlData> checkPayment(@RequestBody XmlData request) {
        XmlData response = paymentService.checkPayment(request);
        return ResponseEntity.ok(response);
    }
}
