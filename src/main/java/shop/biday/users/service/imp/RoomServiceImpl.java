package shop.biday.users.service.imp;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.RoomAddDTO;
import shop.biday.users.model.domain.RoomDetailDTO;
import shop.biday.users.model.entity.Dorm;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.repository.DormRepository;
import shop.biday.users.model.repository.RoomRepository;
import shop.biday.users.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final DormRepository DORMREPOSITORY;
    private final RoomRepository ROOMREPOSITORY;

    @Transactional
    public Long insert(RoomAddDTO roomAddDTO) {

        Optional<Dorm> dormOptional = DORMREPOSITORY.findById(roomAddDTO.getDormId());

        Dorm dorm = dormOptional.orElseThrow(() -> new RuntimeException("Dorm not found"));

        Room room = Room.builder()
                .name(roomAddDTO.getName())
                .description(roomAddDTO.getDescription())
                .person(roomAddDTO.getPerson())
                .price(roomAddDTO.getPrice())
                .type(roomAddDTO.getType())
                .dorm(dorm)
                .build();

        return ROOMREPOSITORY.save(room).getId();
    }

    @Override
    public List<Long> getRoomIdsByDormId(Long dormId) {
        return ROOMREPOSITORY.findByDormId(dormId)
                .stream()
                .map(Room::getId)
                .toList();
    }

    @Override
    public Optional<Long> findRoomIdByDormId(Long dormId) {
        return ROOMREPOSITORY.findByDormId(dormId).stream().findFirst().map(Room::getId);
    }

    @Override
    public List<RoomDetailDTO> getRoomByDormId(Long dormId) {
    List<Room> rooms = ROOMREPOSITORY.findByDormId(dormId);
        return rooms.stream()
                .map(RoomDetailDTO::new)
                .toList();
    }
}
