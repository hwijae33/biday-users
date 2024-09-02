package shop.biday.users.service.imp;


import org.springframework.stereotype.Service;
import shop.biday.users.model.entity.UserEntity;
import shop.biday.users.model.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class    UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean save(Long id) {

        Optional users = usersRepository.findById(id);

        if(users.isPresent()) {

            usersRepository.save((UserEntity) users.get());
        }

        return false;
    }

    public List<UserEntity> findAll() {
        return usersRepository.findAll();
    }

    public UserEntity findByEmail(String email) { return usersRepository.findByEmail(email); }

    public List<UserEntity> findUsersList() { return usersRepository.findAll(); }

    public UserEntity findById(long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));


    }

    public boolean cancel(long id) {

        if(findByEmail(findById(id).getEmail()) == null) {
            usersRepository.cancel(id);
        }

        return false;
    }
}
