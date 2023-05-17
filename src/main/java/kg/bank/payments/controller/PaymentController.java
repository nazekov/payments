package kg.bank.payments.controller;

import kg.bank.payments.model.xml.XmlData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class PaymentController {


    @PostMapping(value = "/checkPayment", produces = {"application/xml"})
    public ResponseEntity<XmlData> checkPayment(@RequestBody XmlData request) {
        System.out.println("XmlData: " + request);
        return ResponseEntity.ok(request);
    }
}
