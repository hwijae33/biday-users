package shop.biday.users.model.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Dorm;
import shop.biday.users.model.entity.UserEntity;
import shop.biday.users.model.querydsl.DormRepositoryCustom;

import java.util.List;
import java.util.Optional;

public interface DormRepository extends JpaRepository<Dorm, Long>, DormRepositoryCustom {

    @Override
    Optional<Dorm> findById(Long id);

    List<Dorm> findByUser(UserEntity user);

    List<Dorm> findByStatus(String status);

    boolean existsByAddress(String address);
}
