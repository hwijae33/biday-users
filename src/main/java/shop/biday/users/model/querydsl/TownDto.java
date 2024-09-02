package shop.biday.users.model.querydsl;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class TownDto {
    private String name;

    public TownDto(String name) {
        this.name = name;
    }
}
