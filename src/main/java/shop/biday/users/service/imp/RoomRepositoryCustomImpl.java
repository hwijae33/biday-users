package shop.biday.users.service.imp;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.repository.RoomRepositoryCustom;

import java.util.List;
import java.util.Optional;



@Repository
@RequiredArgsConstructor
@Primary
public class RoomRepositoryCustomImpl implements RoomRepositoryCustom {


    @Override
    public Optional<Long> findRoomIdsByDormId(Long dormId) {
        return Optional.empty();
    }

    @Override
    public List<Room> getRoomByDormId(Long dormId) {
        return List.of();
    }
}

