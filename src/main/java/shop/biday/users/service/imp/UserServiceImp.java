package shop.biday.users.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.UserModel;
import shop.biday.users.model.entity.UserEntity;
import shop.biday.users.model.repository.UserRepository;
import shop.biday.users.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {


    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity save(UserModel user) {
        return null;
    }


    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }


}
