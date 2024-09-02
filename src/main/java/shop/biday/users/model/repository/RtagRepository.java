package shop.biday.users.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Rtag;


public interface RtagRepository extends JpaRepository<Rtag, Long> {
}
