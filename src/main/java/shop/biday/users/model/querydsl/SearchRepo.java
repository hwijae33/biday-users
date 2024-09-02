package shop.biday.users.model.querydsl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.biday.users.model.domain.AmenityListDTO;
import shop.biday.users.model.domain.RoomDetailDTO;
import shop.biday.users.model.domain.SearchDto;

import java.util.List;

public interface SearchRepo {
    List<DormDto> findList(SearchDto searchDto);

    Page<DormDto> findAllList(Pageable pageable);

    List<String> findByCity(String city);

    List<DormDto> findByFilter(FilterDto filterDto);

    List<RoomDetailDTO> findAllRoom(SearchDto searchDto, Long dormId);

    List<AmenityListDTO> findAmenity(Long dormId);
}
