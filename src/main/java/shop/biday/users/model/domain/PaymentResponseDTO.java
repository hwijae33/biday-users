package shop.biday.users.model.domain;



import shop.biday.users.model.entity.Payment;
import shop.biday.users.model.entity.UserEntity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public record PaymentResponseDTO(
        String paymentKey,
        String orderId,
        int totalAmount,
        String status,
        String approvedAt
) {
    public Payment toEntity(final UserEntity users) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(approvedAt, formatter);

        return Payment.builder()
                .paymentKey(paymentKey)
                .orderId(orderId)
                .totalAmount(totalAmount)
                .status(status)
                .approvedAt(zonedDateTime.toLocalDateTime())
                .users(users)
                .build();
    }
}
