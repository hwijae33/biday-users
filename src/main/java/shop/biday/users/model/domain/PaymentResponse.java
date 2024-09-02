package shop.biday.users.model.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private Long id;
    private String orderId;
    private int totalAmount;

}
