package shop.biday.users.model.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.querydsl.ReviewDto;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsAndReviewDTO {

    private List<ReviewDto> reviews;
    private DormStatsDTO stats;

}
