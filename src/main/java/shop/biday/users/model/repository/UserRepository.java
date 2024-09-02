package shop.biday.users.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.biday.users.model.domain.UserModel;
import shop.biday.users.model.entity.UserEntity;

import java.util.Map;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
