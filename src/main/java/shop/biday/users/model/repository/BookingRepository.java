package shop.biday.users.model.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @EntityGraph(attributePaths = {"users", "room", "payment"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select b, u.id, u.email, u.name, u.phoneNum, u.role, r, p from Booking b"
//            + " join fetch b.users u"
//            + " join fetch b.room r"
//            + " join fetch b.payment p"
//            + " where u.id = :id")
    List<Booking> findByUsersId(Long id);
}
