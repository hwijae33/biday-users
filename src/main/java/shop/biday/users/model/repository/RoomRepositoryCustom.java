package shop.biday.users.model.repository;

import shop.biday.users.model.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepositoryCustom {
    Optional<Long> findRoomIdsByDormId(Long dormId);

    List<Room> getRoomByDormId(Long dormId);
}
