package shop.biday.users.model.domain;

public record PaymentRequestDTO(
        String paymentKey,
        String orderId,
        int amount,
        Long userId,
        Long roomId,
        int person,
        String checkIn,
        String checkOut
) {
}
