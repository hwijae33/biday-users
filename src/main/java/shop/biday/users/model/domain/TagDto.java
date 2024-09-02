package shop.biday.users.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Tag;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    private Long id;
    private String name;
    private String PN;

    public Tag toEntity() {
        return Tag.builder()
                .name(name)
                .PN(PN)
                .build();
    }
}
