package kg.bank.payments.controller;

import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/pay",
                produces = {"application/xml"},
                consumes = {"application/xml"})
    public ResponseEntity<XmlData> pay(@RequestBody XmlData request) {
        log.info("request: " + request);
        return ResponseEntity.ok(paymentService.execute(request));
    }
}
