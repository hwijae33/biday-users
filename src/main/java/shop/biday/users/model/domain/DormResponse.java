package shop.biday.users.model.domain;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DormResponse {

    private Long id;
    private String name;
    private String description;
}
