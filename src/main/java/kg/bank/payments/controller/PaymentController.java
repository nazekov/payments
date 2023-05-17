package kg.bank.payments.controller;

import kg.bank.payments.model.xml.XmlData;
import kg.bank.payments.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     *
     * request Должен прийти только на один метод
     * Надо будет объединить оба метода в один
     * Разделение пойдет согласно QE11, QE10
     */

    @PostMapping(value = "/pay", produces = {"application/xml"})
    public ResponseEntity<XmlData> pay(@RequestBody XmlData request) {
        XmlData response = paymentService.execute(request);
        return ResponseEntity.ok(response);
    }
}
