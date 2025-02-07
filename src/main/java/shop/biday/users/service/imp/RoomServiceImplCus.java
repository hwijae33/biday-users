package shop.biday.users.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.repository.RoomRepositoryCustom;
import shop.biday.users.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImplCus implements RoomRepositoryCustom {


    private final RoomService ROOMSERVICE;

    @Qualifier("roomRepositoryCustomImpl")
    private final RoomRepositoryCustom ROOMREPOSITORYCUSTOM;

    @Override
    public Optional<Long> findRoomIdsByDormId(Long dormId) {
        return ROOMSERVICE.findRoomIdByDormId(dormId);

    }

    @Override
    public List<Room> getRoomByDormId(Long dormId) {
        return ROOMREPOSITORYCUSTOM.getRoomByDormId(dormId);
    }


}
