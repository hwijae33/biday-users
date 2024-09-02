package shop.biday.users.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.biday.users.model.domain.PaymentRequestDTO;
import shop.biday.users.model.entity.Payment;
import shop.biday.users.service.imp.PaymentService;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final PaymentService paymentService;

    @PostMapping("/confirm")
    public ResponseEntity<Payment> confirmPayment(
            @RequestBody PaymentRequestDTO paymentRequestDTO,
            @AuthenticationPrincipal Authentication authentication) {
        log.info("authentication: {}", authentication);
        log.info("paymentRequestDTO: {}", paymentRequestDTO);

        return new ResponseEntity<>(paymentService.confirmPayment(paymentRequestDTO), HttpStatus.OK);
    }
}
