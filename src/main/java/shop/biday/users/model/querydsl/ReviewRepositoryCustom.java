package shop.biday.users.model.querydsl;



import shop.biday.users.model.domain.DormStatsDTO;
import shop.biday.users.model.domain.StatsAndReviewDTO;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<ReviewDto> findReviewsByDormId(Long dormId);

    DormStatsDTO calculateDormReviewStats(Long dormId);

    StatsAndReviewDTO makeStatsAndReviews(Long dormId);

    Double calculateAverageRate(Long dormId);

}
