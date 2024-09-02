package shop.biday.users.service.imp;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.RtagAddDTO;
import shop.biday.users.model.entity.Review;
import shop.biday.users.model.entity.Rtag;
import shop.biday.users.model.repository.ReviewRepository;
import shop.biday.users.model.repository.RtagRepository;
import shop.biday.users.model.repository.TagRepository;


@Service
@Transactional
@RequiredArgsConstructor
public class RtagServiceImpl  {

    private final ReviewRepository REVIEWREPOSITORY;
    private final RtagRepository RTAGREPOSITORY;
    private final TagRepository TAGREPOSITORY;

    @Transactional
    public boolean insert(RtagAddDTO rtagAddDTO) {

        Review review = REVIEWREPOSITORY.findById(rtagAddDTO.getReviewId())
                .orElseThrow(() -> new RuntimeException("올바르지 않은 리뷰 Id"));

        Rtag rtag = rtagAddDTO.toEntity(TAGREPOSITORY, review);

        RTAGREPOSITORY.save(rtag);
        return false;
    }
}
