package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Review;
import shop.biday.users.model.entity.Rtag;
import shop.biday.users.model.entity.Tag;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RtagDto {
    private Long id;
    private Review review;
    private Tag tag;

    public Rtag toEntity() {
        return Rtag.builder()
                .review(review)
                .tag(tag)
                .build();
    }
}
