package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Review;
import shop.biday.users.model.entity.Rtag;
import shop.biday.users.model.entity.Tag;
import shop.biday.users.model.repository.TagRepository;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RtagAddDTO {

    private List<Long> tagId;

    private Review review;
    private Long reviewId;

    public Rtag toEntity(TagRepository tagRepository, Review review) {
        Tag tag = tagRepository.findById(tagId.get(0))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 tagId"));


        return Rtag.builder()
                .tag(tag)
                .review(review)
                .build();
    }



}

