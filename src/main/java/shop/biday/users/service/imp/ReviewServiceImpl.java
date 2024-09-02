package shop.biday.users.service.imp;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.DormStatsDTO;
import shop.biday.users.model.domain.ReviewAddDTO;
import shop.biday.users.model.domain.StatsAndReviewDTO;
import shop.biday.users.model.entity.Booking;
import shop.biday.users.model.entity.Review;
import shop.biday.users.model.entity.UserEntity;
import shop.biday.users.model.querydsl.ReviewDto;
import shop.biday.users.model.repository.BookingRepository;
import shop.biday.users.model.repository.ReviewRepository;
import shop.biday.users.model.repository.UsersRepository;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl  {
    private final UsersRepository USERSREPOSITORY;
    private final BookingRepository BOOKINGREPOSITORY;
    private final ReviewRepository REVIEWREPOSITORY;

    @Transactional
    public Long write(ReviewAddDTO reviewAddDTO) {
        UserEntity user = USERSREPOSITORY.findById(reviewAddDTO.getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));
        Booking booking = BOOKINGREPOSITORY.findById(reviewAddDTO.getBooking_id()).orElseThrow(() -> new RuntimeException("Booking not found"));

        Review review = Review.builder()
                .content(reviewAddDTO.getContent())
                .rate(reviewAddDTO.getRate())
                .booking(booking)
                .users(user)
                .build();

        return REVIEWREPOSITORY.save(review).getId();

    }

    public List<ReviewDto> getReviewsByDormId(Long dormId) {
        List<ReviewDto> reviews = REVIEWREPOSITORY.findReviewsByDormId(dormId);
        System.out.println("reviews = " + reviews);

        return reviews;
    }

    public DormStatsDTO getDormStatsByDormId(Long dormId) {
        DormStatsDTO dormStats = REVIEWREPOSITORY.calculateDormReviewStats(dormId);
        System.out.println("dormStats = " + dormStats);

        return dormStats;
    }

    public StatsAndReviewDTO getStatsAndReviews(Long dormId) {
        return REVIEWREPOSITORY.makeStatsAndReviews(dormId);
    }

}
