package shop.biday.users.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.biday.users.model.entity.UserEntity;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    UserEntity save(UserEntity users);

    UserEntity findByEmailAndPassword(String email, String password);

    List<UserEntity> findAll();

    UserEntity findByEmail(String email);

    @Modifying
    @Query("UPDATE UserEntity u SET u.status = 'N' WHERE u.id = :id")
    boolean cancel(@Param("id") long id);
}
