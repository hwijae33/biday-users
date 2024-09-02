package shop.biday.users.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Tag;


public interface TagRepository extends JpaRepository<Tag, Long> {
}
