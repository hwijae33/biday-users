package shop.biday.users.model.domain;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {

    private Long id;
    private String name;
    private int price;
}
