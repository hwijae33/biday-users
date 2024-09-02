package shop.biday.users.model.repository;

import shop.biday.users.model.querydsl.ReviewRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>, ReviewRepositoryCustom {

}
