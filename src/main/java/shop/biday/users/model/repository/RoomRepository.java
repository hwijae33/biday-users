package shop.biday.users.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Override
    Optional<Room> findById(Long id);

    List<Room> findByDormId(Long dormId);
}
