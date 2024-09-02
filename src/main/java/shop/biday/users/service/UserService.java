package shop.biday.users.service;

import shop.biday.users.model.domain.UserModel;
import shop.biday.users.model.entity.UserEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface UserService {
    List<UserEntity> findAll();

    UserEntity save(UserModel user);

    Optional<UserEntity> findById(Long id);

    long count();

    void deleteById(Long id);

    boolean existsById(Long id);

//    Map<?,?> login(UserModel model);
}
